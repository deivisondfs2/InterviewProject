package com.InterviewProject.InterviewProject.model;

import com.InterviewProject.InterviewProject.infra.HibernateTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "functionary_point_record")
public class FunctionaryPointRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functionary_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JsonManagedReference
    private Functionary functionary;

    @Column(name = "date_point")
    @Type(type = HibernateTypes.JODA_LOCAL_DATE)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate datePoint;

    @Column(name = "hour_point")
    @Type(type = HibernateTypes.JODA_LOCAL_TIME)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hourPoint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Functionary getFunctionary() {
        return functionary;
    }

    public void setFunctionary(Functionary functionary) {
        this.functionary = functionary;
    }

    public LocalDate getDatePoint() {
        return datePoint;
    }

    public void setDatePoint(LocalDate datePoint) {
        this.datePoint = datePoint;
    }

    public LocalTime getHourPoint() {
        return hourPoint;
    }

    public void setHourPoint(LocalTime hourPoint) {
        this.hourPoint = hourPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FunctionaryPointRecord that = (FunctionaryPointRecord) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(functionary, that.functionary)
                .append(datePoint, that.datePoint)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(functionary)
                .append(datePoint)
                .toHashCode();
    }
}

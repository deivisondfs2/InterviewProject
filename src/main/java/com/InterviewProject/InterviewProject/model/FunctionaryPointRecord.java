package com.InterviewProject.InterviewProject.model;

import com.InterviewProject.InterviewProject.infra.HibernateTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

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
    private Functionary functionary;

    @Column(name = "date_point")
    @Type(type = HibernateTypes.JODA_LOCAL_DATE)
    @NotNull
    private LocalDate datePoint;

}

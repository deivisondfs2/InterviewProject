package com.InterviewProject.InterviewProject.dao;

import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IfunctionaryPointRecordDAO extends JpaRepository<FunctionaryPointRecord, Long> {

    public List<FunctionaryPointRecord> findByDatePointAndFunctionary(LocalDate datePoint, Functionary functionary);

}

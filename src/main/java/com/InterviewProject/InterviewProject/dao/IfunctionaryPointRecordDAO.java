package com.InterviewProject.InterviewProject.dao;

import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IfunctionaryPointRecordDAO extends JpaRepository<FunctionaryPointRecord, Long> {

}

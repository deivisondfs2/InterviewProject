package com.InterviewProject.InterviewProject.service;

import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import org.joda.time.LocalDate;

import java.util.List;

public interface IFunctionaryPointRecordService {

    void createFunctionaryPoint(FunctionaryPointRecord functionaryPointRecord);

    List<FunctionaryPointRecord> findByDatePointAndFunctionary(LocalDate datePoint, String pis);
}

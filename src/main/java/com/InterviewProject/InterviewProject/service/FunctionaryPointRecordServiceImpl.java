package com.InterviewProject.InterviewProject.service;

import com.InterviewProject.InterviewProject.dao.IFunctionaryDao;
import com.InterviewProject.InterviewProject.dao.IfunctionaryPointRecordDAO;
import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionaryPointRecordServiceImpl implements IFunctionaryPointRecordService {

    @Autowired
    IfunctionaryPointRecordDAO functionaryPointRecordDAO;

    @Autowired
    IFunctionaryService functionaryService;

    @Override
    public void createFunctionaryPoint(FunctionaryPointRecord functionaryPointRecord) {
        if(functionaryService.isFunctionaryExist(functionaryPointRecord.getFunctionary().getPis())){
            functionaryPointRecord.setFunctionary(functionaryService.findByPis(functionaryPointRecord.getFunctionary().getPis()));
        }
        functionaryPointRecordDAO.save(functionaryPointRecord);
    }

    @Override
    public List<FunctionaryPointRecord> findByDatePointAndFunctionary(LocalDate datePoint, String pis) {
        return functionaryPointRecordDAO.findByDatePointAndFunctionary(datePoint, functionaryService.findByPis(pis));
    }

}

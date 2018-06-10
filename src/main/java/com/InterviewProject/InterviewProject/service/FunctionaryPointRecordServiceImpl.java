package com.InterviewProject.InterviewProject.service;

import com.InterviewProject.InterviewProject.dao.IFunctionaryDao;
import com.InterviewProject.InterviewProject.dao.IfunctionaryPointRecordDAO;
import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

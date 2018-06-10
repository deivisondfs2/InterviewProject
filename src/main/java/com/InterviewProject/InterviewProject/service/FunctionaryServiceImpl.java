package com.InterviewProject.InterviewProject.service;

import com.InterviewProject.InterviewProject.dao.IFunctionaryDao;
import com.InterviewProject.InterviewProject.model.Functionary;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionaryServiceImpl implements IFunctionaryService {

    @Autowired
    private IFunctionaryDao functionaryDao;

    @Override
    public void createFunctionary(Functionary functionary) {
        functionaryDao.save(functionary);
    }

    @Override
    public boolean isFunctionaryExist(String pis) {
        boolean functionaryExists = Boolean.FALSE;
        Functionary functionary = findByPis(pis);
        if (functionary != null) {
            functionaryExists = Boolean.TRUE;
        }
        return functionaryExists;
    }

    @Override
    public Functionary findByPis(String pis) {
        return  functionaryDao.findByPis(pis);
    }
}

package com.InterviewProject.InterviewProject.infra;

import com.InterviewProject.InterviewProject.dao.IFunctionaryDao;
import com.InterviewProject.InterviewProject.model.Functionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

    @Autowired
    private IFunctionaryDao functionaryDao;


    @Autowired
    public DatabaseLoader(IFunctionaryDao functionaryDao) {
        this.functionaryDao = functionaryDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        functionaryDao.save(new Functionary("dfs2", "Hoje@2019", "123456"));
    }
}
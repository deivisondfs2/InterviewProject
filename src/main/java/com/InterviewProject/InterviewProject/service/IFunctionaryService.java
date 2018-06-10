package com.InterviewProject.InterviewProject.service;

import com.InterviewProject.InterviewProject.model.Functionary;

public interface IFunctionaryService {

    void createFunctionary(Functionary functionary);

    boolean isFunctionaryExist(String pis);

    Functionary findByPis(String pis);
}

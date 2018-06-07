package com.InterviewProject.InterviewProject.dao;

import com.InterviewProject.InterviewProject.model.Functionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFunctionaryDao extends JpaRepository<Functionary, Long> {

    Functionary findByPis(String pis);

}

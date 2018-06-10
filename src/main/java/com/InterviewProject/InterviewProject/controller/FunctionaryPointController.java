package com.InterviewProject.InterviewProject.controller;

import com.InterviewProject.InterviewProject.infra.CustomErrorType;
import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import com.InterviewProject.InterviewProject.service.IFunctionaryPointRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/functionaryPoint")
public class FunctionaryPointController {

    private static final Logger LOOGER = Logger.getLogger(FunctionaryPointController.class);

    @Autowired
    private IFunctionaryPointRecordService functionaryPointRecordService;

    /*
    Create Point for functionary
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody FunctionaryPointRecord functionaryPointRecord) {
        LOOGER.info("Creating Functionary");
        functionaryPointRecordService.createFunctionaryPoint(functionaryPointRecord);
        return new ResponseEntity<FunctionaryPointRecord>(HttpStatus.CREATED);
    }

}

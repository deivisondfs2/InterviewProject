package com.InterviewProject.InterviewProject.controller;

import com.InterviewProject.InterviewProject.infra.CustomErrorType;
import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.service.IFunctionaryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/functionary")
public class FunctionaryController {

    public static final Logger LOGGER = Logger.getLogger(FunctionaryController.class);

    @Autowired
    private IFunctionaryService functionaryService;

    /*
    Create Functionary
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Functionary functionary) {
        LOGGER.info("Creating Functionary");

        if (functionaryService.isFunctionaryExist(functionary.getPis())) {
            LOGGER.error("Unable to create. A Functionary with PIS " + functionary.getPis() +" already exist");
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Functionary with PIS " +
                    functionary.getPis() + " already exist."),HttpStatus.CONFLICT);
        }
        functionaryService.createFunctionary(functionary);

        return new ResponseEntity<Functionary>(HttpStatus.CREATED);
    }
}

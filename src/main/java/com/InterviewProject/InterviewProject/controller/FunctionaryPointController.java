package com.InterviewProject.InterviewProject.controller;

import com.InterviewProject.InterviewProject.infra.CustomErrorType;
import com.InterviewProject.InterviewProject.infra.DateUtils;
import com.InterviewProject.InterviewProject.model.Functionary;
import com.InterviewProject.InterviewProject.model.FunctionaryPointRecord;
import com.InterviewProject.InterviewProject.service.IFunctionaryPointRecordService;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /*
    // -------------------Get Points for day------------------------------------------
     */
    @RequestMapping(value = "/day/{dateUri}/{pis}", method = RequestMethod.GET)
    public ResponseEntity<?> getPointsForDay(@PathVariable("dateUri") String dateUri, @PathVariable("pis") String pis) {
        LocalDate date = DateUtils.converterStringParaLocalDate(dateUri,DateUtils.PATTERN_DATABASE);
        List<FunctionaryPointRecord> listFunctionarys = functionaryPointRecordService.findByDatePointAndFunctionary(date, pis);
        if (((List) listFunctionarys).isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FunctionaryPointRecord>>(listFunctionarys, HttpStatus.OK);
    }

}

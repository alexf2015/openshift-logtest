/**
 * Copyright (c) 2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.capgemini.test.openshiftlogging.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.test.openshiftlogging.service.debug.DebugLogService;
import com.capgemini.test.openshiftlogging.service.info.InfoLogService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author afriese
 *
 */
@RestController
@RequestMapping("log")
@Slf4j
public class LogController {
    
    @Autowired
    private DebugLogService debugLog;
    
    @Autowired
    private InfoLogService infoLog;

    /**
     * writes a message to the corresponding log.
     * 
     * @param message
     * @return
     */
    @RequestMapping(value = "/debug/{message}", method = RequestMethod.GET)
    public ResponseEntity<String> writeToDebugLog(@PathVariable("message") String message) {
        debugLog.writeToLog(message);
        return new ResponseEntity<String>("Successfully logged debug message", HttpStatus.OK);
    }

    /**
     * writes a message to the corresponding log.
     * 
     * @param message
     * @return
     */
    @RequestMapping(value = "/info/{message}", method = RequestMethod.GET)
    public ResponseEntity<String> writeToInfoLog(@PathVariable("message") String message) {
        infoLog.writeToLog(message);
        return new ResponseEntity<String>("Successfully logged info message", HttpStatus.OK);
    }

    @PostConstruct
    public void log() {
        log.info("LogController was constructed.");
    }
}

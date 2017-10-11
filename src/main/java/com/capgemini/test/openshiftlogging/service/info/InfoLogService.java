/**
 * Copyright (c) 2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.capgemini.test.openshiftlogging.service.info;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author afriese
 *
 */
@Service
@Slf4j
public class InfoLogService {

    /**
     * writes a message to the corresponding log.
     * 
     * @param message
     * @return
     */
    public void writeToLog(@PathVariable("message") String message) {
        log.info(message);
    }
    
    @PostConstruct
    public void log() {
        log.info("InfoLogService was constructed.");
    }


}

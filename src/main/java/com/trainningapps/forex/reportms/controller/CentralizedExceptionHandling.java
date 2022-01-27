package com.trainningapps.forex.reportms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainningapps.forex.reportms.exceptions.InvalidDateException;
import com.trainningapps.forex.reportms.exceptions.ReportNotFoundException;

/**
 * Class for handling the exception occured in the run
 * @author harii
 *
 */

@RestControllerAdvice
public class CentralizedExceptionHandling {

	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReportNotFoundException.class)
    public String handleReportNotFoundException(ReportNotFoundException e) {
        return e.getMessage();
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDateException.class)
    public String handleInvalidDateException(InvalidDateException e) {
        return e.getMessage();
    }
	
}

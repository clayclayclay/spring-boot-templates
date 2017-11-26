
package com.max.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.max.exception.SimpleException;

@ControllerAdvice 
public class ControllerAdviceExceptionHandler
{

    @ExceptionHandler(SimpleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIOException(SimpleException ex) {
    	return ex.getErrMsg();
    }
    
    @ExceptionHandler(ClassCastException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIOException(ClassCastException ex) {
    	return ex.getMessage();
    }
    
}
 

package com.max.validation.controller;

import com.max.validation.model.Book;
import com.max.validation.model.Student;
import com.max.validation.validator.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Class File:ValidateController1
 * Author: Max
 * Created Date: 2017-11-29
 */
@RestController("/v1")
public class ValidateController1
{

    @Autowired
    private CustomValidator customValidator;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(customValidator);
    }

    @PostMapping("/book")
    public String createBook(@Valid Book book, BindingResult result)
    {
        if (result.hasErrors())
        {
            return getAllFieldsError(result.getAllErrors());
        }
        return "success";
    }

    @PostMapping("/student")
    public String createStudent(@Valid Student student, Errors errors)
    {
//        customValidator.validate(student, errors);
        if (errors.hasErrors())
        {
            return getAllFieldsError(errors.getAllErrors());
        }
        return "success";
    }


    private String getAllFieldsError(List<ObjectError> fieldErrors)
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (ObjectError error : fieldErrors)
        {
            stringBuffer.append(error.getObjectName() + ":" + error.getDefaultMessage() + "\n");
        }
        return stringBuffer.toString();
    }

}

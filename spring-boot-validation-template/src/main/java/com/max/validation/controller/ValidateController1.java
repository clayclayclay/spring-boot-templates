package com.max.validation.controller;

import com.max.validation.model.Book;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Class File:ValidateController1
 * Author: Max
 * Created Date: 2017-11-29
 */
@RestController
@RequestMapping("/v1")
public class ValidateController1
{

    @PostMapping("/book")
    public String createBook(@RequestBody @Valid Book book, BindingResult result)
    {
        if (result.hasErrors())
        {
            return getAllFieldsError(result.getAllErrors());
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

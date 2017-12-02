package com.max.validation.controller;

import com.max.validation.model.Book;
import com.max.validation.util.MessageUtil;
import com.max.validation.validator.SpringCustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class File:ValidateController2
 * Author: Max
 * Created Date: 2017-11-29
 */
@RestController
@RequestMapping("/v2")
public class ValidateController2
{

    @Autowired
    private SpringCustomValidator customValidator;

    /**
     * >>>>>>the object 'errors' has held the object 'book' in its target field.
     *
     * @param book
     * @param bindingResult
     * @return
     */
    @PostMapping("/book")
    public String createBook(@RequestBody Book book, BindingResult bindingResult)
    {
        //manually call validator
        customValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
        {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError objectError : objectErrors)
            {
                stringBuffer.append(MessageUtil.getFieldErrorMessage(objectError.getObjectName(), objectError.getCode()));
            }
            return stringBuffer.toString();
        }
        return "success";
    }

}

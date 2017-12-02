package com.max.validation.controller;

import com.max.validation.model.Book;
import com.max.validation.util.MessageUtil;
import com.max.validation.validator.SpringCustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Class File:ValidateController3
 * Author: Max
 * Created Date: 2017-11-29
 */
@RestController
@RequestMapping("/v3")
public class ValidateController3
{

    @Autowired
    private SpringCustomValidator customValidator;

    /**
     * set the callback method for data validation
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(customValidator);
    }

    @PostMapping("/book")
    public String createStudent(@RequestBody @Valid Book book, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError objectError : objectErrors)
            {
                stringBuffer.append(MessageUtil.getFieldErrorMessage(objectError));
            }
            return stringBuffer.toString();
        }
        return "success";
    }


}

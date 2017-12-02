package com.max.validation.controller;

import com.max.validation.model.Book;
import com.max.validation.util.MessageUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Class File:ValidateController4
 * Author: Max
 * Created Date: 2017-11-29
 */
@RestController
@RequestMapping("/v4")
public class ValidateController4
{

    @PostMapping("/book")
    public String createBook(@RequestBody Book student)
    {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Book>> set = validator.validate(student);
        if (!set.isEmpty())
        {
            StringBuffer stringBuffer = new StringBuffer();
            for (ConstraintViolation<Book> constraintViolation : set)
            {
                String message = constraintViolation.getMessage();
                String errorMsgCode = message.substring(1, message.length() - 1);
                stringBuffer.append(MessageUtil.getFieldErrorMessage(constraintViolation.getRootBean().getName(), errorMsgCode));
            }
            return stringBuffer.toString();
        }
        return "success";
    }
}

package com.max.validation.validator;

import com.max.validation.annotation.LongDataType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Class File:JavaxCustomValidator
 * Author: Max
 * Created Date: 2017-11-30
 */
public class JavaxCustomValidator implements ConstraintValidator<LongDataType, Object>
{

    @Override
    public void initialize(LongDataType longDataType)
    {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
    {
        if (o == null)
        {
            return false;
        }
        try
        {
            Long.parseLong(o.toString());
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}

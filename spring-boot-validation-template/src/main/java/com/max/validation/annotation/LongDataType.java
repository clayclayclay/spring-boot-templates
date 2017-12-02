package com.max.validation;

import com.max.validation.validator.JavaxCustomValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class File:LongDataType
 * Author: Max
 * Created Date: 2017-11-30
 */
@Constraint(validatedBy = JavaxCustomValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LongDataType
{
}

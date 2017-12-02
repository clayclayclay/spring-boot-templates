package com.max.validation.annotation;

import com.max.validation.validator.JavaxCustomValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
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
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LongDataType
{
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

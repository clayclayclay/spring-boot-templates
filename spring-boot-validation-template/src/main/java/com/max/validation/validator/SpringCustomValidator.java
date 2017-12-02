package com.max.validation.validator;

import com.max.validation.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Class File:CustomValidator
 * Author: Max
 * Created Date: 2017-11-29
 */
@Component
public class SpringCustomValidator implements Validator
{

    private final static String NOT_EMPTY_ERROR_CODE_BOOK_ID = "NotEmpty.book.id";
    private final static String NOT_EMPTY_ERROR_CODE_BOOK_NAME = "NotEmpty.book.name";
    private final static String NOT_EMPTY_ERROR_CODE_BOOK_PRICE = "NotEmpty.book.price";
    private final static String NOT_EMPTY_ERROR_CODE_BOOK_IS_LATEST = "NotEmpty.book.isLatest";

    private final static String OVER_SIZE_ERROR_CODE_BOOK_NAME = "OverSize.book.name";

    private final static String ASSERT_TRUE_ERROR_CODE_BOOK_IS_LATEST = "AssertTrue.book.isLatest";

    @Override
    public boolean supports(Class<?> aClass)
    {
        return Book.class.equals(aClass);
    }

    /**
     * you can extend your logic here, such as field's length, check for data type and so on.
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors)
    {
        /**
         * The Util Class: ValidationUtils just can validate 'isEmpty'
         */
//        ValidationUtils.rejectIfEmpty(errors, "id", "NotEmpty.book.id");
//        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.book.name");
//        ValidationUtils.rejectIfEmpty(errors, "price", "NotEmpty.book.price");

        /**
         * hold the target instance to write custom validation logic
         */
        validateObject(target, errors);

    }

    private void validateObject(Object target, Errors errors)
    {
        Book book = (Book) target;
        if (book.getId() == null)
        {
            errors.reject(NOT_EMPTY_ERROR_CODE_BOOK_ID);
        }
        if (book.getName() == null)
        {
            errors.reject(NOT_EMPTY_ERROR_CODE_BOOK_NAME);
        }
        else
        {
            int nameLength = book.getName().length();
            if (!(nameLength >= 1 && nameLength <= 5))
            {
                errors.reject(OVER_SIZE_ERROR_CODE_BOOK_NAME);
            }
        }
        if (book.getPrice() == null)
        {
            errors.reject(NOT_EMPTY_ERROR_CODE_BOOK_PRICE);
        }
        if (book.isLatest() == null)
        {
            errors.reject(NOT_EMPTY_ERROR_CODE_BOOK_IS_LATEST);
        }
        else if (!book.isLatest())
        {
            errors.reject(ASSERT_TRUE_ERROR_CODE_BOOK_IS_LATEST);
        }
    }

}

package com.max.validation.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Class File:MessageUtil
 * Author: Max
 * Created Date: 2017-11-29
 */
@Component
public class MessageUtil implements MessageSourceAware
{

    private static MessageSource messageSource;

    public static String getFieldErrorMessage(String objectName, String errorCode)
    {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(objectName
                + " : "
                + messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale())
                + "\n");
        return stringBuffer.toString();
    }

    @Override
    public void setMessageSource(MessageSource messageSource)
    {
        MessageUtil.messageSource = messageSource;
    }
}

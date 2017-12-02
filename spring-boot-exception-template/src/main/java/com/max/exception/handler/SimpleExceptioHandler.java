
package com.max.exception.handler;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class SimpleExceptioHandler
{
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
    {
        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.put("org.springframework.web.servlet.PageNotFound", "page-404");
        mappings.put("org.springframework.dao.DataAccessException", "data-access");
        mappings.put("org.springframework.transaction.TransactionException", "transaction-Failure");
        b.setExceptionMappings(mappings);
        return b;
    }
}

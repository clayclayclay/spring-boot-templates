package com.max.spring.springbootmvctemplate.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Class File:ViewController
 * Author: Max
 * Created Date: 2017-11-29
 */
@Component
public class ViewController extends WebMvcConfigurerAdapter
{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/web/hello").setViewName("login");
        registry.addViewController("/web/prepareUpload").setViewName("upload");
    }


}

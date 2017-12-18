package com.max.security.controller;

import com.max.security.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class File:HelloController
 * Author: Max
 * Created Date: 2017-12-04
 */
@Controller
public class HelloController
{

    @Autowired
    private BookService bookService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello()
    {
        return "hello, this is hello page example";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index()
    {
        return "hello, this is INDEX page example";
    }

}

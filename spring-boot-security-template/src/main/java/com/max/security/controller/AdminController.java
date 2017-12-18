package com.max.security.controller;

import com.max.security.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class File:AdminController
 * Author: Max
 * Created Date: 2017-12-04
 */
@Controller
public class AdminController
{

    @Autowired
    private BookService simpleService;

    @RequestMapping("/admin")
    @ResponseBody
    public String hello()
    {
        return "hello, this is ADMIN page example";
    }

}

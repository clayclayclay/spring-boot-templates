package com.max.spring.springbootmvctemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class File:AdminController
 * Author: Max
 * Created Date: 2017-11-26
 */
@Controller
@RequestMapping("/web")
public class AdminController
{

    @RequestMapping("/login")
    public String login(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, Model model)
    {
        if (validate(username, password))
        {
            model.addAttribute("name", username);
            return "success";
        } else
        {
            return "failed";
        }

    }

    private boolean validate(String username, String password)
    {
        return "admin".equals(username) && "admin".equals(password) ? true : false;
    }
}

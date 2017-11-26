package com.max.spring.springbootmvctemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class File:HelloController
 * Author: Max
 * Created Date: 2017-11-25
 */
@Controller
@RequestMapping("/web")
public class GreetingController
{

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }


}

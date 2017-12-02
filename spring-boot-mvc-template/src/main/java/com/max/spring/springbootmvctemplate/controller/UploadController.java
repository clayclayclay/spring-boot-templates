package com.max.spring.springbootmvctemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class File:AdminController
 * Author: Max
 * Created Date: 2017-11-26
 */
@Controller
@RequestMapping("/web")
public class UploadController
{

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String login(@RequestParam("file") MultipartFile file)
    {
        System.out.println(">>>>>> File Name: " + file.getOriginalFilename());
        return "upload_success";
    }

}

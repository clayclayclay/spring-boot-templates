package com.max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.max.springaop.service.AdminService;

@SpringBootApplication
public class JavaAopDemoApplication implements CommandLineRunner
{


    @Autowired
    private AdminService proxyAdminService;

    public static void main(String[] args)
    {
        SpringApplication.run(JavaAopDemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception
    {
        proxyAdminService.login(null, null);
        proxyAdminService.getName("1");
        proxyAdminService.play();
        proxyAdminService.getAge(null);
    }
}

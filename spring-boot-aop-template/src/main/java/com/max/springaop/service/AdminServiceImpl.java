package com.max.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService
{

    @Override
    public void login(String name, String password)
    {
        System.out.println("the user is log in");
    }

    @Override
    public String getName(String id)
    {
        return "max";
    }

    @Override
    public int getAge(String id)
    {
        if (null == id)
        {
            throw new RuntimeException("the id can't be null or empty");
        }
        return 21;
    }

    @Override
    public void play()
    {
        System.out.println("have fun");
    }
}

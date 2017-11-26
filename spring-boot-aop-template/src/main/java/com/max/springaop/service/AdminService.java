package com.max.springaop.service;

public interface AdminService
{

    void login(String name, String password);

    String getName(String id);

    int getAge(String id);

    void play();
}

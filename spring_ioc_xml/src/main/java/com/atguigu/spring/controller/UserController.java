package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;

/**
 * @date 2022/12/20   2:27
 */
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}

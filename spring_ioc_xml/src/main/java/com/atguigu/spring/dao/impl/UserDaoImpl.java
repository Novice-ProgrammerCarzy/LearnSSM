package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;

/**
 * @date 2022/12/20   2:28
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功！");
    }
}

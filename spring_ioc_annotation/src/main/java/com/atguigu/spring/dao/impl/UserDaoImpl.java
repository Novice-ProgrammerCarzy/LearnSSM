package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @date 2022/12/20   16:59
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功！");
    }
}

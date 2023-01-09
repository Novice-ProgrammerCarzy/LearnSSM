package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2022/12/12   1:40
 */
public interface SpecialSQLMapper {

    /**
     * 通过用户名模糊查询
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 添加用户信息
     * @param user
     */
    void insetUser(User user);

}

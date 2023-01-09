package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @date 2022/12/11   19:37
 */
public interface SelectMapper {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为list集合
     * @return
     */
    List<Map<String,Object>> getAllUserToList();

    /**
     * 查询所有用户信息为map集合
     * 若查询的数据有多条时，并且要每条数据转换为map集合
     * 此时有两种解决方案：
     *  1. 将mapper接口方法的返回值设置为泛型是map的list集合
     *       List<Map<String,Object>>
     *  2. 可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey注解
     *      将查询的某个字段的值作为大的map的键。
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}

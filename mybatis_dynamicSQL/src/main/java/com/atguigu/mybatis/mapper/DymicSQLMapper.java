package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2022/12/14   19:12
 */
public interface DymicSQLMapper {

    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 批量添加用户信息
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);

}

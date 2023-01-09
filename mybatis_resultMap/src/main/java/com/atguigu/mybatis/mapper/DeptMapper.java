package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @date 2022/12/14   18:07
 */
public interface DeptMapper {

    /**
     * 根据部门id获取所有部门员工信息
     * @param deptId
     * @return
     */
    public Dept getDeptAndEmpByDeptID(@Param("deptId") Integer deptId);


    /**
     * 分步查询：通过分布查询部门以及部门中的员工信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}

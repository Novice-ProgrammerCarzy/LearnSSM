package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @date 2022/12/10   14:11
 */
public class MyBatisTest {


    @Test
    public void testInsert() throws IOException {
        //获取核心配置的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        /*//获取sql的会话对象SqlSession(不会自动提交)，是MyBatis提供等等操作数据库的对象。
        SqlSession sqlSession = sqlSessionFactory.openSession();*/
        //获取sql的会话对象SqlSession(会自动提交)，是MyBatis提供等等操作数据库的对象。
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        /*  方式一:通过封装好的方法，实现代理
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        */
        //方式二：提供sql语句的唯一标识找到sql并执行
        //              唯一标识：namespace.sqlId （UserMapper.xml文件中的）
        int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");
        System.out.println("结果：" + result);
        //提交事务
//        sqlSession.commit();
        //关闭资源
        sqlSession.close();

    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }


    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }
}

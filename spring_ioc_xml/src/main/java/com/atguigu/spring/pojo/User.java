package com.atguigu.spring.pojo;

/**
 * @date 2022/12/19   23:43
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

    public User() {
        System.out.println("生命周期：1、创建对象（无参构造）");
    }

    public void setId(Integer id) {
        System.out.println("生命周期：2、依赖注入(setXX方法)");
        this.id = id;
    }

    public void initMethod() {
        System.out.println("生命周期：4、初始化（initMethod）");
    }

    public void destroyMethod() {
        System.out.println("生命周期：6、销毁（destroyMethod）");
    }

    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}


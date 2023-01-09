import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2022/12/21   1:51
 */
public class IOCByAnnotationTest {

    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     *
     * 通过注解+扫描所配置的bean的id，默认值为类的小驼峰，即类名的首字母为小写的结果
     * 可以通过注解标识组件的注解的Value属性值设置bean的自定义的id
     */
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController",UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userService);
        System.out.println(userDao);

    }

    /**
     * @Autowired:实现自动装配功能的注解
     *  1. @Autowired注解能够标识的位置：
     *      1）标识在成员变量上，此时不需要设置成员变量的set方法
     *      2）标识这种set方法上
     *      3）标识在为当前成员变量赋值的有参构造上
     *  2.@Autowired注解原理
     *      1）默认：
     *          通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值。
     *          若多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     *              (将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值)
     *      2）若byType和byName的方式都无法实现自动装配，即IOC容器有多个类型匹配的bean
     *              ,且这些bean的id和要赋值的属性的属性名都不一致，此时会抛异常：NoUniqueBeanDefinitionException
     *          解决方法：通过注解指定bean的id
     *              在要赋值的属性上，添加一个注解@Qualifier("userDaoImpl")
     *              通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     */

    @Test
    public void test2(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController",UserController.class);
        userController.saveUser();
    }
}

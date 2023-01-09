import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2022/12/20   0:36
 */
public class LifeCycleTest {

    @Test
    public void test(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        //ConfigurableApplicationContext是ApplicationContext的子接口，扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}

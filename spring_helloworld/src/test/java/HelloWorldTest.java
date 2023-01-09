import com.atguigu.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2022/12/17   1:24
 */
public class HelloWorldTest {

    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
    }

    @Test
    public void testHelloWorld(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld bean = ac.getBean("helloworld", HelloWorld.class);
        bean.sayHello();
    }
}

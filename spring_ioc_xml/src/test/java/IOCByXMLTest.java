import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2022/12/17   1:33
 */
public class IOCByXMLTest {

    @Test
    public void testIOC() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
//        Student student = (Student) ioc.getBean("studentOne");
        Student student = ioc.getBean(Student.class);


        System.out.println(student);
    }
    @Test
    public void testDIBySet(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }


}

import com.atguigu.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2022/12/23   3:44
 */
public class AOPTest {

//    @Test
//    public void testAOPByAnnotation(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
//        Calculator calculator = ioc.getBean(Calculator.class);
//        calculator.div(1, 1);
//    }

    @Test
    public void testAOPByXML(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,1);
    }

}

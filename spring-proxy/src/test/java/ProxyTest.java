import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @date 2022/12/23   2:25
 */
public class ProxyTest {

    /**
     *  动态代理：
     *      1. jdk动态代理：要求必须有接口，最终生成的代理类和目标类实现相同的接口
     *              在com.sun.proxy包下，类名为$Proxy4
     *      2. cglib动态代理：最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */
    @Test
    public void testDynamicProxy() {
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1, 2);

//proxy.div(1,1);
    }

}

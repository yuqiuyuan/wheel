package three;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 可以看到，otherService.runOther方法被拦截了
 *
 * @author guangxush
 * @since 2020/06/06
 */
public class TestMethodInterceptor {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new MyService());
        proxyFactory.addAdvice(new ServiceInterceptor());

        Object proxy = proxyFactory.getProxy();
        MyService myService = (MyService) proxy;

        myService.run("通过代理工厂设置代理对象，拦截代理方法");

        proxyFactory.setTarget(new OtherService());
        proxy = proxyFactory.getProxy();
        OtherService otherService = (OtherService) proxy;

        otherService.runOther("通过代理工厂设置代理对象，拦截代理方法");
    }
}

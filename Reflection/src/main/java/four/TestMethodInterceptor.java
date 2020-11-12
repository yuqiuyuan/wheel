package four;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 定义测试类，调用ServiceOne和ServiceTwo，把二者的公共方法printlog方法直接放到test里面调用，反射不会对其执行环绕方法。
 * 环绕方法，可以理解成循环，在本例中，公共父类的公共方法是打印日志，拦截器中干的事儿是执行方法的时候打印日志，也就是执行打印日志方法的时候，不需要重复打印执行方法前、中、后的日志了
 *
 * @author guangxush
 * @since 2020/06/06
 */
public class TestMethodInterceptor {
    public static void main(String[] args) {
        ServiceOne serviceOne = (ServiceOne) test(new ServiceOne());

        serviceOne.run("通过代理工厂设置代理对象，拦截代理方法");

        ServiceTwo serviceTwo = (ServiceTwo) test(new ServiceTwo());

        serviceTwo.run("通过代理工厂设置代理对象，拦截代理方法");
    }

    /**
     * 每执行一次test，都会通过代理工厂生成一个代理对象，在生成代理对象的时候，会向生成的代理对象添加拦截器，之后会调用一次公共父类的打印日志的方法
     * @param baseService 基础服务
     * @return 基础服务的代理对象
     */
    public static BaseService test(BaseService baseService){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(baseService);
        proxyFactory.addAdvice(new ServiceInterceptor());

        Object proxy = proxyFactory.getProxy();
        BaseService baseProxy = (BaseService) proxy;
        baseProxy.printLog();
        return baseProxy;
    }
}

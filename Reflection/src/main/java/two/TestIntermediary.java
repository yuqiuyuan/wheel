package two;

import java.lang.reflect.Proxy;

/**
 * @author guangxush
 * @since 2020/06/07
 */
public class TestIntermediary {
    public static void main(String[] args) {

        // 基本的代理类
        Parents child = new Children();
        Intermediary intermediary = new Intermediary(child);
        Parents proxy = (Parents) Proxy.newProxyInstance(child.getClass().getClassLoader(), child.getClass().getInterfaces(), intermediary);
        proxy.function();

        // 优雅的代理工具类，但是下面程序是过度学习阶段的程序，在实际生产的过程中，直接实例化就好了，没有必要使用代理。
        Parents parents = (Parents) GetObject.runObject(new Children());
        parents.function();
    }
}

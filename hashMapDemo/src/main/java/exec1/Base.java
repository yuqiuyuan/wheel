package exec1;

/**
 * Base
 * <p>
 * 代码的执行顺序是：
 * 父类静态代码->子类静态代码块->父类非静态代码块->父类构造方法->子类非静态代码块->子类构造方法
 *
 * @author drebander
 * @since 2021-02-03 10:00 下午
 **/
public class Base extends BaseClass {
    public Base() {
        System.out.println("I.m base Class");
    }

    static {
        System.out.println("static base");
    }

    public static void main(String[] args) {
        new Base();
    }

}

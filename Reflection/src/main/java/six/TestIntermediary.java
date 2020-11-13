package six;

import java.util.Date;

/**
 * @author guangxush
 * @since 2020/06/07
 */
public class TestIntermediary {
    public static void main(String[] args) {

        // 基本的代理类
        OuterClass outerClass = new OuterClass(1L, "shgx", 1, 23.5, new Date());
        // BeanUtil
        InnerClass innerClassOne = new InnerClass();
        CopyUtil.getClassByBeanUtil(innerClassOne, outerClass);
        System.out.print("通过代理调用： ");
        GetObject.runObject(innerClassOne);
        System.out.print("方法直接调用： ");
        innerClassOne.function();

        // PropertyUtil
        InnerClass innerClassTwo = new InnerClass();
        CopyUtil.getClassByPropertyUtil(innerClassTwo, outerClass);
        System.out.print("通过代理调用： ");
        GetObject.runObject(innerClassTwo);
        System.out.print("方法直接调用： ");
        innerClassTwo.function();
        // 置空
        outerClass.setId(null);
        outerClass.setName(null);
        outerClass.setAge(null);
        outerClass.setSex(null);
        outerClass.setBirthDay(null);
        // BeanUtil
        CopyUtil.getClassByBeanUtil(innerClassOne, outerClass);
        System.out.print("通过代理调用： ");
        GetObject.runObject(innerClassOne);
        System.out.print("方法直接调用： ");
        innerClassOne.function();

        // PropertyUtil
        CopyUtil.getClassByPropertyUtil(innerClassTwo, outerClass);
        System.out.print("通过代理调用： ");
        GetObject.runObject(innerClassTwo);
        System.out.print("方法直接调用： ");
        innerClassTwo.function();
    }
}

package exec1;

import java.util.ArrayList;
import java.util.List;

/**
 * NameList
 * <p>
 * 实践只会ABCABCABC
 * <p>
 * 题目中调用了两次printAll，分别找出两次打印结果的特征
 * 1、由于代码是顺序执行的，所以第一次打印，一定包含ABC，三个元素之间允许穿插，用C来截取第一打印的大致方位
 * 2、第二次打印，特征更为明显，答应的时候，list已经满员，ABCABC，顺序允许稍有不同
 * <p>
 * 标准答案 ABC ABCABC
 * 也允许 ABCA ABCABC、ABACB ABACBC 这样的答案，第二次打印的结果包含第一次打印，并且是第一次打印的延伸
 *
 * @author drebander
 * @since 2021-01-03 6:15 上午
 **/
public class NameList {
    private List<String> names = new ArrayList<>();

    public synchronized void put(String name) {
        names.add(name);
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printAll() {
        names.forEach(System.out::println);
        System.out.println(names.size());
    }

    public static void main(String[] args) {
        NameList n = new NameList();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                n.put("A");
                n.put("B");
                n.put("C");
                n.printAll();
                System.out.println();
            }).start();
        }
    }


}

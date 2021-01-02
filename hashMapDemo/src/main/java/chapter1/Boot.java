package chapter1;


import java.util.HashMap;
import java.util.Map;

/**
 * Boot
 *
 * @author drebander
 * @since 2020-12-26 5:51 下午
 **/
public class Boot {
    public static void main(String[] args) {
//        my();
        expectedTest();
    }

    static void my() {
        final long start = System.currentTimeMillis();
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 50000; i++) {
            m.put(i, i);
        }
        for (int i = 0; i < 50000; i++) {
            System.out.println(m.get(i));
        }
        final long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }

    static void expectedTest() {
        final long start = System.currentTimeMillis();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 500000000; i++) {
            m.put(i, i);
        }
//        for (int i = 0; i < 5000; i++) {
//            System.out.println(m.get(i));
//        }
        final long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}

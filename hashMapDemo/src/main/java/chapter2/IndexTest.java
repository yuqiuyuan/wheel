package chapter2;

/**
 * IndexTest
 *
 * @author drebander
 * @since 2020-12-26 6:51 下午
 **/
public class IndexTest {
    public static void main(String[] args) {
        int maxIndex = 1 << 15;
        for (Integer i = 0; i < maxIndex; i++) {
            System.out.println(i.hashCode() & 16);
        }
        for (Integer i = 0; i < maxIndex; i++) {
            System.out.println(i.hashCode() % 16);
        }
    }
}

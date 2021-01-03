package chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Display
 *
 * @author drebander
 * @since 2021-01-03 9:51 上午
 **/
public class Display {

    private final String separator = "     ";
    private List<String> contentList = new ArrayList<>();

    String display(RedTree redTree) {
        StringBuilder buff = new StringBuilder(separator);
        buff.append(redTree.getKey());
        System.out.println(buff.toString());
        if (null != redTree.getLeft()) {
            display(redTree.getLeft());
            System.out.print("   ");
        }
        if (null != redTree.getRight()) {
            display(redTree.getRight());
            System.out.println("\\");
        }
        return "";
    }

    public static void main(String[] args) {
        RedTree root = new RedTree(2, 2);
        RedTree left = new RedTree(1, 1);
        RedTree right = new RedTree(3, 3);
        root.setLeft(left);
        root.setRight(right);
        new Display().printUnit(root);
    }

    private void printUnit(RedTree redTree) {
        String builder1 = String.valueOf(redTree.getKey());
        StringBuilder builder2 = new StringBuilder(3);
        StringBuilder builder3 = new StringBuilder();
        if (null != redTree.getLeft()) {
            builder1 = "   " + builder1;
            builder2.append(" /").append("   ");
            builder3.append(redTree.getLeft().getKey()).append(separator);
            printUnit(redTree.getLeft());
        }
        if (null != redTree.getRight()) {
            builder2.append("\\");
            builder3.append(redTree.getRight().getKey());
            printUnit(redTree.getRight());
        }
        System.out.println(builder1);
        System.out.println(builder2.toString());
        System.out.println(builder3.toString());
    }

    private void printDemo() {
        StringBuilder buff = new StringBuilder();
        buff.append(1).append("\n").append("   ").append(2);
        System.out.println(buff.toString());
    }
}

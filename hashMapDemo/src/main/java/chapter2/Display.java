package chapter2;

import java.util.LinkedList;
import java.util.List;

/**
 * Display
 *
 * @author drebander
 * @since 2021-01-03 9:51 上午
 **/
public class Display {


    public static void main(String[] args) {
        RedTree root = new RedTree(2, 2);
        RedTree left = new RedTree(1, 1);
        RedTree right = new RedTree(3, 3);
        RedTree r10 = new RedTree(10, 10);
        RedTree r7 = new RedTree(7, 7);
        RedTree r15 = new RedTree(15, 15);
        root.setLeft(left);
        root.setRight(right);
        r10.setRight(r15);
        r10.setLeft(r7);
        right.setRight(r10);
        final Display display = new Display();
        display.printTree(root);
    }

    public void printTree(RedTree root) {
        List<Coordinate> coordinateList = new LinkedList<>();
        printUnit(root, null, coordinateList);
        show(coordinateList);
    }

    private void show(List<Coordinate> coordinateList) {
        final Panel panel = new Panel();
        coordinateList.forEach(item -> {
            panel.minX = Math.min(item.getX(), panel.minX);
            panel.maxX = Math.max(item.getX(), panel.maxX);
            panel.minY = Math.min(item.getY(), panel.minY);
            panel.maxY = Math.max(item.getY(), panel.maxY);
        });
        String[][] pixels = new String[panel.maxY - panel.minY + 1][panel.maxX - panel.minX + 1];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                pixels[y][x] = " ";
            }
        }
        coordinateList.forEach(item -> {
            int x = item.getX() - panel.minX;
            int y = item.getY();
            pixels[y][x] = item.getValue();
        });
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                System.out.print(pixels[y][x]);
            }
            System.out.println();
        }
    }


    /**
     * 这个算法有两个特别的点
     * 1、当前节点没有父节点，说明当前节点是父亲节点，生成相对坐标
     * 2、当前节点没有子节点，说明当前节点是叶子节点，当是叶子节点的时候，需要跳出循环
     * 3、当是其他情况的时候，需要使用递归的算法继续向下遍历
     *
     * @param redTree
     */
    private void printUnit(RedTree redTree, Coordinate coordinate, List<Coordinate> coordinateList) {
        if (null == coordinate) {
            coordinate = new Coordinate(0, 0, String.valueOf(redTree.getValue()));
        }
        if (null == coordinateList) {
            coordinateList = new LinkedList<>();
        }
        coordinateList.add(coordinate);
        if (null != redTree.getLeft()) {
            final RedTree left = redTree.getLeft();
            Coordinate l = new Coordinate(coordinate.getX() - 1, coordinate.getY() + 1, "/");
            coordinateList.add(l);
            Coordinate leftCoordinate = new Coordinate(l.getX() - 1, l.getY() + 1, String.valueOf(left.getValue()));
            printUnit(left, leftCoordinate, coordinateList);
        }
        if (null != redTree.getRight()) {
            final RedTree right = redTree.getRight();
            Coordinate r = new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1, "\\");
            coordinateList.add(r);
            Coordinate rightCoordinate = new Coordinate(r.getX() + 1, r.getY() + 1, String.valueOf(right.getValue()));
            printUnit(right, rightCoordinate, coordinateList);
        }

    }


    class Panel {
        int minX;
        int maxX;
        int minY;
        int maxY;
    }

    class Coordinate {
        int x;
        int y;
        String value;

        public Coordinate(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}

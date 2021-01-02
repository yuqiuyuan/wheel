package chapter2;

import chapter1.Node;

/**
 * RedTree
 *
 * @author drebander
 * @since 2020-12-27 11:02 下午
 **/
public class RedTree extends Node {


    private RedTree left;
    private RedTree right;
    private boolean isRed;
    private RedTree parent;

    public RedTree(Object key, Object value) {
        super(key, value);
    }

    public RedTree put(RedTree x) {
        int dir;
        RedTree p = this;
        if (x.getHashCode() > getHashCode()) {
            dir = 1;
        } else {
            dir = -1;
        }
        //当p节点是红色节点的时候，不能直接进行插入操作
        if (p.isRed) {
            // 当s是红色节点的时候比较特殊，所以这里先找红色节点
            RedTree g = p.parent, s = null;
            if (null != g && g.getHashCode() > p.getHashCode()) {
                s = g.right;
            } else if (null != g && g.getHashCode() < p.getHashCode()) {
                s = left;
            }
            if (null != s && s.isRed) {

            } else {// 红色节点之外的情况是黑色节点
                // 进行一字形翻转
                if (x.getHashCode() < p.getHashCode()) {
                    p.left = x;
                    p.right = g;
                    p.isRed = false;
                    g.isRed = true;
                    g.left = null;
                    return p;
                } else if (x.getHashCode() > p.getHashCode()) {
                    p.right = null;
                    p.parent = x;
                    x.left = p;
                    x.parent = p.parent;
                    boolean xisRed = x.isRed;
                    x.isRed = g.isRed;
                    g.isRed = xisRed;
                    x.right = g;
                    g.parent = x;
                    g.left = null;
                    return x;
                }

            }


        } else {//当p节点是黑色节点的时候，直接将新节点进行插入即可
            if (dir == 1) {
                right = x;
            } else {
                left = x;
            }
            return this;
        }
        return null;
    }

    public RedTree getLeft() {
        return left;
    }

    public void setLeft(RedTree left) {
        this.left = left;
    }

    public RedTree getRight() {
        return right;
    }

    public void setRight(RedTree right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public RedTree getParent() {
        return parent;
    }

    public void setParent(RedTree parent) {
        this.parent = parent;
    }
}

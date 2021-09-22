package com.yyf.lagou.rbtree;

public class RBNode {
    private int key;
    private boolean isBlack;
    private RBNode left;
    private RBNode right;
    private RBNode parent;

    public RBNode(int key){
        this.key = key;
        this.isBlack = false;//新创建的节点默认为红色
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBTreeNode{" +
                "key=" + key +
                ", color=" + (isBlack==true?"BLACK":"RED") +
                '}';
    }
}

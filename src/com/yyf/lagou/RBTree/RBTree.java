package com.yyf.lagou.RBTree;

public class RBTree {
    //根节点
    private RBNode root;

    /**
     * 遍历节点
     */
    public void list(RBNode node){
        if (node == null) {
            return;
        }
        System.out.println(node);
        if (node.getLeft() == null && node.getRight() == null){
            return;
        }
        //递归左孩子
        list(node.getLeft());
        //递归右孩子
        list(node.getRight());
    }

    /**
     * 插入数据
     * @param key
     */
    public void insert(int key){
        RBNode node = new RBNode(key);
        if (null == root){
            root = node;
            root.setBlack(true);
            return;
        }
        RBNode parent = root;
        RBNode son = null;
        if (key <= parent.getKey()){
            son = parent.getLeft();
        }else {
            son = parent.getRight();
        }
        while (son != null){
            parent = son;
            if(key <= parent.getKey()){
                son = parent.getLeft();
            }else {
                son = parent.getRight();
            }
        }
        if (key <= parent.getKey()){
            parent.setLeft(node);
        }else {
            parent.setRight(node);
        }
        node.setParent(parent);
        //自平衡
        banlanceInsert(node);
    }

    /**
     * 自平衡
     * @param node
     */
    private void banlanceInsert(RBNode node) {
        RBNode father,grandFather;
        while ((father = node.getParent()) != null && father.isBlack() == false){
            grandFather = father.getParent();
            //父节点是爷爷节点的左孩子
            if (grandFather.getLeft() == father){
                RBNode uncle = grandFather.getRight();
                //如果叔叔节点存在且颜色是红色 进行变色操作
                if (uncle != null && uncle.isBlack() == false){
                    father.setBlack(true);
                    uncle.setBlack(true);
                    grandFather.setBlack(false);
                    node = grandFather;
                    continue;
                }
                //叔叔节点是黑色或叔叔节点是空
                //当前节点是父节点的右子节点，需要进行左旋
                if (node == father.getRight()){
                    //左旋
                    leftRotate(father);
                    RBNode tmp = node;
                    node = father;
                    father = tmp;
                }
                father.setBlack(true);
                grandFather.setBlack(false);
                //右旋
                rightRotate(grandFather);
            }else {
                //父节点为爷爷节点的右孩子
                RBNode uncle = grandFather.getLeft();
                //叔叔节点不为空且颜色为红色
                if (uncle != null && uncle.isBlack() == false){
                    grandFather.setBlack(false);
                    father.setBlack(true);
                    uncle.setBlack(true);
                    node = grandFather;
                    continue;
                }
                //叔叔节点为空或颜色为黑色
                if (node == father.getLeft()){
                    //如果节点为父节点的左孩子 需要进行右旋
                    rightRotate(father);
                    RBNode tmp = node;
                    node = father;
                    father = tmp;
                }
                father.setBlack(true);
                grandFather.setBlack(false);
                //此时爷爷节点进行左旋
                leftRotate(grandFather);
            }
        }
        root.setBlack(true);
    }

    /**
     * 左旋
     * @param node
     */
    private void leftRotate(RBNode node) {
        RBNode right = node.getRight();
        RBNode parent = node.getParent();

        if (parent == null){
            root = right;
            right.setParent(null);
        }else {
            if (parent.getLeft() != null && parent.getLeft() == node){
                parent.setLeft(right);
            }else {
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if (right.getLeft() != null){
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /**
     * 右旋
     * @param node
     */
    private void rightRotate(RBNode node){
        RBNode left = node.getLeft();
        RBNode parent = node.getParent();
        if (parent == null){
            left = root;
            left.setParent(null);
        }else {
            if (parent.getRight() != null && parent.getRight() == node){
                parent.setRight(left);
            }else {
                parent.setLeft(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null){
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    public static void main(String[] args) {
        RBTree tree = new RBTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.list(tree.root);
    }
}


















package com.yyf.jike;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 单链表
 *
 * @param <T>
 */
public class SingleLinkedList<T> {

    private Node<T> head;

    static class Node<T> {

        private T data;

        private Node next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "{data:" + this.data + "}";
        }
    }

    /**
     * 新增操作
     *
     * @param data
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (null == head) {
            head = node;
        } else {
            Node<T> lastNode = getLastNode();
            lastNode.next = node;
        }
    }

    /**
     * 获取最后一个节点
     *
     * @return
     */
    public Node<T> getLastNode() {
        if (null == head) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 基于下标获取数据
     * @param index
     * @return
     */
    public T get(int index) {
        if (null == head || index < 0) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                return tmp.data;
            }
            tmp = tmp.next;
            i++;
        }
        throw new NoSuchElementException();
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    public T remove(int index){
        if (null == head) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        if (index == 0) {
            head = tmp.next;
            return tmp.data;
        }
        int i = 1;
        while (tmp.next != null) {
            if (i == index) {
                Node<T> next = tmp.next;
                tmp.next = next.next;
                return next.data;
            }
            tmp = tmp.next;
            i++;
        }
        throw new NoSuchElementException();
    }

    /**
     * 删除最后一个节点
     * @return
     */
    public T removeLast(){
        if (null == head) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        if (tmp.next == null) {
            head = null;
            return tmp.data;
        }
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        Node<T> next = tmp.next;
        tmp.next = null;
        return next.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        Node<T> tmp = head;
        while (tmp != null) {
            builder.append(",");
            builder.append(tmp.data);
            tmp = tmp.next;
        }
        return "[" + builder.substring(1) + "]";
    }

    /**
     * 在头部添加数据
     * @param data
     */
    public void addFirst(T data) {
        Node<T> tNode = new Node<>(data);
        if (null == head) {
            head = tNode;
        }else {
            Node<T> tmp = head;
            head = tNode;
            tNode.next = tmp;
        }

    }

    /**
     * 单链表反转 空间复杂度O2
     *          时间复杂度On
     */
    public void reverseWithStack() {
        if (head == null) {
            return;
        }else {
            Stack<T> ts = new Stack<>();
            Node<T> tmp = head;
            while (tmp != null) {
                ts.push(tmp.data);
                tmp = tmp.next;
            }
            Node<T> tmp1 = head;
            while (tmp1 != null) {
                tmp1.data = ts.pop();
                tmp1 = tmp1.next;
            }
        }

    }

    public static void main(String[] args) {
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.add("0AAAA");
        linkedList.add("1BBBB");
        linkedList.add("2CCCC");
        linkedList.add("3DDDD");
        linkedList.add("4EEEEE");
        linkedList.add("5FFFFF");
        linkedList.add("6GGGGG");
        System.out.println("反转前：" + linkedList);
        linkedList.reverseWithStack();
        System.out.println("反转后：" + linkedList);
        LinkedList<String> stack = new LinkedList<>();
        stack.push("1111");
        System.out.println(stack.pop());

    }


}

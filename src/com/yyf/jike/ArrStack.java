package com.yyf.jike;

import java.util.Arrays;

/**
 * 两种方式实现栈：
 * 1.顺序栈：通过数组来实现栈
 * 维护一个数组：作为数据容器存放数据
 * 维护一个指针：用于标记栈的顶部位置
 * - 栈的操作：
 * -入栈：将数据存储数组中，在数组中下标位置从小到大存放数据，同时维护栈顶的位置下标+1
 * 数组容量不足时，进行自动扩容,这里设置为2倍扩容
 * -出栈：通过栈顶指针获取到要出栈的元素，将元素从数组中删除，并返回，同时维护栈顶指针下标-1
 */
public class ArrStack<E> {

    /**
     * 数据容器，这里采用数组来实现栈的功能
     */
    private Object[] arr;

    /**
     * 栈顶下标
     */
    private int t;

    /**
     * 有效元素个数
     */
    private int size;

    /**
     * 默认容量为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 自动扩容倍数
     */
    private static final int GROW_MULTIPLE = 2;


    /**
     * 数组容器扩容，这里两倍扩容
     *
     * @return
     */
    private void grow() {
        //如果当前数组容器为空，进行初始化操作
        if (null == arr) {
            arrInit();
        } else {
            //声明一个容量为当前容器GROW_MULTIPLE倍的容器作为新的数组
            //将原数组的数据拷贝到新数组中
            arr = Arrays.copyOf(arr, arr.length * GROW_MULTIPLE);
        }
    }

    /**
     * 数组初始化操作
     */
    private void arrInit() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 入栈操作：将新的元素保存在数组中，同时维护栈顶的下标位置
     * 如果数组容量不足，则进行扩容，扩容结束后在将数据保存
     *
     * @param e
     */
    private void push(E e) {
        //进行初始化
        if (arr == null) {
            arrInit();
        }
        //通过栈顶的位置判断是否需要扩容
        if (t == arr.length - 1) {
            //栈顶已经在数组的最后一个节点，进行扩容操作
            grow();
        }
        //移动栈顶指针
        t++;
        //将数据存储栈顶
        arr[t] = e;
        //维护元素个数
        size++;
    }

    /**
     * 出栈操作：将栈顶元素弹出，从数组中删除，并将栈顶指针下标-1
     *
     * @return
     */
    private E pop() {
        if (arr == null) {
            arrInit();
        }
        //获取出栈元素
        E e = (E) arr[t];
        //维护栈顶指针
        t--;
        //维护元素个数
        size--;
        return e;
    }

    /**
     * peek查看操作：查看栈顶数据
     *
     * @return
     */
    private E peek(){
       return (E) arr[t];
    }

    public static void main(String[] args) {
        ArrStack<String> stack = new ArrStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        int size = stack.size;
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}

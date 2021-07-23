package com.yyf.lagou;

import java.util.Arrays;

/**
 * 数组实现栈操作
 */
public class ArrayStack {

    private int size;

    private int[] container;

    public ArrayStack(int capacity){
        container = new int[capacity];
    }

    //压栈
    public void push(int data){
        if(size == container.length){
            resize();//扩容
        }
        //考虑扩容操作
        container[size] = data;
        size++;
    }

    //弹栈
    public int pop(){
        size--;
        int popData = container[size];
        return popData;
    }

    //扩容操作
    public void resize(){
        int newCapacity = 2 * size;
        int[] newContainer = new int[newCapacity];
        System.arraycopy(container,0,newContainer,0,container.length);
        container = newContainer;
    }

    public void disPlay(){
        System.out.println("Stack：" + Arrays.toString(container));
        System.out.println("size："+ size);
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.pop();
        arrayStack.disPlay();
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.disPlay();
    }
}

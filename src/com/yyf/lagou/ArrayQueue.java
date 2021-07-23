package com.yyf.lagou;

import java.util.Arrays;

/**
 * 使用数组来实现队列
 */
public class ArrayQueue {

    private int[] container;
    private int size;

    public ArrayQueue(int capacity){
        container = new int[capacity];
        size = 0;
    }

    /**
     * 如果可以在不违反容量限制的情况下立即将指定元素插入此队列。 当使用容量受限的队列时，此方法通常比add更可取，它可能仅通过抛出异常而无法插入元素。
     * 参数：e - 要添加的元素
     * 返回：如果元素已添加到此队列中，则为true ，否则为false
     */
    public void offer(int data){
        if(size == container.length){
            resize();
        }
        container[size] = data;
        size++;
    }

    /**
     * 检索并移除此队列的头部，如果此队列为空，则返回null 。
     * 返回：此队列的头部，如果此队列为空，则为null
     */
    public int poll(){
        int result = 0;
        if(size > 0){
            result = container[0];
            //将后续的元素数据向前移动
            for (int i = 0; i < container.length - 1; i++) {
                container[i] = container[i + 1];
            }
            container[container.length -1] = 0;
            size --;
        }
        return result;
    }

    //扩容方法
    public void resize(){
        int[] newContainer = new int[2 * container.length];
        System.arraycopy(container,0,newContainer,0,container.length);
        container = newContainer;
    }

    public void disPlay(){
        System.out.println("size：" + size);
        System.out.println(Arrays.toString(container));
    }

}

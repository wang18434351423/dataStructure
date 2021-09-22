package com.yyf.lagou.array;

/**
 * 链表实现队列
 */
public class LinkedQueue {

    private Node head;

    private Node tail;

    //入队操作
    public void offer(String data){
        Node node = new Node(data);
        if(null == head){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }

    //出队操作，将队头出队
    public String poll(){
        if(null == head){
            return null;
        }
        Node tmp = head;
        //设置新队头
        head = head.next;
        //将旧队头的下一个节点指向null 让gc进行回收
        tmp.next = null;
        return tmp.data;
    }

    public void disPlay(){
        System.out.println(head);
    }

}

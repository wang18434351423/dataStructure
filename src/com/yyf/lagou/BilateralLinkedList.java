package com.yyf.lagou;

import java.util.*;

/**
 * 双向链表
 */
public class BilateralLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void disPlay(){
        System.out.println("size："+size);
        System.out.println("head："+head);
        System.out.println("tail："+tail);
    }

    //头部添加
    public void addFirst(String data){
        Node node = new Node(data);
        if(null == head){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    //在尾部进行添加
    public void addLast(String data){
        Node node = new Node(data);
        if(null == tail){
            tail = node;
            head = node;
        }else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(String data){
        addLast(data);
    }

    public void remove(String data){
        if(size == 0){
            return;
        }
        Node tmp = head;
        while (tmp != null){
            if (tmp.data.equals(data)){
                if(tmp.prev == null){
                    removeFirst();
                    return;
                }else if(tmp.next == null){
                    removeLast();
                    return;
                }else {
                    //删除中间节点
                    Node prev = tmp.prev;
                    Node next = tmp.next;
                    prev.next = next;
                    next.prev = prev;
                }
            }
            tmp = tmp.next;
        }
        size--;
    }

    public void removeFirst(){
        if(size == 0){
            return;
        }
        if(size == 1){
            head = null;
            tail = null;
            return;
        }
        //删除头结点
        Node next = head.next;
        head = next;
        next.prev = null;
        size--;
    }

    public void removeLast(){
        if(size == 0){
            return;
        }
        if(size == 1){
            head = null;
            tail = null;
            return;
        }
        //删除尾节点
        Node prev = tail.prev;
        prev.next = null;
        tail = prev;
        size--;
    }

    public Boolean contains(String data){
        if (size != 0){
            Node tmp = head;
            while (tmp != null){
                if(tmp.data == data){
                    return true;
                }
                tmp = tmp.next;
            }
        }
        return false;
    }

    public void addAll(Collection<String> collection){
        if(null == collection){
            return;
        }
        Node tmp = tail;
        for (String s : collection) {
            tmp.next = new Node(s);
            tmp = tmp.next;
            size++;
        }
        tail = tmp;
    }

    public static void main(String[] args) {
        BilateralLinkedList linkedList = new BilateralLinkedList();
        linkedList.addLast("张零");
        linkedList.addLast("张一");
        linkedList.addLast("张二");
        linkedList.addLast("张三");
        ArrayList<String> list = new ArrayList<>();
        list.add("张四");
        list.add("张五");
        list.add("张六");
        list.add("张七");
        linkedList.addAll(list);
        linkedList.disPlay();
    }
}

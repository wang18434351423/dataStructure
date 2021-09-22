package com.yyf.lagou.array;


/**
 * 单链表
 */
public class SingleLinkedList {

    private Node head = new Node(0, "");

    /**
     * 添加节点从头部插入
     */
    public void addFirst(Node node){
        node.next = head;
        head = node;
    }

    /**
     * 从尾部添加节点
     */
    public void addLast(Node node){
        Node tmp = head;
        while (true){
            if (tmp.next == null){
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     * 添加节点
     */
    public void addNode(Node node){
        addLast(node);
    }

    /**
     * 基于id精确插入
     */
    public void addNodeByOrder(Node node){
        Node tmp = head;
        while (true){
            //到尾节点
            if(tmp.next == null){
                break;
            }
            //找到匹配的
            if(tmp.next.id >= node.id){
                break;
            }
            tmp = tmp.next;
        }
        node.next = tmp.next;
        tmp.next = node;
    }

    public void disPlay(){
        if(null == head.next){
            System.out.println("链表为空");
            return;
        }
        Node tmp =  head;
        while (tmp != null){
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }

    static class Node {
        int id;
        String name;
        Node next;
        Node(int id,String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

}

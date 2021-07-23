package com.yyf.lagou;

/**
 * 链表实现栈
 */
public class LinkedStack {

    private Node head;

    //压栈
    public void push(String data){
        Node node = new Node(data);
        if (null == head){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    //弹栈
    public String pop(){
        if(head == null){
            System.out.println("栈中已无数据");
            return null;
        }else {
            String data = head.data;
            head = head.next;
            return data;
        }
    }

    public void disPlay(){
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data+"-");
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("1");
        linkedStack.push("2");
        linkedStack.push("3");
        linkedStack.push("4");
        linkedStack.disPlay();
        System.out.println(" ");
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        linkedStack.disPlay();
        System.out.println(linkedStack.pop());
        linkedStack.push("1");
        linkedStack.disPlay();
        System.out.println(" ");
        System.out.println(linkedStack.pop());
    }
}

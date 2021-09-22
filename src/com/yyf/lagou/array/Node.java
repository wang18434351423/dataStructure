package com.yyf.lagou.array;

public class Node {

    String data;
    Node prev;
    Node next;

    public Node(String data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}

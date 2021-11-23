package com.yyf.jike;

import com.yyf.leetcode.LeetCode876;

/**
 * 两种方式实现栈的方式：
 * 2.链表栈
 *   需要维护一个链表来保存数据，把链表的尾部作为栈顶位置
 *   -  栈的操作：
 *      -   入栈操作：将数据保存到链表的头部，将原来的头部设置为新节点的next节点
 *      -   出栈操作：将链表的头部的数据进行删除，原来的头节点的next节点作为新的头节点
 */
public class LinkedStack {

    /**
     * 头节点
     */
    private ListNode head;

    public static class ListNode<E> {
        E val;
        ListNode next;

        ListNode() {
        }

        ListNode(E val) {
            this.val = val;
        }

        ListNode(E val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                stringBuilder.append(",").append(node.val);
                node = node.next;
            }
            return "[ " + stringBuilder.substring(1) + " ]";
        }
    }

}

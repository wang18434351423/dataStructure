package com.yyf.test;


public class Test {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode node) {
        return reverse(null,node);
    }

    private static ListNode reverse(ListNode pre, ListNode node) {
        if (node == null) {
            return pre;
        }
        ListNode next = node.next;
        node.next = pre;
        return reverse(node,next);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.next;
        }
        System.out.println("");
        ListNode node = reverseList1(head);
        ListNode tmp1 = node;
        while (tmp1 != null) {
            System.out.print(tmp1);
            tmp1 = tmp1.next;
        }

    }

}



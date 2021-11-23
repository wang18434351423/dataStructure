package com.yyf.leetcode;

import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1], n = 1
 * 输出：[]
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class LeetCode19 {

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
            StringBuilder stringBuilder = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                stringBuilder.append(",").append(node.val);
                node = node.next;
            }
            return "[ " + stringBuilder.substring(1) + " ]";
        }
    }

    /**
     * 思路：获取删除节点的前一个节点，将它的next指针指向下一个节点的next，
     * 获取链表的长度length，从头遍历链表，i + n = length i位置的节点就是我们要找的节点
     * 在操作链表时，我们需要给链表设置头节点之前的哨兵节点，方便跳过对头节点的特殊处理
     * 时间复杂度 O(n) 空间复杂度 O(1)
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        ListNode sen = new ListNode(-1, head);
        tmp = sen;
        int i = 0;
        while (tmp != null) {
            if (i + n == length) {
                break;
            }
            i++;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return sen.next;
    }

    /**
     * 通过多维护一个栈来进行操作，思路：将链表中的元素通过遍历的手段都存放到stack中，利用栈先进后出的特性，
     * 遍历弹出栈中的元素，找到要删除元素的前一位元素，将它的next指针指向删除元素的next指针
     * 添加一个哨兵节点，防止链表头部的特殊处理
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndWithStack(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode sen = new ListNode(-1, head);
        ListNode tmp = sen;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        return sen.next;
    }

    /**
     * 双指针方式：维护两个指针，f 和 s，第一次遍历 s 不动，将 f 从头节点移动到链表中 n 的位置
     * 这时 f 和 s 之间相差 n 个位置，第二次遍历，f 和 s 同时移动，当 f 指向 null 时，说明 f 已经
     * 在链表最尾部的位置了，此时的 s 位置就是倒数第n个元素的位置，为了操作方便我们需要找的是第n个元素
     * 的上一个元素，这时我们可以引入哨兵节点，让s从哨兵节点开始遍历，这样找到的就是第n个元素的上一个
     * 元素了，将其next指针指向n的next
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFormEndWithDoublePoint(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode f = head;
        //第一次循环
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        //第二次循环
        ListNode cur = s;
        while (f != null) {
            f = f.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return s.next;
    }


    public static void main(String[] args) {
       ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        //ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFormEndWithDoublePoint(head, 2));
    }

}
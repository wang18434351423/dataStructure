package com.yyf.leetcode;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例1：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class LeetCode876 {

    public static class ListNode {
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
     * 双指针寻找链表的中间位置：声明指针 f 和 s，f指针每次移动两个下标，s指针每次移动一个指针
     * 循环当f指针无法移动时终止，当 f 指针无法移动时，判断 f.next 为空 则中间节点为 s
     * 判断 f.next.next 为空，则中间节点为 s.next
     * 时间复杂度O(n) 空间复杂度 O(1)
     *
     * @param head
     * @return
     */
    public static ListNode middleNodeWithDoublePoint(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    /**
     * 通过数组寻找链表的中间位置：声明一个数组在保存元素的同时记录元素的个数下标
     * 最后数组中有数据的节点的(最大下标 + 1)/2位置的元素就是链表的中间节点
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @return
     */
    public static ListNode middleNodeWithArray(ListNode head){
        ListNode[] arr = new ListNode[100];
        ListNode tmp = head;
        int i = 0;
        while (tmp != null) {
            arr[i++] = tmp;
            tmp = tmp.next;
        }
        return arr[i/2];
    }

    /**
     * 单指针寻找链表的中间位置：声明一个指针n，遍历链表在n上保存
     * @param head
     * @return
     */
    public static ListNode middleNodeWithOnePoint(ListNode head) {
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        int k = 0;
        tmp = head;
        while (k < n/2) {
            k++;
            tmp = tmp.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6))))));
        System.out.println(middleNodeWithOnePoint(head));

    }

}

package com.yyf.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {

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
     * 递归解法 时间复杂度O(m+n)
     * 两个链表头部值较小的一个节点与剩余的元素进行合并材质
     * 如果l1和l2一开始就是空链表，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们需要判断l1和l2哪个链表的头节点的值更小，然后递归的决定下一个添加到结果里的节点。
     * 复杂度分析：时间复杂度 O(M+n)，其中n和m分别为两个链表的长度。每次递归调用都会去掉l1或l2
     * 的头节点（直到有一个链表为空），函数mergeTwoLists最多只会递归每一个节点一次。
     * 空间复杂度：O(m+n)，其中n和m分别为两个链表的长度。递归调用mergeTwoLists函数需要消耗栈空间，
     * 占空间的大小取决于递归调用的深度。在这里的递归中，mergeTwoLists函数最多被调用n+m次。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }


    /**
     * 迭代解法：引入哨兵节点，方便用来保存结果数据
     * 采用迭代方式来实现上述算法，需要一个结果集来保存数据，当l1和l2都不是空链表时，判断l1和l2哪一个链表的头节点的值更小
     * 将较小的值添加到结果中，当一个节点被添加到结果中后，对应链表中的节点指针向后移动一位。
     * 首先，我们设定一个哨兵节点，方便用来保存结果数据，维护一个pre指针，我们需要做的就是调整它的next指针。
     * 重复下面的过程：如果l1当前节点的值小于等于l2，我们就把l1当前节点赋值给pre节点的next属性，同时将l1的指针向后移动一位。
     *              如果l1当前节点的值大于l2，我们就把l2当前节点的值赋值给pre节点的next属性，同时将l2的指针向后移动一位。
     *              最后都需要吧pre的指针向后移动一位。
     * 在循环终止时，l1和l2中最多有一个非空的，由于l1和l2都是有序的，而且前面的顺序已经排好了，所以只需要把剩余的非空的几点指
     * 给pre的next节点即可
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsIt(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode pre = sentry;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return sentry.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode(5,new ListNode(6)))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node = mergeTwoListsIt(l1, l2);
        System.out.println(node);
    }

}

package com.yyf.leetcode;

import java.util.HashSet;

/**
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    /**
     * 链表环形检测--基于hash表
     * 时间复杂度O(n),空间复杂度O(n)
     * @param head
     * @return
     */
    public boolean hasCycleWithHash(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return true;
            }
            set.add(tmp);
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * 快慢指针法，环形链表检测
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycleWithDoublePoint(ListNode head) {
        if (head == null) return false;
        ListNode m = head;
        ListNode k = head.next;
        while (m.next != null && k != null  && k.next != null) {
            if ( m == k ) {
                return true;
            }
            m = m.next;
            k = k.next.next;
        }
        return false;
    }


}

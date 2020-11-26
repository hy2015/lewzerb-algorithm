package com.lewzerb.leetcode.s0101_0200;


import com.lewzerb.leetcode.ListNode;

public class Leetcode0143 {

    /**
     * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例1:
     *
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     *
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reorder-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Leetcode0143 leetcode0143 = new Leetcode0143();
        leetcode0143.reorderList(l1);

        ListNode.print(l1);
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = dummy.next;
        ListNode second = reverseList(slow.next);
        slow.next = null;

        while (first!=null&& second!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

package com.lewzerb.leetcode;

public class Leetcode0025 {

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

        Leetcode0025 leetcode0025 = new Leetcode0025();
        ListNode kGroup = leetcode0025.reverseKGroup(l1, 3);
        ListNode.print(kGroup);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        int count = 0;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && count < k){
            count++;
            pre = cur;
            cur = cur.next;
        }

        if(count == k){
            ListNode end = cur;
            pre.next = null;
            ListNode newHead = reverseListNode(head);
            head.next = reverseKGroup(end, k);

            return newHead;
        }else {
            return head;
        }
    }

    private ListNode reverseListNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null, tmp;
        ListNode cur = head;

        while (cur != null){
            tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

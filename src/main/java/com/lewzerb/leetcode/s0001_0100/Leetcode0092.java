package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.ListNode;

public class Leetcode0092 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l5 = new ListNode(7);

        l1.next = l2;
        Leetcode0092 leetcode0092 = new Leetcode0092();
        ListNode res = leetcode0092.reverseBetween(l1, 1, 2);
        ListNode.print(res);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        if(m == n) return head;
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode pre = null;
        ListNode cur = dummy;
        ListNode tail = null;

        int index = 0;
        while (cur != null){
            if(index == n){
                head.next = cur;
                tail.next = cur.next;
            }
            if(index > n) break;

            ListNode next = cur.next;
            if(index == m - 1){
                head = cur;
            }
            if(index == m){
                cur.next = pre;
                pre = cur;
                tail = cur;
            }else if(index > m){
                cur.next = pre;
                pre = cur;
            }

            cur = next;
            index++;
        }
        return dummy.next;
    }
}

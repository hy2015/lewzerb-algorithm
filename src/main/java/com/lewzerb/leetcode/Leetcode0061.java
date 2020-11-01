package com.lewzerb.leetcode;

public class Leetcode0061 {

    /*public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        while (head!=null){
            count++;
            head = head.next;
        }
        head = dummy.next;
        for(int i=0; i<k%count; i++){
            head = rotateRightOne(head);
        }
        return head;
    }

    private ListNode rotateRightOne(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        dummy.next = head;

        while (head.next!=null){
            pre = head;
            head = head.next;
        }
        pre.next = null;
        head.next = dummy.next;
        return head;
    }*/

    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null) return head;
        ListNode oldTail = head;
        int count = 1;
        while (oldTail.next!=null){
            count++;
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        int realK = k % count;

        ListNode newTail = head;
        for(int i=0; i<count - realK - 1; i++){
            newTail = newTail.next;
        }
        ListNode newHead  = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

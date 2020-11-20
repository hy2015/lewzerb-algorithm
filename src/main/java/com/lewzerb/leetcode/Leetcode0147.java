package com.lewzerb.leetcode;

import java.util.Objects;

public class Leetcode0147 {

    public static void main(String[] args) {
        // -1->5->3->4->0
        ListNode l1 =  new ListNode(-1);
        ListNode l2 =  new ListNode(5);
        ListNode l3 =  new ListNode(3);
        ListNode l4 =  new ListNode(4);
        ListNode l5 =  new ListNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Leetcode0147 leetcode0147 = new Leetcode0147();
        ListNode head = leetcode0147.insertionSortList(l1);
        ListNode.print(head);
    }


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sortedList = null;

        while (head != null){
            ListNode tmp = head.next;
            head.next = null;
            sortedList = backTrace(sortedList, head);
            head = tmp;
        }
        return sortedList;
    }

    private ListNode backTrace(ListNode sortedHead, ListNode newNode){
        if(sortedHead == null){
            newNode.next = null;
            return newNode;
        }

        ListNode pre = null;
        ListNode cur = sortedHead;
        ListNode dummy = new ListNode(0);
        dummy.next = sortedHead;

        while (cur != null){
            if(newNode.val < cur.val && (pre == null || newNode.val >= pre.val)){
                newNode.next = cur;
                Objects.requireNonNullElse(pre, dummy).next = newNode;
            }
            pre = cur;
            cur = cur.next;
        }

        if(newNode.val >= pre.val){
            pre.next = newNode;
        }
        return dummy.next;
    }
}

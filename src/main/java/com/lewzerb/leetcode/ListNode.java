package com.lewzerb.leetcode;

/**
 * Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void print(ListNode head){
        System.out.print("[ ");
        while (head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print("]");
    }
}

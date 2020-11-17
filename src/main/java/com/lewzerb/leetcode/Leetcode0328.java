package com.lewzerb.leetcode;

public class Leetcode0328 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;

        Leetcode0328 leetcode0328 = new Leetcode0328();
        ListNode newLN = leetcode0328.oddEvenList(l1);

        ListNode.print(newLN);
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode odd = head;
        ListNode even = head.next;

        dummyOdd.next = odd;
        dummyEven.next = even;

        while (odd.next!= null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = dummyEven.next;
        if(even!=null)even.next = null;
        return dummyOdd.next;
    }
}

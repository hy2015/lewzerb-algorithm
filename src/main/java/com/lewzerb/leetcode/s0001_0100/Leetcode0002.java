package com.lewzerb.leetcode.s0001_0100;


public class Leetcode0002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        Leetcode0002 leetcode0002 = new Leetcode0002();
        ListNode res = leetcode0002.addTwoNumbers(l1, l2);

        do {
            System.out.println(res.val);
            res = res.next;
        } while (res != null);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3Head = new ListNode(0);
        ListNode l3 = l3Head.next = new ListNode(0);

        int carry = 0;
        while (true) {
            if (l1 != null && l2 != null) {

                l3.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;

                l1 = l1.next;
                l2 = l2.next;

            } else if (l1 != null) {
                l3.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;

                l1 = l1.next;
            } else if (l2 != null) {
                l3.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;

                l2 = l2.next;
            }

            if (l1 == null && l2 == null) {
                if (carry != 0) {
                    l3.next = new ListNode(1);
                }
                break;
            } else {
                l3.next = new ListNode(0);
                l3 = l3.next;
            }


        }
        return l3Head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry == 1){
            cur.next = new ListNode(1);
        }

        return head.next;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

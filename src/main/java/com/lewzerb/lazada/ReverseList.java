package com.lewzerb.lazada;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode = head;

        ListNode reverse = reverse(head);

        do {
            System.out.println(reverse.value);
            reverse = reverse.next;
        } while (reverse != null);
    }

    static class ListNode {
        int value;
        ListNode next;


        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode cur = null;
        ListNode pre = head;

        while (pre != null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

}

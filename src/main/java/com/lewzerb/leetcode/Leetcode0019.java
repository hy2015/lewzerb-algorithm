package com.lewzerb.leetcode;


public class Leetcode0019 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Leetcode0019 leetcode0019 = new Leetcode0019();
        ListNode newList = leetcode0019.removeNthFromEnd(n1, 2);
        leetcode0019.printListNode(newList);

    }

    // one turn
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i=0; i<=n; i++){
            first = first.next;
        }

        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode copy = head;
        while (copy != null){
            copy = copy.next;
            len++;
        }
        ListNode pre = null;
        copy = head;
        for(int i=0; i<len-n; i++){
            pre = copy;
            copy = copy.next;
        }
        if(pre == null){
            return head.next;
        }else {
            pre.next = copy.next;
        }
        return head;
    }*/

/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reverse = reverseList(head);
        ListNode tail = reverse;
        ListNode post = null;
        for(int i=0; i<n-1; i++){
            post = tail;
            tail = tail.next;
        }
        if(post == null){
            reverse = reverse.next;
        }else {
            post.next = tail.next;
        }

        return reverseList(reverse);
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
*/

    private void printListNode(ListNode head){
        while (head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

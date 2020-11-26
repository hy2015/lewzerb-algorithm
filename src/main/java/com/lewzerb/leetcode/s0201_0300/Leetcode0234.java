package com.lewzerb.leetcode.s0201_0300;

import com.lewzerb.leetcode.ListNode;

public class Leetcode0234 {
    /*public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode pre = null;
        ListNode cur = head;

        while (cur!= null){
            ListNode newCur = new ListNode(cur.val);

            newCur.next = pre;
            pre = newCur;

            cur = cur.next;
        }

        ListNode tail = pre;

        while (head != null && tail != null){
            if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }*/

    /*public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        List<ListNode> list = new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right){
            if(list.get(left).val != list.get(right).val){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Leetcode0234 leetcode0234 = new Leetcode0234();
        System.out.println(leetcode0234.isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head){
        if(head == null) return true;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode cur = slow.next;

        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = tmp;
        }

        while (pre!=null){
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}

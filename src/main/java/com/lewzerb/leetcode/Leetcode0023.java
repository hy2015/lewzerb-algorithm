package com.lewzerb.leetcode;

import java.util.List;

public class Leetcode0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = (left + right) / 2;

        ListNode lList = mergeLists(lists, left, mid);
        ListNode rList = mergeLists(lists, mid + 1, right);
        return mergeTwoLists(lList, rList);
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode copy = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                copy.next = l1;
                l1 = l1.next;
            } else {
                copy.next = l2;
                l2 = l2.next;
            }
            copy = copy.next;
        }

        if(l1 == null ){
            copy.next = l2;
        }
        if(l2 == null){
            copy.next = l1;
        }
        return dummy.next;
    }
}

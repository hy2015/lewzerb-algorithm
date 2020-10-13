package com.lewzerb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode0141 {

   /* Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode cur;
        cur = head;
        while (cur.next != null){
            if(!set.add(cur)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }*/

    // fast / slow pointer
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if(slow == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}

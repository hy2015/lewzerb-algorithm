package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.ListNode;
import java.util.HashSet;
import java.util.Set;

public class Leetcode0142 {

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
    /*public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if(head == null) return null;
        ListNode cur;
        cur = head;
        while (cur.next != null){
            if(!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    } */

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if(slow == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}

package com.lewzerb.leetcode.offer;

import com.lewzerb.leetcode.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Offer006 {
    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(0, head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

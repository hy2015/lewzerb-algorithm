package com.lewzerb.leetcode.s1001_1100;

import java.util.PriorityQueue;

public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int stone: stones){
            pq.offer(stone);
        }

        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a > b){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty()? 0 : pq.poll();
    }
}

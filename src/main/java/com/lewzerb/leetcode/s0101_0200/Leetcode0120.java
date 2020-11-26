package com.lewzerb.leetcode.s0101_0200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0120 {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        Leetcode0120 leetcode0120 = new Leetcode0120();
        System.out.println(leetcode0120.minimumTotal(list));
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }

        int minTotal = Integer.MAX_VALUE;
        for(int i=1; i<triangle.size(); i++){
            for(int j=0; j<triangle.get(i).size(); j++){
                List<Integer> pre = triangle.get(i - 1);
                List<Integer> cur = triangle.get(i);

                int preLeft = j > 0 ? pre.get(j - 1) : Integer.MAX_VALUE;
                int preRight = j < pre.size() ? pre.get(j) : Integer.MAX_VALUE;
                int minPre = Math.min(preLeft, preRight);

                int total = cur.get(j) + minPre;
                cur.set(j, total);
                if(i == triangle.size() - 1){
                    minTotal = Math.min(minTotal, total);
                }
            }
        }
        return minTotal;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}

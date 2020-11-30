package com.lewzerb.leetcode.s0401_0500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode0454 {

    public static void main(String[] args) {
        int[] A ={1, 2};
        int[] B ={-2, -1};
        int[] C ={-1, 2};
        int[] D ={0, 2};
        Leetcode0454 leetcode0454 =  new Leetcode0454();

        System.out.println(leetcode0454.fourSumCount(A,B,C,D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int sumAB = i + j;
                map.put(sumAB, map.getOrDefault(sumAB,0) + 1);
            }
        }
        for (int k : C) {
            for (int l : D) {
                int sumCD = k + l;
                if(map.containsKey(-sumCD)){
                    count += map.get(-sumCD);
            }
        }
        }
        return count;
    }


}

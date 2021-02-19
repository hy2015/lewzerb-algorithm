package com.lewzerb.leetcode.s0801_0900;

import java.util.Arrays;

public class Leetcode0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int a : A){
            sumA += a;
        }
        for(int b : B){
            sumB += b;
        }

        int half = (sumA + sumB) / 2;

        if(sumA > half){
            int diff = sumA - half;

            for(int a : A){
                int b = a - 2 * diff;
                if(b <= 0) continue;
                int idx = Arrays.binarySearch(B, b);
                if(idx > 0){
                    return new int[]{a, b};
                }
            }
        } else {
            int diff = half - sumA;

            for(int a : A){
                int b = a + 2 * diff;
                if(b <= 0) continue;
                int idx = Arrays.binarySearch(B, b);
                if(idx > 0){
                    return new int[]{a, b};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

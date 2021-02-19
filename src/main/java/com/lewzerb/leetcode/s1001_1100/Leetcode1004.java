package com.lewzerb.leetcode.s1001_1100;

public class Leetcode1004 {
    public int longestOnes(int[] A, int K) {
        int len = A.length;

        int left = 0, right = 0;
        int countZero = 0;
        int maxLen = 0;

        while (right < len){
            if(A[right] == 0){
                countZero++;
            }
            while (countZero > K){
                if (A[left++] == 0) {
                    countZero--;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}

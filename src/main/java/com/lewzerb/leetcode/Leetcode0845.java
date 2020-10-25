package com.lewzerb.leetcode;

import java.util.Stack;

public class Leetcode0845 {
    public static void main(String[] args) {
        int[] A = {554,639,596,820};
        Leetcode0845 leetcode0845 = new Leetcode0845();
        System.out.println(leetcode0845.longestMountain(A));
    }

    public int longestMountain(int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        int[] l = new int[n], r = new int[n];
        for(int i=1; i<n; ++i){
            l[i] = A[i] > A[i-1]? l[i-1] + 1: 0;
        }
        for(int i=n-2; i>0; --i){
            r[i] = A[i] > A[i+1]? r[i+1] + 1: 0;
        }

        int maxLen = 0;
        for(int i=1; i<n-1; i++){
            if(l[i] > 0 && r[i] > 0){
                maxLen = Math.max(maxLen, l[i] + r[i] + 1);
            }
        }
        return maxLen;
    }
}

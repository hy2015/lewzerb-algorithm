package com.lewzerb.leetcode;

public class Leetcode0941 {

    public static void main(String[] args) {
        int[] A = {9,8,7,6,5};
        Leetcode0941 leetcode0941 = new Leetcode0941();
        System.out.println(leetcode0941.validMountainArray(A));
    }
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int i = 0;
        while (i+1 < n && A[i] < A[i+1]){
            i++;
        }
        if(i==0 || i == n-1) return false;
        while (i+1 < n && A[i] > A[i+1]){
            i++;
        }
        return i == n-1;
    }

}

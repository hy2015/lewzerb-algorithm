package com.lewzerb.leetcode;

import java.util.Arrays;

public class Leetcode0088 {

    public static void main(String[] args) {
        Object[][] tests = {
            {new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3},
            {new int[]{0,0}, 0, new int[]{1,3}, 2},
            {new int[]{1,3}, 1, new int[]{0}, 0}
        };

        Leetcode0088 leetcode0088 = new Leetcode0088();

        for(Object[] test: tests){
            int[] nums1 = (int[]) test[0];
            int m = (int) test[1];
            int[] nums2 = (int[]) test[2];
            int n = (int) test[3];

            leetcode0088.merge(nums1, m, nums2, n);
            System.out.println(Arrays.toString(nums1));
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n==0) return;

        int p = m + n - 1;
        while (m > 0 && n > 0){
            nums1[p--] = nums1[m-1] > nums2[n-1]?nums1[--m]: nums2[--n];
        }
        System.arraycopy(nums2, 0, nums1, 0, n);
    }
}

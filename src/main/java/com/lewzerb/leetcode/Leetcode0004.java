package com.lewzerb.leetcode;

public class Leetcode0004 {

    /**
     *
     给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

     请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

     你可以假设 nums1 和 nums2 不会同时为空。



     示例 1:

     nums1 = [1, 3]
     nums2 = [2]

     则中位数是 2.0
     示例 2:

     nums1 = [1, 2]
     nums2 = [3, 4]

     则中位数是 (2 + 3)/2 = 2.5
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = m / 2;
        int j = (m + n - 1) / 2 - i;

        while(true){
            if(i == m || j == n || i == 0 || j==0){

            }
            if(nums2[j] > )
        }
    }
}

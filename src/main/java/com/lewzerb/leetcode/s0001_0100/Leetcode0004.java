package com.lewzerb.leetcode.s0001_0100;

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

    public static void main(String[] args) {
        int[][][] testArr = {
            {{1, 3}, {2}},
            {{1, 2}, {3, 4}},
            {{},{1}},
            {{0,0,0,0,0},{-1,0,0,0,0,0,1}}
        };

        Leetcode0004 leetcode0004 = new Leetcode0004();

        for(int[][] testMatrix: testArr){
            System.out.println(leetcode0004.findMedianSortedArrays(testMatrix[0], testMatrix[1]));
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp;
        if(nums1.length > nums2.length){
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0;
        int left = 0, right = m ;
        int halfLeft = (m + n + 1) / 2;
        int median1 = 0, median2 = 0;

        while(left <= right){
            i = (left + right ) /2;
            j = halfLeft - i;

            int num_i_left = i == 0? Integer.MIN_VALUE: nums1[i - 1];
            int num_i_right = i == m? Integer.MAX_VALUE: nums1[i];
            int num_j_left = j == 0? Integer.MIN_VALUE: nums2[j - 1];
            int num_j_right = j == n? Integer.MAX_VALUE: nums2[j];

            if(num_i_left <= num_j_right){
                median1 = Math.max(num_i_left, num_j_left);
                median2 = Math.min(num_i_right, num_j_right);
                left = i + 1;
            }else{
                right = i - 1;
            }


        }

        return (m + n) % 2 == 0? (median1 + median2)/2.0 : median1;
    }
}

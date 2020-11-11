package com.lewzerb.leetcode;

import java.util.Arrays;

public class Leetcode1356 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        Leetcode1356 leetcode1356 = new Leetcode1356();

        System.out.println(Arrays.toString(leetcode1356.sortByBits(arr)));
    }
    public int[] sortByBits(int[] arr) {
        return mergeSortBit(arr, 0, arr.length-1);
    }

    private int[] mergeSortBit(int[] arr, int l, int h){
        if (l == h) {
            return new int[] {arr[l]};
        }

        int mid = l + (h - l)/2;
        int[] leftArr = mergeSortBit(arr, l, mid);
        int[] rightArr = mergeSortBit(arr, mid+1, h);

        int[] newArr = new int[leftArr.length + rightArr.length];
        int m = 0, i = 0, j=0;
        while (i < leftArr.length && j < rightArr.length){
            newArr[m++] =
                Integer.bitCount(leftArr[i]) == Integer.bitCount(rightArr[j])?
                leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++]
                : Integer.bitCount(leftArr[i]) < Integer.bitCount(rightArr[j])? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length){
            newArr[m++] = leftArr[i++];
        }
        while (j < rightArr.length){
            newArr[m++] = rightArr[j++];
        }
        return newArr;
    }
}

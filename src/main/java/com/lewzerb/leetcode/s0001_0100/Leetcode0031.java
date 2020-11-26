package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode0031 {

    public static void main(String[] args) {
        int[][] tests = {
            {1, 2, 3},
            {2, 3, 1},
            {3, 2, 1}
        };

        Leetcode0031 leetcode0031 = new Leetcode0031();
        for(int[] nums: tests){
            leetcode0031.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int r = nums.length - 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[r]);
        int from = 0;
        for(int i=r-1; i>=0; i--){
            Integer top = stack.peek();
            if(nums[i] >= top){
                stack.push(nums[i]);
            } else {
                from = i;
                break;
            }
        }
        if(stack.size() == nums.length) {
            Arrays.sort(nums);
            return;
        }
        int idx = 0;
        while (!stack.isEmpty()){
            Integer pop = stack.pop();


            if(pop > nums[from]){
                idx = r;
            }
            nums[r] = pop;
            r--;
        }
        int tmp = nums[from];
        nums[from] = nums[idx];
        nums[idx] = tmp;
    }
}

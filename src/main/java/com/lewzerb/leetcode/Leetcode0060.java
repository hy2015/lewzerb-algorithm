package com.lewzerb.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Leetcode0060 {

    public static void main(String[] args) {
        Leetcode0060 leetcode0060 = new Leetcode0060();
        long start = System.currentTimeMillis();
        String permutation = leetcode0060.getPermutation(9, 217490);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k){
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i=1; i<n; i++){
            factorial[i] = factorial[i-1] * i;
        }

        --k;
        StringBuilder s = new StringBuilder();
        int[] valid = new int[n+1];
        Arrays.fill(valid, 1);

        for(int i=1; i<=n; i++){
            int order = k / factorial[n-i] + 1;
            for(int j = 1; j<=n; j++){
                order -= valid[j];
                if(order == 0){
                    s.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return s.toString();
    }

    /*public String getPermutation(int n, int k){
        if(n == 1 && k == 1) return String.valueOf(n);
        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
            nums[i-1] = i;
        }
        while (--k > 0){
            nextPermutation(nums);
        }
        StringBuilder s = new StringBuilder();
        for(int i=0; i<n; i++){
            s.append(nums[i]);
        }
        return s.toString();
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
    }*/

    /*public String getPermutation(int n, int k) {
        if(n == 1 && k == 1) return String.valueOf(n);

        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
            nums[i-1] = i;
        }

        List<String> all = new ArrayList<>();
        generate(all, nums, 0, "");
        all.sort(String::compareTo);

        return all.get(k-1);
    }

    private void generate(List<String> res, int[] nums, int start, String prefix){
        if(start == nums.length){
            res.add(prefix);
        }

        for(int i=start; i<nums.length; i++){
            prefix += String.valueOf(nums[i]);
            swap(nums, i, start);
            generate(res, nums, start + 1, prefix);
            prefix = prefix.substring(0, prefix.length() - 1);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }*/
}

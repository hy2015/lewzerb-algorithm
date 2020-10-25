package com.lewzerb.leetcode;

public class Leetcode0042 {
    public int trap(int[] height){
        int left = 0, right = height.length -1;
        int leftMax = 0, rightMax = 0, ans = 0;

        while (left < right){
            if(height[left] < height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else {
                    ans += leftMax - height[left];
                }
                left++;
            }else {
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

}

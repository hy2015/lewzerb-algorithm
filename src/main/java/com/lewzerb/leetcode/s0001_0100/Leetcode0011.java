package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0011 {


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        Leetcode0011 leetcode0011 = new Leetcode0011();
        System.out.println(leetcode0011.maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxVol = 0;
        int i=0, j=height.length-1;
        while (i<j){
            int newVol = (j - i ) * Math.min(height[i], height[j]);
            if(newVol > maxVol){
                maxVol = newVol;
            }
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxVol;
    }
}

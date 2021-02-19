package com.lewzerb.leetcode.s1201_1300;

public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int[] diff = new int[n];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        for(int i=0; i<n; i++){
            diff[i] = Math.abs(ss[i] - ts[i]);
        }

        int maxLen = 0;
        int left = 0, right = 0;
        int sum = 0;

        while (right < n){
            sum += diff[right];

            while (sum > maxCost){
                sum -= diff[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}

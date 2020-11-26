package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode0084 {
    /*public int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        int len = heights.length;

        for(int mid=0; mid<len; mid++){
            int height = heights[mid];
            int left = mid, right = mid;

            while (left>=0 && height <= heights[left]) left--;
            while (right<len && height <= heights[right]) right++;

            maxArea = Math.max(maxArea, (right - left - 1) * height);
        }

        return maxArea;
    }*/

    public int largestRectangleArea(int[] heights){
        int len = heights.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return heights[0];
        }

        int area = 0;
        int[] newHeights = new int[len+2];
        for(int i=0; i<len; i++){
            newHeights[i+1] = heights[i];
        }
        len+=2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for(int i=1; i<len; i++){
            while (heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }
}

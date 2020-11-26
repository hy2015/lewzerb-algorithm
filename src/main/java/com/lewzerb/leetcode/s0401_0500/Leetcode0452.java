package com.lewzerb.leetcode.s0401_0500;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode0452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int x_end = points[0][1];
        for (int[] point : points) {
            if(point[0] > x_end){
                count++;
                x_end = point[1];
            }
        }
        return count;
    }
}

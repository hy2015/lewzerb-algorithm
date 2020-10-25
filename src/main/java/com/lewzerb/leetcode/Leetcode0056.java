package com.lewzerb.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode0056 {
    /*public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res = new int[intervals.length][2];
        int count = 0;

        for(int i=0; i<intervals.length; i++){
            if(i!=0 && intervals[i][0] <= res[count-1][1]){
                res[count-1][1] = Math.max(res[count-1][1], intervals[i][1]);
            }else {
                res[count] = intervals[i];
                count++;
            }
        }
        return Arrays.copyOfRange(res, 0, count);
    }*/

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res = new int[intervals.length][2];
        int count = 0;

        for(int i=0; i<intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            if(count == 0 || res[count-1][1] < L){
                res[count] = new int[]{L, R};
                count++;

            }else {
                res[count-1][1] = Math.max(res[count-1][1], intervals[i][1]);
            }
        }
        return Arrays.copyOfRange(res, 0, count);
    }
}

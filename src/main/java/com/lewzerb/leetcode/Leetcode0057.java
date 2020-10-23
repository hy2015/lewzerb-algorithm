package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0057 {

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3}, {6, 9}
        };
        int[] newIntervals = {2, 5};

        Leetcode0057 leetcode0057 = new Leetcode0057();
        int[][] res = leetcode0057.insert(intervals, newIntervals);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0) return new int[][]{newInterval};
        int n = intervals.length;

        int newStart = newInterval[0], newEnd = newInterval[1];

        List<int[]> res = new ArrayList<>();
        int idx = 0;

        while (idx < n && newStart > intervals[idx][0]){
            res.add(intervals[idx++]);
        }

        if(res.isEmpty() || res.get(res.size() - 1)[1] < newStart){
            res.add(newInterval);
        }else {
            int[] last = res.remove(res.size() - 1);
            last[1] = Math.max(last[1], newEnd);
            res.add(last);
        }

        while (idx < n){
            int[] interval = intervals[idx++];
            int L = interval[0], R = interval[1];

            if(res.get(res.size() - 1)[1] < L){
                res.add(interval);
            }else {
                int[] last = res.remove(res.size() - 1);
                last[1] = Math.max(last[1], R);
                res.add(last);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }


}

package com.lewzerb.leetcode.s0001_0100;

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
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }


}

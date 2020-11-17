package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> (p1[0] - p2[0] == 0)? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> ans = new ArrayList<>();
        for(int[] person: people){
            ans.add(person[1], person);
        }
        return ans.toArray(new int[][]{});
    }
}

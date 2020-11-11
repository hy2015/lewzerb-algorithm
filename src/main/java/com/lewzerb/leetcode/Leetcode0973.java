package com.lewzerb.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode0973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(v -> (v[0] * v[0] + v[1] * v[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
}

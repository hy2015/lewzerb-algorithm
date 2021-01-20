package com.lewzerb.leetcode.s1001_1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1018 {

    public static void main(String[] args) {
        int[] A = {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
        Leetcode1018 leetcode1018 = new Leetcode1018();
        System.out.println(leetcode1018.prefixesDivBy5(A));
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        long sum = 0;
        List<Boolean> res = new ArrayList<>();
        for(int a: A){
            sum = ((sum << 1) + a) % 5;
            res.add(sum == 0);
        }
        return res;
    }
}

package com.lewzerb.leetcode.s0801_0900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] ss = s.toCharArray();
        int start = 0, cnt = 1;

        for(int i=0; i<ss.length; i++){
            if(i == ss.length - 1 || ss[i+1] != ss[i]){
                if(cnt >= 3 ){
                    List<Integer> axis = Arrays.asList(start, i);
                    res.add(axis);
                }
                cnt = 1;
                start = i;
            }else {
                cnt++;
            }
        }
        return res;
    }
}

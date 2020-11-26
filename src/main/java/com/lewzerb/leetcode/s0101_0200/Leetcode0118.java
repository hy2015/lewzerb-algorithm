package com.lewzerb.leetcode.s0101_0200;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0118 {

    public static void main(String[] args) {
        Leetcode0118 leetcode0118 =  new Leetcode0118();
        leetcode0118.generate(6).forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            List<Integer> list = new ArrayList<>();

            for(int j=1; j<=i; j++){
                if(j == 1 || j == i) {
                    list.add(1);
                }else {
                    List<Integer> up = res.get(i - 2);
                    list.add(up.get(j-2) + up.get(j-1));
                }
            }
            res.add(list);
        }
        return res;
    }
}

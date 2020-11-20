package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0119 {

    public static void main(String[] args) {
        Leetcode0119 leetcode0119 = new Leetcode0119();
        System.out.println(leetcode0119.getRow(25));
    }

    public List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<=rowIndex+1; i++){
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
        return res.get(rowIndex);
    }

    // 二项式解法
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(int i=1; i<=rowIndex; i++){
            int k_1 = (int) (((long) res.get(i-1) * (rowIndex - i + 1)) / i);
            res.add(k_1);
        }
        return res;
    }
}

package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0089 {

    public static void main(String[] args) {
        Leetcode0089 leetcode0089 = new Leetcode0089();

        List<Integer> grayCodes = leetcode0089.grayCode(3);
        grayCodes.forEach(code -> System.out.println(Integer.toBinaryString(code)));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(){{add(0);}};
        int head = 1;
        for(int i=0; i<n; i++){
            for(int j=res.size()-1; j>=0; j--){
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}

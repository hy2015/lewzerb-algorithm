package com.lewzerb.leetcode.s0701_0800;

public class Leetcode0771 {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char c : S.toCharArray()){
            if(J.contains(c + "")){
                count++;
            }
        }
        return count;
    }
}

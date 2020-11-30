package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0168 {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if(n > 26 ){
            sb.append(convertToTitle((n-1)/26));
        }
        sb.append((char)('A' + (n-1)%26));
        return sb.toString();
    }
}

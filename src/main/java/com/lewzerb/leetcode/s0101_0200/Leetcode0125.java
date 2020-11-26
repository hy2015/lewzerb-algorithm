package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0125 {

    public static void main(String[] args) {
        String test = "race a car";

        Leetcode0125 leetcode0125 = new Leetcode0125();
        System.out.println(leetcode0125.isPalindrome(test));
    }

    public boolean isPalindrome(String s) {
        if(s==null || s.length() == 0) return true;

        StringBuilder sb = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()){
            if(('0' <= c && c <= '9') || ('a' <=c && c<= 'z')){
                sb.append(c);
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}

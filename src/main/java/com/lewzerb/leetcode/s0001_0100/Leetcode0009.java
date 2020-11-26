package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0009 {

    public static void main(String[] args) {
        int[] tests = {121, -121, 10};

        Leetcode0009 leetcode0009 = new Leetcode0009();
        for(int test : tests){
            System.out.println(leetcode0009.isPalindrome(test));
        }
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = 0;

        int temp = x;
        while(temp != 0){
            y = y * 10 + temp % 10;
            temp /= 10;
        }
        return x == y;
    }
}

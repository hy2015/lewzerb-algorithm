package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0050 {

    public static void main(String[] args) {
        Leetcode0050 leetcode0050 = new Leetcode0050();
        long start = System.currentTimeMillis();
//        System.out.println(Math.pow(0.00001, 2147483647));
        System.out.println(leetcode0050.myPow(1.00001, 1231111));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public double myPow(double x, int n) {

        if(x == 0.0d) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0){
            x = 1 / x;
            b = -b;
        }
        while (b > 0){
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

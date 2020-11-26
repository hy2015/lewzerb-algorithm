package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0029 {

    public static void main(String[] args) {
        Leetcode0029 leetcode0029 = new Leetcode0029();
        System.out.println(leetcode0029.divide(Integer.MIN_VALUE, -1));
        System.out.println(leetcode0029.divide(7, 3));
        System.out.println(leetcode0029.divide(-7, -3));
        System.out.println(leetcode0029.divide(7, -3));
        System.out.println(leetcode0029.divide(-7, 3));
        long start = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(leetcode0029.divide(-2147483648, 2));
        long end = System.currentTimeMillis();
        System.out.println((end-start) + "ms");
    }

  /*  public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return dividend / divisor;
    } */

    public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        if(dividend == 0) return 0;
        int res = 0;
        if(dividend > 0 && divisor > 0){
            while (dividend >= divisor){
                dividend -=  divisor;
                res++;
            }
        }
        if(dividend < 0 && divisor < 0){
            while (dividend <= divisor){
                dividend -=  divisor;
                res++;
            }
        }
        if(dividend > 0 && divisor < 0){
            while (dividend >= -divisor){
                dividend +=  divisor;
                res--;
            }
        }
        if(dividend < 0 && divisor > 0){
            while (dividend <= -divisor){
                dividend += divisor;
                res--;
            }
        }
        return res;
    }
}

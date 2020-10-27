package com.lewzerb.leetcode;

public class Leetcode0069 {

    public static void main(String[] args) {
        Leetcode0069 leetcode0069 = new Leetcode0069();
        System.out.println(leetcode0069.mySqrt(2147395599));
    }


    public int mySqrt(int x) {
        if(x == 0) return 0;

        long l = 0, r = x;
        while (l <= r){
            long m = (r - l) / 2 + l;
            if(m * m > (long) x){
                r = m - 1;
            }else if(m * m < x){
                l = m + 1;
            }else {
                return (int) m;
            }
        }
        return (int)r;
    }
}

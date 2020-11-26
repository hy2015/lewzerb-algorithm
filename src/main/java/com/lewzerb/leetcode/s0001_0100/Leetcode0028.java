package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0028 {

    public static void main(String[] args) {
        Leetcode0028 leetcode0028 = new Leetcode0028();
        System.out.println(leetcode0028.strStr("helloll2", "ll2"));
        System.out.println(leetcode0028.strStr("mississippi", "a"));
        System.out.println(leetcode0028.strStr("a", "a"));
        System.out.println(leetcode0028.strStr("abb", "abb"));
    }

    /*public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }*/

    public int strStr(String haystack, String needle) {
        int l = haystack.length(), n = needle.length();
        if(n == 0) return 0;
        int p = 0, q = 0;
        while (p < l - n + 1){
            while (p < l - n  && haystack.charAt(p) != needle.charAt(0)) p++;

            while (q<n) {
                if(haystack.charAt(p + q) == needle.charAt(q)){
                    q++;
                }else {
                    break;
                }
            }
            if(q == n) {
                return p;
            }else {
                p++;
                q = 0;
            }
        }

        return -1;
    }
}

package com.lewzerb.leetcode;

public class Leetcode0067 {

    public static void main(String[] args) {
        String[][] tests = {
            {"0", "0"},
            {"1", "10"},
            {"1", "11"}
        };
        Leetcode0067 leetcode0067 = new Leetcode0067();
        for(String[] test: tests){
            System.out.println(leetcode0067.addBinary(test[0], test[1]));
        }
    }

    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        String tmp;
        if(m < n){
            tmp = a;
            a = b;
            b = tmp;
        }

        m = a.length();
        n = b.length();

        char[] res = new char[m+1];
        int carry = 0;
        for(int i=m-1; i>=0; i--){
            int ai = a.charAt(i) - '0';
            int bi = n-m+i >= 0 ? b.charAt(n-m+i) - '0': 0;
            res[i+1] = (char) ((ai + bi + carry)% 2 + '0');
            carry = (ai + bi + carry)/2;
        }
        res[0] = (char) (carry + '0');

        if(res[0] == '0') return new String(res,1, res.length - 1);
        return new String(res);
    }
}

package com.lewzerb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode0013 {

    public static void main(String[] args) {
        Object[][] romans = {
            {3, "III"},
            {20, "XX"},
            {4, "IV"},
            {9, "IX"},
            {58, "LVIII"},
            {1994, "MCMXCIV"}
        };

        Leetcode0013 leetcode0013 = new Leetcode0013();

        for(Object[] roman: romans){
            int num = (int) roman[0];
            String ro = (String) roman[1];

            System.out.println(leetcode0013.romanToInt(ro) + " -> " +
                (leetcode0013.romanToInt(ro) == num));
        }
    }


    public int romanToInt(String s) {
        int res = 0;
        int pre = getVal(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            int cur = getVal(s.charAt(i));
            if(cur > pre){
                res -= pre;
            }else {
                res += pre;
            }
            pre = cur;
        }
        res += pre;
        return res;
    }

    private int getVal(char c) {
        switch (c){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default:  return 0;
        }
    }
}

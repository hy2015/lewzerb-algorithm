package com.lewzerb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode0087 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }

        int n = s1.length();
        //判断两个字符串每个字母出现的次数是否一致
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        //如果两个字符串的字母出现不一致直接返回 false
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        for(int i=1; i<n; i++){
            boolean flag = (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
            || (isScramble(s1.substring(0, i), s2.substring(n -i )) && isScramble(s1.substring(i), s2.substring(0, n - i)) ));
            if(flag){
                return true;
            }
        }
        return false;
    }
}

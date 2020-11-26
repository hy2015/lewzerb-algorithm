package com.lewzerb.leetcode.s0201_0300;

public class Leetcode0242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (char c : s.toCharArray()){
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            counts[c - 'a']--;
            if (counts[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

}

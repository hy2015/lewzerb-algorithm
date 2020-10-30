package com.lewzerb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode0076 {

    public static void main(String[] args) {
        String[][] tests = {
//            {"aa", "aa"},
//            {"a", "a"},
            {"ADOBECODEBANC", "ABC"}
        };
        Leetcode0076 leetcode0076 = new Leetcode0076();
        for(String[] test : tests){
            System.out.println(leetcode0076.minWindow(test[0], test[1]));
        }
    }

    Map<Character, Integer> tarMap = new HashMap<>();
    Map<Character, Integer> srcMap = new HashMap<>();

    public String minWindow(String s, String t) {

        if(s == null || t == null) return "";
        int left = 0;
        int right = -1;
        int min = Integer.MAX_VALUE;

        for(char c: t.toCharArray()){
            srcMap.put(c, srcMap.getOrDefault(c, 0) + 1);
        }

        int resL = -1, resR = -1;
       
        while (right < s.length()){
            right++;
            
            if(right < s.length() && srcMap.containsKey(s.charAt(right))){
                tarMap.put(s.charAt(right), tarMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            
            while (isCovered() && left <= right){
                if(right - left + 1 < min){
                    min = right - left + 1;
                    resL = left;
                    resR = left + min;
                }
                if(srcMap.containsKey(s.charAt(left))){
                    tarMap.put(s.charAt(left), tarMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
            

        }
        return resL == - 1 ? "": s.substring(resL, resR);
    }

    private boolean isCovered(){
        if(srcMap.size() == 0) return false;

        for(char c : srcMap.keySet()){
            int have = tarMap.get(c) == null ? 0 : tarMap.get(c);
            if(have < srcMap.get(c)){
                return false;
            }
        }
        return true;
    }

    /**
     * public String minWindow(String s, String t) {
     *         int[] window = new int[128], need = new int[128];
     *         char[] ss = s.toCharArray(), tt = t.toCharArray();
     *         int count = 0, min = ss.length;
     *         for (int i = 0; i < tt.length; i++) {
     *             need[tt[i]]++;
     *         }
     *         int i = 0, j = 0;
     *         int resI = -1, resJ = -1;
     *         while(j < ss.length) {
     *             char c = ss[j];
     *             window[c]++;
     *             if (window[c] <= need[c]) count++;
     *             while(count == tt.length) {
     *                 if (j - i + 1 <= min){
     *                     resI = i;
     *                     resJ = j+1;
     *                     min = j - i + 1;
     *                 }
     *                 window[ss[i]]--;
     *                 if (window[ss[i]] < need[ss[i]]) count--;
     *                 i++;
     *                 if (i >= ss.length) break;
     *             }
     *             j++;
     *         }
     *         return resI == -1? "": s.substring(resI, resJ);
     *     }
     */
}

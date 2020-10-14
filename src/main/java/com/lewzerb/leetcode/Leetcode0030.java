package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode0030 {

    public static void main(String[] args) {
        String[] words = {"foo", "bar"};
        String s = "barfoothefoobarman";
        Leetcode0030 leetcode0030 = new Leetcode0030();

        List<Integer> substring = leetcode0030.findSubstring(s, words);
        substring.forEach(System.out::println);

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || s.length() == 0 || words.length == 0)return res;
        HashMap<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length();
        int wordNum = words.length;
        int totalLen = wordLen * wordNum;

        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(int i=0; i<s.length() - totalLen +1; i++){
            String tmp = s.substring(i, i+totalLen);
            HashMap<String, Integer> tmpMap = new HashMap<>();
            for(int j=0; j<totalLen; j+= wordLen){
                String w = tmp.substring(j, j + wordLen);
                tmpMap.put(w, tmpMap.getOrDefault(w, 0) + 1);
            }
            if(map.equals(tmpMap)) res.add(i);
        }
        return res;
    }


}

package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode0049 {
    /*public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }*/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        for(String str : strs) {
            char[] chars = str.toCharArray();
            long key = 1;
            for(char c : chars){
                key *= prime[c - 'a'];
            }
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

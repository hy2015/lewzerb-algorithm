package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0093 {

    public static void main(String[] args) {
        String[] tests = {
            "25525511135",
            "0000",
            "1111",
            "010010",
            "101023"
        };
        Leetcode0093 leetcode0093 = new Leetcode0093();
        for(String test: tests){
            System.out.println("===============");
            List<String> res = leetcode0093.restoreIpAddresses(test);
            res.forEach(System.out::println);
        }

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if(len > 12) return res;
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void dfs(List<String> res, List<String> path, String s, int begin){
        if(path.size() == 4 && begin == s.length()){
            res.add(String.join(".", path));
        }

        for(int i=begin; i<s.length(); i++){
            if(i - begin > 2) continue;
            String segment = s.substring(begin, i+1);
            int val = Integer.parseInt(segment);
            if(segment.startsWith("0") && segment.length() > 1)continue;
            if(val < 256 && val >= 0){
                path.add(segment);
                dfs(res, path, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

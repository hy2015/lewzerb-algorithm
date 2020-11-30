package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0165 {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        int len = Math.min(v1s.length, v2s.length);
        int i=0;
        for(;i<len; i++){
            int v1int = Integer.parseInt(v1s[i]);
            int v2int = Integer.parseInt(v2s[i]);

            if(v1int > v2int){
                return 1;
            }else if(v1int < v2int){
                return -1;
            }
        }
        if(v1s.length > v2s.length){
            for(;i<v1s.length; i++){
                if(Integer.parseInt(v1s[i]) > 0){
                    return 1;
                }
            }
        }else if(v1s.length < v2s.length){
            for(;i<v2s.length; i++){
                if(Integer.parseInt(v2s[i]) > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}

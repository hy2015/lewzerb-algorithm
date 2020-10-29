package com.lewzerb.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode0071 {

    public static void main(String[] args) {
        Leetcode0071 leetcode0071 = new Leetcode0071();
        String[] tests = {
            "/a/../../b/../c//.//",
            "/a//b////c/d//././/.."
        };
        for(String test: tests){
            System.out.println(leetcode0071.simplifyPath(test));
        }
    }

    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        Deque<String> realPath = new ArrayDeque<>();

        for(String p: paths){
            if(p.equals("..") ){
                if(realPath.size() > 0) realPath.removeLast();
                continue;
            }
            if(p.equals(".") || p.equals("")){
                continue;
            }
            realPath.addLast(p);
        }

        StringBuilder builder = new StringBuilder();
        for(String a: realPath){
            builder.append("/").append(a);
        }
        if(builder.length() == 0) return "/";
        return builder.toString();
    }
}

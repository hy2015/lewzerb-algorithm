package com.lewzerb.leetcode.s0001_0100;

import java.util.Stack;

public class Leetcode0020 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                if(pop != '(' && c == ')') return false;
                if(pop != '[' && c == ']') return false;
                if(pop != '{' && c == '}') return false;
            }
        }
        return stack.isEmpty();
    }

}

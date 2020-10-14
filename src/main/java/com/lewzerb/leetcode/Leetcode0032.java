package com.lewzerb.leetcode;

import java.util.Stack;

public class Leetcode0032 {

    public static void main(String[] args) {
        Leetcode0032 leetcode0032 = new Leetcode0032();
        String[] tests = {
            ")()())",
            "((())))))))))(()()())"
        };
        for(String test: tests){
            System.out.println(leetcode0032.longestValidParentheses(test));
        }
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        char[] arr = s.toCharArray();
        for(int i=0; i< arr.length; i++){

            if(arr[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}

package com.lewzerb.leetcode.s1201_1300;

public class Leetcode1207 {

    public static void main(String[] args) {
        int[][] tests = {
            {1,2,2,1,1,3}
        };

        Leetcode1207 leetcode1207 = new Leetcode1207();
        for(int[] test: tests){
            System.out.println(leetcode1207.uniqueOccurrences(test));
        }
    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] counter = new int[2001];
        int[] counterCounter = new int[2001];

        for (int i : arr) {
            counter[i + 1000]++;
        }

        for(int i: counter){
            if(i!=0 && ++counterCounter[i] > 1) return false;
        }
        return true;
    }
}

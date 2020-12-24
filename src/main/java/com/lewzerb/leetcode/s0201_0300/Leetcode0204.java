package com.lewzerb.leetcode.s0201_0300;

public class Leetcode0204 {

    public static void main(String[] args) {
        Leetcode0204 leetcode0204 = new Leetcode0204();
        System.out.println(leetcode0204.countPrimes(10));
    }

    public int countPrimes(int n) {
        if(n==0) return 0;
        int[] dp = new int[n];

        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + (isPrime(i) ? 1 : 0);
        }
        return dp[n-1];
    }

    // n > 2
    private boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % 2 == 0 || n % i == 0) return false;
        }
        return true;
    }
}

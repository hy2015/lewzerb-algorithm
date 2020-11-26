package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0096 {

    public static void main(String[] args) {
        Leetcode0096 leetcode0096 = new Leetcode0096();
        System.out.println(leetcode0096.numTrees(3));
    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    // 卡塔兰数公式
    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }


    public int numTree3(int n){
        switch(n){
            case 1: return 1;
            case 2: return 2;
            case 3: return 5;
            case 4: return 14;
            case 5: return 42;
            case 6: return 132;
            case 7: return 429;
            case 8: return 1430;
            case 9: return 4862;
            case 10: return 16796;
            case 11: return 58786;
            case 12: return 208012;
            case 13: return 742900;
            case 14: return 2674440;
            case 15: return 9694845;
            case 16: return 35357670;
            case 17: return 129644790;
            case 18: return 477638700;
            case 19: return 1767263190;
            default: return 0;
        }
    }
}

package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0122 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}

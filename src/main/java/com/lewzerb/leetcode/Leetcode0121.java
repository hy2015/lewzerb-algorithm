package com.lewzerb.leetcode;

public class Leetcode0121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int maxProfit = 0;

        int lastMin = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] > lastMin){
                maxProfit = Math.max(prices[i] - lastMin, maxProfit);
            }
            if(prices[i] < lastMin){
                lastMin = prices[i];
            }
        }

        return maxProfit;
    }
}

package org.algorithms.leetcode.easy;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length < 2) {
            return maxProfit;
        }

        int i = 0;
        int j = 1;
        while (j < prices.length) {
            if (prices[j] < prices[i]) {
                i = j;
            } else {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
            j++;
        }
        return maxProfit;
    }

    public static int maxProfitNaive(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length < 2) {
            return maxProfit;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}) + " = " + maxProfitNaive(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {7, 14, 1, 5, 3, 6, 4}) + " = " + maxProfitNaive(new int[] {7, 14, 1, 5, 3, 6, 4}));
    }
}

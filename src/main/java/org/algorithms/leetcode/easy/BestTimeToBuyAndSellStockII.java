package org.algorithms.leetcode.easy;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        int i = 0, j = 1;

        while (j < prices.length) {
            if (prices[j] < prices[j - 1]) {
                profit += (prices[j - 1] - prices[i]);
                i = j;
            }
            if (j == prices.length - 1 && prices[j] > prices[i]) {
                profit += (prices[j] - prices[i]);
            }
            j++;
        }
        return profit;
    }

    // 6 7 8 1 5 3 6 7
    public static int maxProfitSimplified(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints) + " = " + maxProfitSimplified(ints));
        int[] ints1 = {7, 14, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints1) + " = " + maxProfitSimplified(ints1));
    }
}

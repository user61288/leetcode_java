package com.leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class max_profit_2_transactions {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        List<Integer> sum = new ArrayList<Integer>();
        int index = 0;
        int i = 1;

        while (i < prices.length) {
            int sum1 = 0;
            while (i < prices.length && prices[i] > prices[i - 1]) {
                sum1 += prices[i] - prices[i - 1];
                i++;
            }
            if (sum1 != 0) {
                if (sum.size() == 2) {
                    if (sum.get(0) < sum.get(1) && sum1 > sum.get(0)) {
                        sum.remove(0);
                        sum.add(sum1);
                    }
                    if (sum.get(1) < sum.get(0) && sum1 > sum.get(1)) {
                        sum.remove(1);
                        sum.add(sum1);
                    }
                }
                if (sum.size() < 2)
                    sum.add(sum1);
            }
            i++;
        }

        if (sum.size() > 1) return sum.get(0) + sum.get(1);
        return (sum.size() != 0) ? sum.get(0) : 0;

    }
}

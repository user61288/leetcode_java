package com.leetcode_java;

public class buy_and_sell_stock {

    public static void buyAndSell(int[] stock) {
        if(stock == null || stock.length == 0) return;

        int[] stockMin = new int[stock.length];
        int min = stock[0];
        int maxProfit = 0;
        int big = 0;
        int[] twoProfit = new int[2];

        for(int i=0; i<stock.length; i++)
        {
            if(stock[i]<min) min=stock[i];
            stockMin[i]=min;
        }

        twoProfit[0] = stock[0] - stockMin[0];
        twoProfit[1] = stock[1] - stockMin[1];
        maxProfit = (stock[0] - stockMin[0]) + (stock[1] - stockMin[1]);
        for(int i=2; i<stock.length; i++)
        {
            int currProfit = stock[i] - stockMin[i];
            if(currProfit + big > maxProfit) {
                maxProfit = currProfit + big;
                big = addMax(twoProfit, currProfit);
            }
        }

        System.out.println(maxProfit);
    }

    public static int addMax(int[] a, int add) {
        if(a[0]<a[1]) {
            a[0]=add;
        } else {
            a[1] = add;
        }
        return (a[0]<a[1]) ? a[1] : a[0];
    }
}

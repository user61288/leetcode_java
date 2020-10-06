package com.leetcode_java;

public class num_of_squares {
    public static int numSquares(int n) {
        if(n==0) return 0;

        int sqrt = (int) Math.sqrt(n);
        int minCount = Integer.MAX_VALUE;

        for(int i=sqrt;i>=1;i--) {
            int j=i;
            int n1=n;
            int count=0;
            while(j>=1 && n1!=0) {
                int sq = (int) Math.pow(j, 2);
                int d = n1/sq;
                count+=d;
                n1-=d*sq;
                j--;
            }
            minCount = (minCount>count) ? count : minCount;
        }

        return minCount;
    }
}

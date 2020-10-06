package com.leetcode_java;

public class count_tiny_pairs {

    public static int countTinyPairs(int[] a, int[] b, int k) {
        if(a==null || b==null || a.length==0 || b.length==0 || a.length!=b.length) return 0;

        int n = a.length;
        int tiny = 0;
        int i=0;
        int j = n-1;

        while(i<n && j>=0) {
            int a1 = a[i];
            int b1 = b[j];
            String concat = String.valueOf(a1) + String.valueOf(b1);
            if(Integer.parseInt(concat, 10) < k) tiny++;
            i++;
            j--;
        }

        return tiny;
    }
}

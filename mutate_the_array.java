package com.leetcode_java;

public class mutate_the_array {

    public static int[] mutateTheArray(int n, int[] a) {
        if(a==null || a.length==0 || n==0) {
            return new int[0];
        }

        int[] b = new int[n];
        for(int i=0;i<n; i++) {
            int a1 = (i==0) ? 0 : a[i-1];
            int a2 = a[i];
            int a3 = (i==n-1) ? 0 : a[i+1];
            b[i] = a1+a2+a3;
        }

        return b;
    }
}

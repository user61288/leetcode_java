package com.leetcode_java;

public class RemoveDuplicatesFromArray {

    public static void removeDupes(int[] a) {
        if( a== null || a.length == 0) return;

        int prev = Integer.MIN_VALUE;
        int i=0;
        int j=0;

        while(j<a.length) {
            if(a[j]!=prev) {
                swap(a, i, j);
                prev = a[i];
                i++;
                j++;
            } else {
                j++;
            }
        }

        if(i<a.length) {
            for(; i<a.length; i++) {
                a[i]=0;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i]=a[j];
        a[j]=c;
    }
}

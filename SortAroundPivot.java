package com.leetcode_java;

public class SortAroundPivot {

    public static void sort(int[] a, int index) {
        if(a == null || a.length == 0 || index < 0) return;

        int start=0;
        for(int i=0; i<a.length; i++) {
            if(a[i]<a[index]) {
                int tmp = a[start];
                a[start] = a[i];
                a[i] = tmp;
                start++;
            }
        }

        int end=a.length-1;
        for(int i=a.length-1; i>=0; i--) {
            if(a[i]>a[index]) {
                int tmp = a[end];
                a[end] = a[i];
                a[i] = tmp;
                end--;
            }
        }
    }
}

package com.leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class partition_labels {
    //    public static void main(String[] args) {
//        List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");
//        for(int i : res) System.out.print(i+" ");
//    }

    public static List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<Integer>();
        if(s==null || s.trim().length()==0) return res;

        int i=0;
        int n=s.length();

        while(i<n) {
            int start = i;
            char c = s.charAt(i);
            int end = s.lastIndexOf(c);
            for(int j=start; j<=end; j++) {
                int i1 = s.lastIndexOf(s.charAt(j));
                if(i1 >end) {
                    end = i1;
                }
            }
            res.add(end-start+1);
            i=end+1;
        }

        return res;
    }
}

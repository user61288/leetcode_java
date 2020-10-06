package com.leetcode_java;

public class longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {

        if(strs==null ||strs.length==0) return "";

        int n = strs.length;
        String commonPfxString = null;

        if(n==1) return strs[0];

        for(int i=1;i<n; i++) {
            if(i==1) {
                commonPfxString = longestCommonPrefix(strs[0], strs[1]);
                if(commonPfxString == null) break;
            } else {
                commonPfxString = longestCommonPrefix(commonPfxString, strs[2]);
                if(commonPfxString == null) break;
            }
        }

        return (commonPfxString == null) ? "" : commonPfxString;
    }

    public static String longestCommonPrefix(String s1, String s2) {

        if(s1 == null || s2 == null) {
            return null;
        }

        int s1Ln = s1.length();
        int s2Ln = s2.length();
        int smallLn = (s1Ln<s2Ln) ? s1Ln : s2Ln;

        StringBuilder commonPfx = new StringBuilder();
        for(int j=0;j<smallLn;j++) {
            if(s1.charAt(j) == s2.charAt(j)) {
                commonPfx.append(s1.charAt(j));
            } else {
                break;
            }
        }

        return commonPfx.toString();
    }
}

package com.leetcode_java;

import java.util.HashMap;

public class word_code_pattern {
    public static boolean wordPattern(String pattern, String str) {
        if(str==null || pattern==null) return false;

        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;

        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character> wordsSeen = new HashMap<String, Character>();
        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.get(c)!=null || wordsSeen.get(words[i])!=null) {
                if(map.get(c) == null || !map.get(c).equals(words[i])) {
                    return false;
                }
                if(wordsSeen.get(words[i])==null || wordsSeen.get(words[i])!=c) {
                    return false;
                }
            }
            map.put(c, words[i]);
            wordsSeen.put(words[i], c);
        }

        return true;
    }
}

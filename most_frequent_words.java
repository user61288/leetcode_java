package com.leetcode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class most_frequent_words {

    public static List<String> mostFrequent(String helpText, List<String> wordsToExclude) {
        if(helpText == null || helpText.length()==0) return new ArrayList<String>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> helpWords = filterWords(helpText);
        for(String word : helpWords) {
            if(!wordsToExclude.contains(word)) {
                int freq = map.getOrDefault(word, 0);
                map.put(word, freq + 1);
            }
        }

        String[] result = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(result, (a, b) -> (map.get(a)==map.get(b) ? a.compareTo(b) : map.get(a)-map.get(b)));

        return Arrays.asList(result);
    }

    public static List<String> filterWords(String text) {
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<String>();

        for(int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            if(Character.isUpperCase(c) || Character.isLowerCase(c))
                sb.append(Character.toLowerCase(c));
            else {
                words.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        return words;
    }
}

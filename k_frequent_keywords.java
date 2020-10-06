package com.leetcode_java;

import java.util.*;

public class k_frequent_keywords {

    public static String[] findKFrequentKeywords(String[] reviews, String[] keywords, int k)
    {
        if(reviews == null || keywords == null || k==0) {
            return null;
        }

//        HashSet<String> keSet = new HashSet<>(Arrays.asList(ke));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String review : reviews) {
            review = review.toLowerCase();
            for(String kw : keywords) {
                int freq = map.get(kw) == null ? 0 : map.get(kw);
                kw = kw.toLowerCase();
                if(review.contains(kw)) {
                    map.put(kw, freq+1);
                }
            }
        }

////        map.computeIfAbsent()
//        String[] keyArray = map.keySet().toArray(new String[]{});
////        Arrays.sort(keyArray, new Comparator<String>() {
////            @Override
////            public int compare(String s, String t1) {
////                if(map.get(s) == map.get(t1)) return s.compareToIgnoreCase(t1);
////                return map.get(s) - map.get(t1);
////            }
////        });
//
//        Arrays.sort(keyArray, (s,t1) -> ((map.get(s) == map.get(t1))? s.compareToIgnoreCase(t1) :  map.get(s) - map.get(t1)));
//
//        List<String> someList = Arrays.asList(keyArray);
//        return someList.subList(0,k);

        PriorityQueue<String> set = new PriorityQueue<String>(map.size(), new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if(map.get(s) == map.get(t1)) return s.compareToIgnoreCase(t1);
                return map.get(t1) - map.get(s);
            }
        });

        for(String n :map.keySet()) {
            set.add(n);
        }

        String[] result = new String[k];
        for(int i=0; i<k; i++) {
            result[i] = set.remove();
        }

        return result;
    }
}

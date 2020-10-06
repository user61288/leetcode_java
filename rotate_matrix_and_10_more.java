package com.leetcode_java;

import java.util.*;
import java.util.LinkedList;

public class rotate_matrix_and_10_more {

//    public static int[][] rotateMatrix(int n) {
//        int[][] a = new int[n][n];
//        int k = 1;
//        int new1 = 0;
//        int i=0;
//        int j=0;
//        for(i=0; i<Math.ceil(n-1)/2; i++) {
//            for(j=i; j<n-1-i; j++) {
//                new1 = k;
//                a[i][j] = new1;
//                new1 += n-1-2*i;
//                a[j][n - 1 - i] = new1;
//                new1 += n-1-2*i;
//                a[n - 1 - i][n - 1 - j] = new1;
//                new1 += n-1-2*i;
//                a[n - 1 - j][i] = new1;
//                k++;
//            }
//            k = new1+1;
//        }
//
//        if(new1<n*n)
//            a[i][j-1] = new1+1;
//
//        return a;
//    }

    public static boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0)) {
            return false;
        }

        if (p == null || p.length() == 0) return true;

        char[][] plist = new char[p.length()][2];
        int pInd = 0;
        for (int i = 1; i <= p.length(); i++) {
            char c1 = p.charAt(i - 1);
            char c2 = (i<p.length()) ? p.charAt(i) : '0';
            plist[pInd][0] = c1;
            if (c2 != '*') {
                plist[pInd][1] = '0';
            } else {
                plist[pInd][1] = '*';
                i += 1;
            }
            pInd++;
        }

        int sInd = 0;
        for (char[] re : plist) {
            if (re[0] != 0 && re[1] != 0) {
                if (re[1] == '*') {
                    if (re[0] == '.') {
                        sInd = s.length();
                    } else {
                        while (sInd < s.length() && s.charAt(sInd) == re[0]) {
                            sInd++;
                        }
                    }
                } else {
                    if (re[0] == '.') {
                        sInd++;
                    } else {
                        if (re[0] != s.charAt(sInd)) {
                            break;
                        } else {
                            sInd++;
                        }
                    }
                }
            }
        }

        if (s.length() - sInd == 0) return true;
        return false;
    }

    public static List<String> getLessKDistinct(String input, int k) {

        if(input == null || input.length()==0 || k==0) {
            return null;
        }

        if(k>input.length()) return null;

        int n = input.length();
        boolean d[] = new boolean[n-k+1];
        char repeatChar='0';
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i<d.length; i++) {
            char[] substr = input.substring(i, i+k).toCharArray();
            if(i==0) {
                for (int j = 0; j < k; j++) {
                    int freq = map.getOrDefault(substr[j], 0);
                    map.put(substr[j], freq + 1);
                }
                d[i] = checkHashMap(map);
            } else {
                char prevChar = input.charAt(i-1);
                char newChar = input.charAt(i+k-1);
                map.put(prevChar, map.get(prevChar)-1);
                map.put(newChar, map.getOrDefault(newChar,0) + 1);
                if(d[i-1]) {
                    for(Character c : map.keySet()) {
                        if(map.get(c) == 2) repeatChar = c;
                    }
                    if (repeatChar != '0' && repeatChar != prevChar) {
                        d[i] = (newChar != repeatChar);
                    }
                } else {
                    d[i] = checkHashMap(map);
                }
            }
        }

        List<String> result = new ArrayList<String>();
        for(int i=0; i<d.length; i++) {
            if(d[i]) result.add(input.substring(i, i+k));
        }

        return result;
    }

    public static boolean checkHashMap(HashMap<Character, Integer> map) {
        boolean foundTwoCount = false;

        for(Character c : map.keySet()) {
            if(map.get(c) == 0) continue;
            else if(map.get(c) > 2) return false;
            else if(map.get(c)==2) {
                if(foundTwoCount) return false;
                else foundTwoCount = true;
            } else if(map.get(c)!=1) return false;
        }

        return foundTwoCount;
    }

    public static String decodeString(String s) {
        if(s==null || s.length()==0) return "";

        return getNextString(s,0, s.length()-1);
    }

    public static  String getNextString(String s, int start, int end) {
        StringBuilder decodedString = new StringBuilder();

        while(start<end) {
            if(Character.isLowerCase(s.charAt(start))) {
                decodedString.append(s.charAt(start));
                start++;
            } else {
                int open = getOpenBrace(start, end, s);
                int repeatTimes = getRepeatTimes(start, open-1, s);
                int close = getCloseBrace(open, end, s);
                String stringToRepeat = getNextString(s, open+1, close);

                for(int i=0; i<repeatTimes; i++) {
                    decodedString.append(stringToRepeat);
                }

                start = close+1;
            }

        }

        return decodedString.toString();
    }

    public static  int getOpenBrace(int start, int end, String s) {
        while(start<end && s.charAt(start) !='[') {
            start++;
        }
        return start;
    }

    public static  int getRepeatTimes(int start, int end, String s) {
        int num=0;
        while(start<=end) {
            num=num*10 + Character.digit(s.charAt(start), 10);
            start++;
        }
        return num;
    }

    public static  int getCloseBrace(int start, int end, String s) {
        int opening=0;

        for(;start<end; start++) {
            if(s.charAt(start)=='[') opening++;
            else if(s.charAt(start)==']') opening--;
            if(opening<=0) return start;
        }

        return start;
    }

    public static int getDist(String word1, String word2) {
        int dist = 0;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i)!=word2.charAt(i)) dist++;
        }

        return dist;
    }

    static class Pair {
        String string;
        int t;

        public Pair(String string, int t) {
            this.string = string;
            this.t = t;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null || wordList.size()==0) {
            return 0;
        }

        if(beginWord == null || endWord == null) return 0;

        if(!wordList.contains(endWord)) return 0;

        int transform = Integer.MAX_VALUE;
        java.util.LinkedList<Pair> q = new java.util.LinkedList<Pair>();
        Pair firstPair = new Pair(beginWord,0);
        q.add(firstPair);
        HashSet<String> ancestors = new HashSet<String>();

        while(!q.isEmpty()) {
            Pair nextPair = q.poll();
            String nextWord = nextPair.string;
            int currentT = nextPair.t;
            if(nextWord.equals(endWord)) {
                transform = (currentT<transform) ? currentT : transform;
            } else {
                ancestors.add(nextWord);
                for (int i = 0; i < wordList.size(); i++) {
                    if (getDist(nextWord, wordList.get(i)) == 1 && !ancestors.contains(wordList.get(i))) {
                        q.add(new Pair(wordList.get(i), currentT + 1));
                        ancestors.add(wordList.get(i));
                    }
                }
            }
        }

        return transform+1;
    }

    static List<List<String>> result = new ArrayList<List<String>>();
    public static List<List<String>> ladderLengthII(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null || wordList.size()==0) return result;
        if(beginWord == null || endWord == null) return result;
        if(!wordList.contains(endWord)) return result;
        LinkedHashSet<String> ancestors = new LinkedHashSet<String>();

        dfs(ancestors, beginWord, endWord, wordList);
        return result;
    }

    public static void dfs(LinkedHashSet<String> ancestors, String nextWord, String endWord, List<String> wordList) {

        if (nextWord.equals(endWord)) {
            result.add(new ArrayList<String>(ancestors));
            return;
        }

        ancestors.add(nextWord);
        List<String> nextLevel = new ArrayList<String>();
        for (int i = 0; i < wordList.size(); i++) {
            if (getDist(nextWord, wordList.get(i)) == 1 && !ancestors.contains(wordList.get(i))) {
                nextLevel.add(wordList.get(i));
            }
        }

        if (!nextLevel.isEmpty()) {
            for(int i=0; i<nextLevel.size(); i++) {
                dfs(ancestors, nextLevel.get(i), endWord, wordList);
            }
        }
    }

    public static List<List<String>> ladderLength89(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        if(wordList==null || wordList.size()==0) return result;
        if(beginWord == null || endWord == null) return result;
        if(!wordList.contains(endWord)) return result;

        java.util.LinkedList<List<String>> q = new java.util.LinkedList<List<String>>();
        List<String> firstPair = Arrays.asList(new String[]{beginWord});
        q.add(firstPair);
        HashSet<String> ancestors = new HashSet<String>();

        int minLen = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            List<String> nextPair = q.poll();
            String nextWord = nextPair.get(nextPair.size()-1);
            if(nextWord.equals(endWord)) {
                if(nextPair.size() < minLen) {
                    result.clear();
                    result.add(nextPair);
                    minLen = nextPair.size();
                } else if(nextPair.size() == minLen) {
                    result.add(nextPair);
                }
            } else {
                ancestors.add(nextWord);
                for (int i = 0; i < wordList.size(); i++) {
                    if (getDist(nextWord, wordList.get(i)) == 1 && !ancestors.contains(wordList.get(i))) {
                        List<String> toAdd = new ArrayList<String>(nextPair);
                        toAdd.add(wordList.get(i));
                        q.add(toAdd);
                        //ancestors.add(wordList.get(i));
                    }
                }
            }
        }

        return result;
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        if(rows==0 && cols==0) return 0;

        int totalSentence = 0;
        for(int i=0; i<sentence.length; i++) {
            totalSentence+=sentence[i].length()+1;
        }
        totalSentence--;

        if(cols==totalSentence) return rows;
        if(cols<totalSentence && rows==1) return 0;
        //if(cols==1 && rows!=totalSentence) return 0;

        int[] r = new int[rows];
        Arrays.fill(r, 0);
        int index = 0;
        int j=0;
        int i=0;

        while(j<cols && i<rows) {
            if(index==sentence.length) index=0;
            int wordSpace = sentence[index].length();
            if(wordSpace<=cols-j) {
                r[i] +=1;
                j+=wordSpace+1;
                index++;
            } else if(wordSpace>cols-j) {
                i++;
                j=0;
            }

            if(j>=cols) {
                j=0;
                i++;
            }
        }

        int maxCount = 0;
        for(int count : r) maxCount+=count;
        return maxCount/sentence.length;
    }

    public static int fib(int n) {
        int prev = 0;
        int next = 1;
        int res = 0;

        for(int i=2; i<=n; i++) {
            res = prev + next;
            prev = next;
            next = res;
       }

        return res;
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || wordDict == null || wordDict.size()==0) return true;

        return checkWordBreak(s, 0, wordDict);
    }

    public static boolean checkWordBreak(String s, int i, List<String> wordDict) {
        if(i<s.length()) {
            boolean wordFound = false;
            for(String word : wordDict) {
                String subStr = (i+word.length()<=s.length()) ? s.substring(i, i+word.length()) : null;
                if(subStr != null && word.equals(subStr)) {
                    i+=word.length();
                    wordFound = checkWordBreak(s, i, wordDict);
                    if(wordFound==true)
                        break;
                }
            }
            if(!wordFound) return false;
        }

        return true;
    }

    public static List<String> wordBreakII(String s, List<String> wordDict) {

        List<String> result = new ArrayList<String>();
        if(s==null || wordDict == null || wordDict.size()==0) return null;

        LinkedList<List<String>> q = new LinkedList<List<String>>();
        q.add(0, new ArrayList<String>());

        while(!q.isEmpty()) {
            List<String> fromQ = q.poll();
            int index=0;
            for(String str : fromQ) index+=str.length();

            if(index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for(String str : fromQ) {
                    sb.append(str).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                result.add(sb.toString());
            } else {
                for(String word : wordDict) {
                    if(index+word.length()<s.length() && word.equals(s.substring(index, index+word.length()))) {
                        fromQ.add(word);
                        q.add(new ArrayList<String>(fromQ));
                    }
                }
            }
        }

        return result;
    }

    static HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        getCombination(candidates, 0, target, new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(set);
    }

    public static void getCombination(int[] candidates, int sum, int target, List<Integer> currList) {

//        if(sum>target) return;

        if(sum == target) {
            List<Integer> newSet = new ArrayList<Integer>(currList);
            Collections.sort(newSet);
            set.add(newSet);
        }

        for(int candidate : candidates) {
            sum += candidate;
            if(sum>target) {
                sum-=candidate;
            } else if(sum<=target) {
                currList.add(candidate);
                getCombination(candidates, sum, target, currList);
                currList.remove(currList.size()-1);
                sum-=candidate;
            }
        }
    }

    public static String alienOrder(String[] words) {

        if(words == null || words.length==0) return null;

        HashMap<Character, List<Character>> adjList = new HashMap<Character, List<Character>>();
        HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();

        for(String word : words) {
            for(int i=0; i<word.length(); i++) {
                adjList.computeIfAbsent(word.charAt(i), k -> new ArrayList<Character>());
                inDegree.put(word.charAt(i), 0);
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length()!=word2.length() && (word1.startsWith(word2) || word2.startsWith(word1))) {
                continue;
            }

            for(int j=0; j<word1.length(); j++) {
                if(word1.charAt(j)!=word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    int count = inDegree.get(word2.charAt(j));
                    inDegree.put(word2.charAt(j), count+1);
                    break;
                }
            }
        }

        LinkedList<Character> q = new LinkedList<Character>();
        for(Character c : inDegree.keySet()) {
            if(inDegree.get(c)==0) q.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            Character fromQ = q.poll();
            for(Character adj : adjList.get(fromQ)) {
                int count = inDegree.get(adj);
                inDegree.put(adj, count-1);
                if(inDegree.get(adj)==0) {
                    q.add(adj);
                }
            }
            sb.append(fromQ);
        }

        return sb.toString();
    }

    public static char add(char a, char b) {
        return Character.forDigit((a-'0')+(b-'0'), 10);
    }

    public static char sub(char a, char b) {
        return Character.forDigit((a-'0')-(b-'0'), 10);
    }

    public static int calculate(String s) {

        if(s==null) return Integer.MIN_VALUE;

        Stack<Character> st = new Stack<Character>();
        int n = s.length();
        int i=0;

        while(i<n) {
            char c = s.charAt(i);
            if(c=='(' || c=='+' || c=='-' || Character.isDigit(c)) {
                st.push(c);
            } else if(c==')' || c==' ') {
                if(st.isEmpty()) {
                    i++;
                    continue;
                }
                char op1 = st.pop();
                char res = '0';
                while(op1!='(' || !st.isEmpty()) {
                    char operator = st.pop();
                    char op2 = st.pop();
                    if(operator == '+') {
                        res = add(op2, op1);
                    } else if(operator == '-') {
                        res = sub(op2, op1);
                    }
                    if(st.peek() != '(') st.push(res);
                    else {
                        st.pop();
                        st.push(res);
                        break;
                    }
                }
            } else if(c==' ') {

            }
            i++;
        }

        while(!st.isEmpty() && st.size()>1) {
            // do calc from stack
            char op1 = st.pop();
            char res = '0';
            char operator = st.pop();
            char op2 = st.pop();
            if(operator == '+') {
                res = add(op2, op1);
            } else if(operator == '-') {
                res = sub(op2, op1);
            }
            st.push(res);
        }

        return Character.digit(st.pop(), 10);
    }

    public static void main(String[] args) {

        System.out.println(calculate(" 2-1 + 1"));
//        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));

//        List<List<Integer>> ladder = combinationSum(new int[]{2,3,6,7}, 7);
//
//        for(List<Integer> l : ladder) {
//            for(int s : l) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }


        //System.out.println(wordBreakII("catsanddog", Arrays.asList("cats","dog","sand","and","cat")));

//        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
//        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18,19}));

        //System.out.println(fib(7));
//        String[] sentence = new String[]{"I", "a", "b"};
//        System.out.println(wordsTyping(sentence, 3, 1));


//        List<List<String>> ladder = ladderLength89("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
//
//        for(List<String> l : ladder) {
//            for(String s : l) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }

//        int[][] res = rotateMatrix(6);
//
//        for(int i=0; i<6; i++) {
//            for(int j=0; j<6;j++) {
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();

//            String s = "aab";
//            String p =".*c";
//
//            System.out.println(isMatch(s,p));

            //System.out.println(decodeString("3[a2[c]]"));
    }
}

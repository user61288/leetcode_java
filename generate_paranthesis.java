package com.leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class generate_paranthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        addParanthesis(ans, "", 0, 0, n);
        return ans;
    }

    public static void addParanthesis(List<String> ans, String cur, int openP, int closeP, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (openP < max)
            addParanthesis(ans, cur+"(", openP+1, closeP, max);
        if (closeP < openP)
            addParanthesis(ans, cur+")", openP, closeP+1, max);
    }
}

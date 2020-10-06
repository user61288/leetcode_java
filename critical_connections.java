package com.leetcode_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class critical_connections {
        public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> conn) {

            if(n==0 || conn == null ) return null;

            List<List<Integer>> criticalN = new ArrayList<List<Integer>>();
            HashMap<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
//            for(List<Integer> c : conn) {
//                int v1 = c.get(0);
//                int v2 = c.get(1);
//                List<Integer> list = g.get(v1) == null ? new ArrayList<Integer>() : g.get(v1);
//                list.add(v2);
//                g.put(v1, list);
//                list = g.get(v2) == null ? new ArrayList<Integer>() : g.get(v2);
//                list.add(v1);
//                g.put(v2, list);
//            }

            for(int i=0; i<n; i++) {

                for(List<Integer> c : conn) {
                    int v1 = c.get(0);
                    int v2 = c.get(1);
                    List<Integer> list = g.get(v1) == null ? new ArrayList<Integer>() : g.get(v1);
                    list.add(v2);
                    g.put(v1, list);
                    list = g.get(v2) == null ? new ArrayList<Integer>() : g.get(v2);
                    list.add(v1);
                    g.put(v2, list);
                }

                int nodeToRemove = i;
                HashMap<Integer, List<Integer>> newg = g;
                boolean connected = checkConnections(newg, n, nodeToRemove);
                if(!connected) {
                    criticalN.add(g.get(nodeToRemove));
                }
            }

            return criticalN;
        }

        public static boolean checkConnections(HashMap<Integer, List<Integer>> g, int n, int nodeToRemove) {

            int start = 0;
            for(int node : g.get(nodeToRemove)) {
                g.get(node).remove(new Integer(nodeToRemove));
                start = node;
            }

            int count = 0;
            boolean[] visited = new boolean[n];
            for(int i=0; i<n; i++) {
                visited[i] = false;
            }

            Stack<Integer> stack = new Stack();
            stack.push(start);
            while(!stack.isEmpty()) {
                int popped = stack.pop();
                visited[popped] = true;
                count++;
                for(int node : g.get(popped)) {
                    if(!visited[node]) {
                        stack.push(node);
                    }
                }
            }

            if(count == n-1) return true;
            return false;
        }
    }

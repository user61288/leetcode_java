package com.leetcode_java;

import java.util.Queue;
import java.util.LinkedList;

public class rotten_oranges_redo {

        static class Coordinate {
            int x;
            int y;

            public Coordinate(int i, int j) {
                x=i;
                y=j;
            }
        }

        public static int orangesRotting(int[][] grid) {

            if (grid == null) return -1;

            int m = grid.length;
            int min = 0;
            int n = grid[0].length;

            Queue<Coordinate> q = (Queue<Coordinate>) new LinkedList<Coordinate>();
            int size = m * n;
            int[][] nearby = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int count = 0;
            boolean minUseful = false;

            boolean visited[][] = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                    if (grid[i][j] == 1) count++;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    minUseful = false;
                    if (!visited[i][j]) {
                        if (grid[i][j] == 0) {
                            visited[i][j] = true;
                        } else if (grid[i][j] == 2) {
                            q.add(new Coordinate(i, j));
                        }
                        while (!q.isEmpty()) {
                            Coordinate c = q.remove();
                            for (int k = 0; k < nearby.length; k++) {
                                int c1 = c.x + nearby[k][0];
                                int c2 = c.y + nearby[k][1];
                                if (c1 >= 0 && c1 < m && c2 >= 0 && c2 < n && visited[c1][c2] == false) {
                                    if (grid[c1][c2] == 2)
                                        q.add(new Coordinate(c1, c2));
                                    else if (grid[c1][c2] == 1) {
                                        minUseful = true;
                                        grid[c1][c2] = 2;
                                        count--;
                                    }
                                }
                            }
                            visited[i][j] = true;
                        }
                        if(minUseful) min++;
                    }
                }
            }

            if (count == 0) return min;
            System.out.println(count);
            return -1;
        }

//        public static void main(String[] args) {
//            int[][] grid = {{2,1,1}, {1,1,0}, {1,0,1}};
//
//            System.out.println(orangesRotting(grid));
//        }
}

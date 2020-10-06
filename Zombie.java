package com.leetcode_java;

import java.util.List;
import java.util.PriorityQueue;

public class Zombie {

    static class Coordinate {
        int x;
        int y;

        Coordinate(int i, int j) {
            x=i;
            y=j;
        }
    }

    public static int minHours(int rows, int columns, List<List<Integer>> grid) {

        if(grid == null) return 0;

        int hours = 0;
        PriorityQueue<Coordinate> queue = new PriorityQueue<Coordinate>();

        for(int i=0; i<rows; i++) {
            for(int j=0;j<columns; j++) {
                if(grid.get(i).get(j) == 1) {
                    hours ++;
                    queue.add(new Coordinate(i, j));
                    while(!queue.isEmpty()) {
                        Coordinate c = queue.poll();
                        bfs(grid, c.x, c.y, rows, columns);
                    }
                }
            }
        }

        return hours;
    }

    public static void bfs(List<List<Integer>> grid, int i, int j, int rows, int columns) {
        if(i<0 || i>=rows || j<0 || j>=columns || grid.get(i).get(j) == 1) return;

        grid.get(i).set(j,1);
        bfs(grid, i-1, j, rows, columns);
        bfs(grid, i+1, j, rows, columns);
        bfs(grid, i, j-1, rows, columns);
        bfs(grid, i, j+1, rows, columns);
    }

}

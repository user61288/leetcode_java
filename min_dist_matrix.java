package com.leetcode_java;

public class min_dist_matrix {
    public static int[][] updateMatrix(int[][] matrix) {
        if(matrix==null) return new int[0][];

        int m = matrix.length;
        int n = matrix[0].length;
        int k =0;

        int[][] res = new int[m][n];
        int[][] zeroLoc = new int[m*n][2];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {
                    zeroLoc[k]=new int[]{i, j};
                    k++;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res[i][j] = (matrix[i][j]==0) ? 0 : findMinDistZero(matrix, zeroLoc, i, j);
            }
        }

        return res;
    }

    public static int findMinDistZero(int[][] matrix, int[][] zeroLoc, int i, int j) {
        int minDist = Integer.MAX_VALUE;
        for(int[] d : zeroLoc) {
            minDist = Math.min(minDist, Math.abs(i-d[0]) + Math.abs(j-d[1]));
        }

        return minDist;
    }
}

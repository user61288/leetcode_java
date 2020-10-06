package com.leetcode_java;

import java.util.Arrays;

public class three_sum_closest {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length==0) return Integer.MAX_VALUE;

        Arrays.sort(nums);
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        int closestSum = 0;

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int start = j;
                int end = n-1;
                while(start<end) {
                    int partialSum = nums[start] + nums[end];
                    int currentDist = Math.abs(target-(partialSum+nums[i]));
                    if (minDist>currentDist) {
                        minDist=currentDist;
                        closestSum = nums[i] + partialSum;
                    }
                    end--;
                }
            }
        }

        return closestSum;
    }
}

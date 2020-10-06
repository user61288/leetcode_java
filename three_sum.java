package com.leetcode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {

    public static boolean notAlreadyIn(List<List<Integer>> lists, List<Integer> n) {
        for(List<Integer> list : lists) {
            if(list.equals(n)) {
                return true;
            }
        }
        return false;

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums==null) return null;

        if(nums.length==0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int target = 0;
        int start = 0;
        int end = 0;

        for(int i=0;i<n; i++) {
            if(nums[i]!=prev) {
                target = -(nums[i]);
                start = i+1;
                end = n-1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum < target) start += 1;
                    else if (sum > target) end -= 1;
                    else if (sum == target) {
                        List<Integer> newAdd = Arrays.asList(nums[i], nums[start], nums[end]);
                        if(!notAlreadyIn(result, newAdd)) {
                            result.add(newAdd);
                        }
                        start++;
                        end--;
                    }
                }
            }
            prev = nums[i];
        }

        return result;
    }
}

package com.leetcode_java;

public class remove_duplicates {
    public static int removeDuplicates(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }

        if(nums.length==1) return 1;

        int i=1;
        int nextInsert=1;
        int prev=nums[0];
        int n=nums.length;

        while(i<n && nextInsert<n) {
            if(nums[i]!='0') {
                while(i<n && nums[i]==prev) {
                    i++;
                }

                if(i<n) nums[nextInsert] = nums[i];
                prev = nums[nextInsert];
                nextInsert++;
            }
        }

        for(int j=nextInsert; j<n; j++) {
            nums[j] = '0';
        }


        return nextInsert-1;
    }
}

package com.leetcode_java;

import java.util.HashMap;
import java.util.HashSet;

public class RelativeArraySort {

        public static int[] relativeSortArray(int[] arr1, int[] arr2) {
            if(arr1 == null && arr2 == null) return null;
            if(arr2 == null || arr2.length == 0) return arr1;
            if(arr1 == null || arr1.length == 0) return arr2;

            HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
            for(int item : arr1)
            {
                int f = (freq.get(item) == null) ? 0: freq.get(item);
                f+=1;
                freq.put(item, f);
            }

            HashSet<Integer> arr2Set = new HashSet<Integer>();
            for(int item : arr2)
            {
                arr2Set.add(item);
            }

            int i=0;
            int j=0;
            boolean arr2Added = false;

            int[] result = new int[arr1.length];
            while(i<arr1.length)
            {
                int smallest = findSmallest(arr1, arr2Set);
                if(!arr2Added) smallest = (arr2[0] < smallest) ? arr2[0] : smallest;
                if(!arr2Set.contains(smallest))
                {
                    int f = (freq != null && freq.get(smallest)!=null) ? freq.get(smallest) : 0;
                    while(f > 0)
                    {
                        result[j++] = smallest;
                        f--;
                    }
                    if(freq != null) freq.remove(smallest);
                    arr2Set.add(smallest);
                }
                else if(!arr2Added) {
                    if(smallest == arr2[0])
                    {
                        for(int index=0; index<arr2.length; index++)
                        {
                            int f = (freq != null && freq.get(arr2[index])!=null) ? freq.get(arr2[index]) : 0;
                            while(f > 0)
                            {
                                result[j++] = arr2[index];
                                f--;
                            }
                            if(freq != null) freq.remove(arr2[index]);
                        }
                        arr2Added = true;
                        i += arr2.length;
                    }
                }
                i++;
            }
            return result;
        }

        public static int findSmallest(int[] arr1,HashSet<Integer> arr2)
        {
            int smallest = Integer.MAX_VALUE;
            for(int i=0; i<arr1.length; i++)
            {
                if(!arr2.contains(arr1[i])) {
                    if (arr1[i] < smallest) smallest = arr1[i];
                }
            }
            return smallest;
        }
    }


//arr1(contains all of arr2), arr2(distinct)


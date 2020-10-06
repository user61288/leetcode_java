package com.leetcode_java;

public class tree_path_sum {
    //
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;

        pathSumHelper(root, sum, 0);
        return count;
    }

    public void pathSumHelper(TreeNode node, int sum, int partialSum) {
        if(node==null) return;
        if(partialSum + node.val == sum) {
            count++;
            return;
        } else if(partialSum+node.val<sum) {
            partialSum+=node.val;
        } else if(partialSum+node.val>sum) {
            partialSum=0;
        }
        pathSumHelper(node.left, sum, partialSum);
        pathSumHelper(node.right, sum, partialSum);
    }

//    int count = 0;
//    public int pathSum(TreeNode root, int sum) {
//        if(root==null) return 0;
//
//        pathSumHelper(root, sum, new ArrayList<Integer>());
//        return count;
//    }
//
//    public void pathSumHelper(TreeNode node, int sum, List<Integer> list) {
//        if(node==null) return;
//        list.add(node.val);
//
//        pathSumHelper(node.left, sum, list);
//        pathSumHelper(node.right, sum, list);
//
//        int tmp = 0;
//        for(int i = list.size()-1; i>=0; i--) {
//            tmp += list.get(i);
//            if(tmp==sum) count++;
//        }
//        list.remove(list.size()-1);
//    }
}

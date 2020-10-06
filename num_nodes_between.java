package com.leetcode_java;

public class num_nodes_between {
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static int buildBST(int[] nums, int n, int node1, int node2) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        BinaryTreeNode root = new BinaryTreeNode(nums[0]);
        for(int i=1; i<n;i++) {
            if(nums[i]<root.val) {
                if(root.left == null) root.left = new BinaryTreeNode(nums[i]);
                else addToTree(root.left, nums[i]);
            } else if(nums[i]>=root.val) {
                if(root.right == null) root.right = new BinaryTreeNode(nums[i]);
                else addToTree(root.right, nums[i]);
            }
        }

        BinaryTreeNode lca = findLCA(root, node1, node2);

        int numTonode1 = numNodesTo(lca, node1);
        int numTonode2 = numNodesTo(lca, node2);

        if(numTonode1 == -1 || numTonode2 == -1) return -1;
        return numTonode1+numTonode2;
    }

    public static void addToTree(BinaryTreeNode node, int val) {
        while(node!=null && val<node.val) {
            if (node.left == null) {
                node.left = new BinaryTreeNode(val);
                return;
            }
            else {
                node = node.left;
            }
        }

        while(node!=null && val>=node.val) {
            if (node.right == null) {
                node.right = new BinaryTreeNode(val);
                return;
            }
            else {
                node = node.right;
            }
        }
        addToTree(node, val);
    }

    public static BinaryTreeNode findLCA(BinaryTreeNode node, int n1, int n2) {

        if(node == null) return null;
        if(n1<node.val && n2<node.val) {
            return findLCA(node.left, n1, n2);
        } else if(n1>=node.val && n2>=node.val) {
            return findLCA(node.right, n1, n2);
        } else {
            return node;
        }
    }

    public static int numNodesTo(BinaryTreeNode node, int n) {
        int count = 0;
        while(node!=null) {
            if(node.val==n) return count;
            else if(n<node.val) {
                count++;
                node = node.left;
            } else if(n>node.val) {
                count++;
                node = node.right;
            }
        }

        return -1;
    }
}

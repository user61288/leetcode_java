package com.leetcode_java;

import java.util.List;

public class find_lca_I {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }

    public static void buildTree(List<Integer> values, int node1, int node2) {
        TreeNode root = new TreeNode();
        root.val = values.get(0);

        boolean found1 = false;
        boolean found2 = false;

        for(int i=1; i<values.size(); i++) {
            found1=(found1 || (values.get(i)==node1));
            found2=(found2 || (values.get(i)==node1));

            TreeNode node = getNode(values.get(i), root);
            TreeNode newNode = new TreeNode();
            newNode.val = values.get(i);
            if(values.get(i)<node.val) {
                node.left = newNode;
            } else if(values.get(i)>=node.val) {
                node.right = newNode;
            }
        }

        System.out.println();
        if(!found1 || !found2) {
            System.out.println("-1");
            return;
        }

        TreeNode lca = findLCA(root, node1, node2);

        int num1 = numOfNodes(lca, node1);
        int num2 = numOfNodes(lca, node2);

        System.out.println(num1+num2-1);

        // print tree
        //inorder(root);
    }

    public static TreeNode findLCA(TreeNode root, int node1, int node2) {
        if(node1<root.val && node2<root.val) {
            return findLCA(root.left, node1, node2);
        } else if(node1>=root.val && node2>=root.val) {
            return findLCA(root.right, node1, node2);
        } else {
            return root;
        }
    }

    public static int numOfNodes(TreeNode node, int n) {
        int count=0;
        while(true) {
            count++;
            if(n<node.val) node=node.left;
            else if(n>node.val) node=node.right;
            else if(n==node.val) break;
        }

        return count;
    }

    public static TreeNode getNode(int i, TreeNode node) {
        if(i<node.val) {
            if(node.left == null) return node;
            return getNode(i, node.left);
        } else if(i>=node.val) {
            if(node.right==null) return node;
            return getNode(i, node.right);
        }

        return null;
    }

    public static void inorder(TreeNode root) {
        if(root ==null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

package com.leetcode_java;

import java.util.Random;

public class SkipList {

    static int maxHeight = 32;
    SkipListNode headSentinel;
    SkipListNode tailSentinel;
    int level;
    int n;
    Random random;

    class SkipListNode {
        int val;
        SkipListNode left;
        SkipListNode right;
        SkipListNode up;
        SkipListNode down;

        public SkipListNode(int value) {
            val = value;
        }
    }

    public SkipList() {
        headSentinel = new SkipListNode(Integer.MIN_VALUE);
        tailSentinel = new SkipListNode(Integer.MAX_VALUE);
        headSentinel.right = tailSentinel;
        tailSentinel.left = headSentinel;
        random = new Random();
        level = 0;
        n = 0;
    }

    public boolean search(int target) {
        if (n == 0) return false;

        SkipListNode currNode = headSentinel;
        while (currNode.right != null) {
            for(;currNode.right.val <= target; currNode = currNode.right);
            if(currNode.val == target)
                return true;
            if(currNode.down != null) {
                currNode = currNode.down;
                continue;
            } else { break;}
        }
        return false;
    }

    public void add(int num) {
        SkipListNode currNode = headSentinel;
        int i=0;
        while (currNode.right != null) {
            for(;currNode.right.val <= num; currNode = currNode.right);
            if(currNode.down != null) {
                currNode = currNode.down;
                continue;
            } else {
                break;
            }
        }
        SkipListNode newNode = new SkipListNode(num);
        currNode.right.left = newNode;
        newNode.right = currNode.right;
        currNode.right = newNode;
        newNode.left = currNode;
        i++;

        while(random.nextInt() % 2 == 0) {
            if(i>level) {
               addNewLevel();
            }
            SkipListNode buildNode = new SkipListNode(num);

            SkipListNode prevNode = currNode.up;
            while(prevNode == null) {
                if (currNode.left == null) break;
                currNode = currNode.left;
                prevNode = currNode.up;
            }
            buildNode.down = newNode;
            newNode.up = buildNode;
            buildNode.right = prevNode.right;
            prevNode.right = buildNode;
            buildNode.left = prevNode;

            i++;
        }

        n++;
    }

    public void addNewLevel() {
        SkipListNode newHeadSentinel = new SkipListNode(Integer.MIN_VALUE);
        SkipListNode newTailSentinel = new SkipListNode(Integer.MAX_VALUE);
        newHeadSentinel.right = newTailSentinel;
        newTailSentinel.left = newHeadSentinel;

        newHeadSentinel.down = headSentinel;
        headSentinel.up = newHeadSentinel;
        headSentinel = newHeadSentinel;

        newTailSentinel.down = tailSentinel;
        tailSentinel.up = newTailSentinel;
        tailSentinel = newTailSentinel;

        level ++;
    }

    public boolean erase(int num) {
        boolean rtn = false;
        SkipListNode currNode = headSentinel;
        while (currNode.right != null) {
            for(;currNode.right.val <= num; currNode = currNode.right);
            if(currNode.down != null) {
                currNode = currNode.down;
                continue;
            } else { break; }
        }

        while(currNode != null) {
            if (currNode.val == num) {
                rtn = true;
                currNode.left.right = currNode.right;
                currNode.right.left = currNode.left;
            }
            currNode = currNode.up;
        }
        if (rtn) { n--; }
        return rtn;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */


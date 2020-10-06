package com.leetcode_java;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode_java.rotten_oranges_redo.orangesRotting;

public class Main {

    public static void main(String[] args) {
//        runLinkedList();
//        runSkipList();
//        sortArray();
//        sortPivot();
//        addOne();
//        multiply();
//        removeDupes();
//        stock1();
//        frequentKeywords();
//        criticalConnections();
        rottenOranges();
    }

    public static void runLinkedList() {
//        LinkedList<Integer> linkedList = new LinkedList<Integer>(); // Initialize empty LinkedList
//        linkedList.print();
//        linkedList.addAtHead(1);
//        linkedList.print();
//        linkedList.addAtTail(3);
//        linkedList.print();
//        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//        linkedList.print();
//        System.out.println(linkedList.get(1));            // returns 2
//        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//        linkedList.print();
//        System.out.println(linkedList.get(1));            // returns 3
    }

    public static void runSkipList() {
        SkipList skiplist = new SkipList();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));   // return false.
        skiplist.add(4);
        System.out.println(skiplist.search(1));   // return true.
        skiplist.erase(0);    // return false, 0 is not in skiplist.
        skiplist.erase(1);    // return true.
        System.out.println(skiplist.search(1));   // return false, 1 has already been erased.
        System.out.println("finish");
    }

    public static void sortArray() {
        int[] a1 = {2,3,1,3,2,4,6,7,9,7,2,19};
        int[] a2 = {2,4,3,9,6};

        int[] result = RelativeArraySort.relativeSortArray(a1, a2);
        for(int p : result) {
            System.out.println(p);
        }
    }

    public static void frequentKeywords() {
        String[] a1 = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};
        String[] a2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        int k=2;

        String[] result = k_frequent_keywords.findKFrequentKeywords(a1, a2, k);
        for(String p : result) {
            System.out.println(p);
        }
    }

    public static void sortPivot() {
        int[] a1 = {2,3,1,3,2,4,6,7,9,7,19};

        SortAroundPivot.sort(a1, 3);
        for(int p : a1) {
            System.out.println(p);
        }
    }

    public static void addOne() {
        int[] a1 = {9,9,9,9};

        int[] result = add_multiply_arrays.addOne(a1);
        for(int p : result) {
            System.out.println(p);
        }
    }

    public static void multiply() {
        int[] a1 = {-9,9,9};
        int[] a2 = {-9,9,9};

        int[] result = add_multiply_arrays.multiply(a1, a2);
        for(int p : result) {
            System.out.println(p);
        }
    }

    public static void removeDupes() {
        int[] a1 = {2,3,3,3,3,11,11,11,13};

        RemoveDuplicatesFromArray.removeDupes(a1);
        for(int p : a1) {
            System.out.println(p);
        }
    }

    public static void stock1() {
        int[] a1 = {310,315,275,295,260,270,290,230,255,250};

        buy_and_sell_stock.buyAndSell(a1);
    }

    public static void zombie() {
//       List<List<Integer>> grid = Arrays.asList(Arrays.asList(new int[]{0, 1, 1, 0, 1}), Arrays.asList(new int[]{0, 1, 0, 1, 0}),
//               Arrays.asList(new int[]{0, 0, 0, 0, 1}),Arrays.asList(new int[]{0, 1, 0, 0, 0}));
//        Stock.buyAndSell(a1);
    }

    public static void criticalConnections() {
       int v1 = 0;
       int v2 = 1;
       int v3 = 2;
       int v4=3;
//        Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]

       List<Integer> conn1 = new ArrayList<Integer>();
       conn1.add(v1);
       conn1.add(v2);

        List<Integer> conn2 = new ArrayList<Integer>();
        conn2.add(v2);
        conn2.add(v3);

        List<Integer> conn3 = new ArrayList<Integer>();
        conn3.add(v3);
        conn3.add(v1);

        List<Integer> conn4 = new ArrayList<Integer>();
        conn4.add(v2);
        conn4.add(v4);

        List<List<Integer>> connections = new ArrayList<List<Integer>>();
        connections.add(conn1);
        connections.add(conn2);
        connections.add(conn3);
        connections.add(conn4);

        List<List<Integer>> result = critical_connections.criticalConnections(4, connections);

        for(List<Integer> nodes : result) {
            System.out.println(nodes.get(0) + " " + nodes.get(1) );
        }
    }

    public static void rottenOranges() {
//        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
//        int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
        int[][] grid = {{0,2}};

        System.out.println(orangesRotting(grid));
    }
}

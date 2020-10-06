package com.leetcode_java;

public class linked_list<C> {

    LinkedListNode head;
    int n;

    class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode() {
//            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /** Initialize your data structure here. */
    public linked_list() {
        n = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 && index > n) return -1;

        LinkedListNode currNode = head;
        for(int i=0; i<index; i++) {
            currNode = currNode.next;
        }

        return currNode.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.value = val;
        if (n != 0) {
            newNode.next = head;
        }
        head = newNode;
        n++;
    }

    /** Append a node of value val to the last element of the linked list.
     * @param val*/
    public void addAtTail(int val) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.value = val;

        LinkedListNode currNode = head;
        for(; currNode.next!=null; currNode=currNode.next);
        currNode.next = newNode;
        n++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.value = val;

        LinkedListNode currNode = head;
//        LinkedListNode revNode = null;
        for(int i=0; i<index-1; i++) {
//            prevNode = currNode;
            currNode = currNode.next;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;
        n++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (0<=index && index<n) {
            LinkedListNode currNode = head;
            LinkedListNode prevNode = null;
            for(int i=0; i<index; i++) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            prevNode.next = currNode.next;
            n--;
        }
    }

    public void print() {
        if (n == 0 ) return;
        LinkedListNode currNode = head;
        for(int i = 0; i<n; i++) {
            System.out.print(currNode.getValue());
            currNode = currNode.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
**/


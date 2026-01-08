package com.dsa.linkedList.utility;


public class FlattenListNode {
    public int val;
    public FlattenListNode next;
    public FlattenListNode child;

    public FlattenListNode() {
        val = 0;
        next = null;
        child = null;
    }

    public FlattenListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    public FlattenListNode(int data1, FlattenListNode next1, FlattenListNode next2) {
        val = data1;
        next = next1;
        child = next1;
    }
}
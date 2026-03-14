package com.dsa.linkedList.Problems.doubly_implementation;

public class DoublyLinkedList_Node {
     int data;
     DoublyLinkedList_Node prev;
     DoublyLinkedList_Node next;

    public DoublyLinkedList_Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public DoublyLinkedList_Node(int data, DoublyLinkedList_Node prev, DoublyLinkedList_Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedList_Node getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedList_Node prev) {
        this.prev = prev;
    }

    public DoublyLinkedList_Node getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList_Node next) {
        this.next = next;
    }
}

package com.dsa.linkedList.Problems.doubly_implementation;

public class DoublyLinkedList_Implementation {
    private DoublyLinkedList_Node headNode;
    private DoublyLinkedList_Node tailNode;
    private int length;

    public DoublyLinkedList_Implementation(){
        headNode =new DoublyLinkedList_Node(Integer.MIN_VALUE,null,null);
        tailNode =new DoublyLinkedList_Node(Integer.MIN_VALUE,null,null);
        headNode.next = tailNode;
        length = 0;
    }

    public int getPosition(int data){
        DoublyLinkedList_Node temp = headNode;
        int pos = 0;
        while(temp != null ){
            if(temp.data == data){
                // return the position if found
                return pos;
            }
            pos++;
            temp = temp.next;
        }
        return Integer.MIN_VALUE;
    }

    public int length(){
        return  length;
    }

    /** --  -- */
    public void insertAtHead(int newValue){
        DoublyLinkedList_Node newNode = new DoublyLinkedList_Node(newValue, null, headNode.next);
        newNode.next.prev = newNode;
        headNode = newNode;
        length++;
    }

    /** --  -- */
    public void insertAtIntermediate(int data, int position){
        if(position < 0) position = 0;
        if (position > length) position = length;

        if(headNode == null){
            headNode = new DoublyLinkedList_Node(data);
            tailNode = headNode;
        }else if(position == 0){
            DoublyLinkedList_Node temp = new DoublyLinkedList_Node(data);
            temp.next = headNode;
            headNode = tailNode;
        }else {
            DoublyLinkedList_Node temp = headNode;
            for(int i=0; i < position; i++)
                temp.next = temp.next;

            DoublyLinkedList_Node newNode = new DoublyLinkedList_Node(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            temp.next = newNode;
        }
        length++;
    }

    public void insertTail(int newValue){
        DoublyLinkedList_Node newNode = new DoublyLinkedList_Node(newValue, tailNode.prev, tailNode);
        newNode.prev.next = newNode;
        tailNode.prev = newNode;
        length++;
    }

    public void remove(int position){
        if(position < 0) position = 0;
        if(position >= length) position = length-1;

        if(headNode == null) return;

        // Removing at Head element
        if(position == 0){
            headNode = headNode.next;
            if(headNode == null) tailNode = null;
        } else {
            DoublyLinkedList_Node temp = headNode;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        length--;
    }

    // Remove node matching the specified node from list
    public synchronized void removedMatched(DoublyLinkedList_Node node){
        if (headNode == null) return;
        if(node.equals(headNode)){
            headNode = headNode.next;
            if (headNode == null) tailNode = null;
            return;
        }

        DoublyLinkedList_Node temp = headNode;
        while (temp != null){
            if(node.equals(temp)){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
        }
    }

    // Remove the head value from the list. If the list empty do nothing
    public int removeHead(){
        if(length == 0) return Integer.MIN_VALUE;
        DoublyLinkedList_Node nextHead = headNode.next;
        headNode.next = nextHead.next;
        nextHead.next.prev = headNode;
        length--;
        return nextHead.data;
    }

    // Remove the tail value from the list. IF the list is empty do nopthing.
    public int removeTail(){
        if(length == 0)
            return  Integer.MIN_VALUE;
        DoublyLinkedList_Node newTail = tailNode.prev;
        tailNode.prev = newTail.prev;
        newTail.prev.next = tailNode;
        length--;
        return newTail.data;
    }

    public void clearList(){
        headNode = null;
        tailNode = null;
        length = 0;
    }


}

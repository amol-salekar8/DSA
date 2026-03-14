package com.dsa.queue.Implementation;

import com.dsa.linkedList.Problems.utility.ListNode;

public class Linked_List_Implementation_Queue {
    private int length;
    private ListNode front, rear;

    public  Linked_List_Implementation_Queue(){
        length = 0;
        front = rear = null;
    }

    public void enQueue(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()) front = node;
        else rear.next = node;
        rear = node;
        length++;
    }

    public int deQueue() throws  Exception{
        if(isEmpty()) throw new Exception("Queue is Underflow");
        int result = front.val;
        front = front.next;
        length--;
        if(isEmpty()) rear = null;
        return result;
    }

    public int first() throws  Exception{
        if(isEmpty()) throw new Exception();
        return front.val;
    }

    public boolean isEmpty(){
        return (length == 0);
    }

    public int size(){
        return  length;
    }
}

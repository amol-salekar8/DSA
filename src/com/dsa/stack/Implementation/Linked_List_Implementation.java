package com.dsa.stack.Implementation;

import com.dsa.linkedList.Problems.utility.ListNode;

import java.util.EmptyStackException;

public class Linked_List_Implementation<T> {
    // Size
    private int length;

    private ListNode top;

    public  Linked_List_Implementation(){
        length = 0;
        top = null;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() throws EmptyStackException {
        if(isEmpty())
            throw  new EmptyStackException();
        int result = top.val;
        top = top.next;
        length--;
        return  result;
    }

    public int peek()throws EmptyStackException{
        if(isEmpty())
            throw  new EmptyStackException();
        return top.val;
    }

    public boolean isEmpty(){
        return  length == 0;
    }

    public int size(){
        return  length;
    }

    public String toString(){
        String result = "[";
        ListNode temp = top;
        while(temp != null){
            result = result + temp.toString()+"\n";
            temp = temp.next;
        }
        return result;
    }
}

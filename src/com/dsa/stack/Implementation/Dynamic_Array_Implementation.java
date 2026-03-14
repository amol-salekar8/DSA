package com.dsa.stack.Implementation;

public class Dynamic_Array_Implementation {
    // Length of stack
    protected int capacity;

    // Default capacity
    public static final int CAPACITY = 16; // Power of 2
    public static final int MIN_CAPACITY = 1 << 15; // power of 2

    // Array to implement stack
    protected  int[] stackRep;

    protected int top = -1;

    // With default capacity
    public Dynamic_Array_Implementation(){
        this(CAPACITY);
    }

    // Given capacity
    public Dynamic_Array_Implementation(int capacity){
        this.capacity = capacity;
        stackRep = new int[capacity];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return  top < 0;
    }

    // Inserting an element at top
    public void push(int data) throws Exception{
        if(size() == capacity)
            expand();
        stackRep[++top] = data;
    }

    // Double the array
    public void expand(){
        int length = size();
        int[] newStack = new int[length << 1];
        System.arraycopy(stackRep , 0, newStack, 0, length);
        stackRep = newStack;
        this.capacity = this.capacity << 1;
    }

    public int top() throws  Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        return stackRep[top];
    }

    private void shrink(){
        int length = top+1;

        if(length <= MIN_CAPACITY || top << 2 >= length)
            return;
        length = length+ (top << 1);
        if(top < MIN_CAPACITY)
            length = MIN_CAPACITY;

        int[] newStack = new int[length];

        System.arraycopy(stackRep , 0, newStack, 0, length);
        stackRep = newStack;
        this.capacity = length;
    }

    public int pop() throws  Exception{
        if(isEmpty())
            throw  new Exception("Stack is empty");
        int data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        shrink();
        return data;
    }

    public String toString(){
        String s = "[";

        if(size() > 0)
            s+= stackRep[0];
        if (size() > 1)
            for (int i= 1; i<size(); i++)
                s+= "," +stackRep[i];
        return s + "]";
    }

}

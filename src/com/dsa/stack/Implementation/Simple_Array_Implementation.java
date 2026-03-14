package com.dsa.stack.Implementation;

/** -- Fixed Size Stack -- */
public class Simple_Array_Implementation {
    // length of stack
    private int capacity;
    //Default capacity
    public static final int CAPACITY = 10;
    // Array used to implement stack
    protected  int[] stackRep;
    // Index of top element
    protected  int top = -1;

    public Simple_Array_Implementation(){
        this(CAPACITY);
    }

    public  Simple_Array_Implementation(int capacity){
        this.capacity = capacity;
        stackRep = new int[this.capacity];
    }

    public int size(){
        return top+1;
    }

    public  boolean isEmpty(){
        return top < 0;
    }

    public void push(int data) throws Exception {
        if(size() == this.capacity) throw new Exception("Stack is full");
        stackRep[++top] = data ;
    }

    public  int pop() throws Exception{
        if(isEmpty()) throw new Exception("Stack is is Empty");
        int data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return  data;
    }

    public  String  toString(){
        String s = "{";
        if(size() > 0)
            s += stackRep[0];
        if(size() > 1)
            for (int i = 0; i < size(); i++) {
                s += "," + stackRep[i];
            }
        return  s += "}";
    }
}

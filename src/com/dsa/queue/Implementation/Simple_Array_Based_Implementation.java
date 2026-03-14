package com.dsa.queue.Implementation;

/** -- Circular Array -- */
public class Simple_Array_Based_Implementation {
    // Array used to implement queue
    private int[] simpQue;

    private int size, front, rear;

    // Default length
    private static final int CAPACITY = 16;

    public Simple_Array_Based_Implementation(){
        this(CAPACITY);
    }

    public Simple_Array_Based_Implementation(int capacity){
        simpQue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Insert element at rear of queue
    public void enQueue(int data) throws NullPointerException, IllegalStateException{
        if(size == CAPACITY) throw  new IllegalStateException("Queue is full : Overflow");
        else {
            size++;
            simpQue[rear] = data;
            // reset the rear after reaching beyond the array size
            rear = (rear+1) % CAPACITY;
        }
    }

    public int deQueue() throws IllegalStateException{
        if (size == 0) throw  new IllegalStateException("Queue is Empty :: Underflow");
        else {
            size --;
            int data = simpQue[front%CAPACITY];
            simpQue[front] = Integer.MIN_VALUE;
            // reset the front after reaching beyond the array size
            front = (front+1)%CAPACITY;
            return  data;

        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public  boolean isFull(){
        return size==CAPACITY;
    }

    public int size(){
        return size;
    }

}

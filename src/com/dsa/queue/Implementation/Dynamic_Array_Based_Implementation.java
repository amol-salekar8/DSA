package com.dsa.queue.Implementation;

public class Dynamic_Array_Based_Implementation {

    // Array used to implement queue
    private int[] dynamicArray;

    private int size, front, rear;

    // Default length
    public static int CAPACITY = 16;
    private static int MIN_CAPACITY = 1 << 15; // power of 2


    public Dynamic_Array_Based_Implementation(){
        this(CAPACITY);
    }

    public Dynamic_Array_Based_Implementation(int capacity){
        dynamicArray = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Insert element at rear of queue
    public void enQueue(int data) throws NullPointerException, IllegalStateException{
        if(size == CAPACITY) expand();
        size++;
        dynamicArray[rear] = data;
        // reset the rear after reaching beyond the array size
        rear = (rear+1) % CAPACITY;
    }

    public int deQueue() throws IllegalStateException{
        if (size == 0) throw  new IllegalStateException("Queue is Empty :: Underflow");
        else {
            size --;
            int data = dynamicArray[front%CAPACITY];
            dynamicArray[front] = Integer.MIN_VALUE;
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

    public void shrink(){
        int length = size;
        if(length <= MIN_CAPACITY || length << 2 >= length) return;
        if(length < MIN_CAPACITY) length = MIN_CAPACITY;
        int[] newQueue = new int[length];
        System.arraycopy(dynamicArray, 0, newQueue, 0, length+1);
        dynamicArray = newQueue;
    }

    public void expand(){
        int length = size;
        int[] newQueue = new int[length << 1];  // 2* length

        for(int i=front;i<= rear;i++){
            newQueue[i-front] = dynamicArray[i%CAPACITY];
        }
        dynamicArray = newQueue;
        front = 0;
        rear= size-1;
        CAPACITY = CAPACITY*2;
    }
}

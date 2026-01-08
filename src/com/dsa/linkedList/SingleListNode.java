package com.dsa.linkedList;

public class SingleListNode {
	private int data;
	public SingleListNode next;
	
	public SingleListNode() {
		this.data = 0;
		this.next = null;
	}
	
	public SingleListNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SingleListNode getNext() {
		return next;
	}
	public void setNext(SingleListNode next) {
		this.next = next;
	}
	
	

}

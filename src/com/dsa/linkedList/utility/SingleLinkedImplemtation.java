package com.dsa.linkedList.utility;

public class SingleLinkedImplemtation {
	
	private int length;
	
	SingleListNode head;
	
	public SingleLinkedImplemtation() {
		this.length = 0;
	}

	public synchronized SingleListNode getHead() {
		return this.head;
	}
	
	public synchronized void insertAtHead(SingleListNode newNode) {
		newNode.next = head;
		head = newNode;
		length ++;
	}
	
	
}

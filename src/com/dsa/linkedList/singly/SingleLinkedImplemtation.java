package com.dsa.linkedList.singly;

public class SingleLinkedImplemtation {
	
	private int length = 0;
	
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

	public synchronized void insertAtEnd(SingleListNode node){
		if(head == null)
			head = node;
		else {
			SingleListNode previousNode = null;
			SingleListNode currNode = head;
			while(currNode != null) {
				previousNode = currNode;
				currNode = currNode.next;
			}
			previousNode.next = node;
		}
		length++;
	}

	/** Insert at middle **/
	public void insert (int data, int position){
		if(position < 0)
			position =0;

		if (position  > length)
			position = length;

		if(head == null)
			head = new SingleListNode(data);
		else if(position == 0){
			SingleListNode temp = new SingleListNode(data);
			temp.next = head;
			head = temp;
		}else {
			SingleListNode temp = head;
			for(int i=0;i < position; i++){
				temp = temp.next;
			}
			SingleListNode newNode = new SingleListNode(data);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		length++;

	}

	public synchronized SingleListNode removeFromEnd(){
		if(head == null) return  null;
		SingleListNode tempHeadNode = head;
		SingleListNode previousNode = null;
		SingleListNode nextNode = head.next;

		if(nextNode == null){
			head = null;
			return tempHeadNode;
		}

		while( (nextNode = tempHeadNode.next) != null){
			previousNode = tempHeadNode;
			tempHeadNode = tempHeadNode.next;
		}
		previousNode.next = null;
		return tempHeadNode;
	}

	public synchronized SingleListNode removeFromBegin(){
		SingleListNode tempHead = head;
		if(tempHead != null){
			head = tempHead.next;
			tempHead.next = null;
		}
		return tempHead;
	}

	public int getLength(){
		return  length;
	}

	public synchronized void removeMatched(SingleListNode node){
		if(head == null) return;
		if(node.equals(head)){
			head = head.next;
			return;
		}

		SingleListNode tempHead = head;
		SingleListNode previousNode = null;

		while((previousNode = tempHead.next) != null){
			if(previousNode.equals(node)){
				tempHead.next = previousNode.next;
				return;
			}
			tempHead = previousNode;
		}
	}

	public void removeAtGivenPositon(int position){
		if(position < 0) position = 0;
		if (position >= length) position = length -1;
		if(head == null ) return;
		if(position == 0) head = head.next;
		else {
			SingleListNode tempHead = head;
			for(int i=1; i< position;i++){
				tempHead = tempHead.next;
			}
			tempHead.next = tempHead.next.next;
		}
		length --;
	}
}

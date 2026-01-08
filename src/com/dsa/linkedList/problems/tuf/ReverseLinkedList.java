package com.dsa.linkedList.problems.tuf;

import java.util.List;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
	    head.next = new ListNode(3);
	    head.next.next = new ListNode(2);
	    head.next.next.next = new ListNode(4);
	    PrintLinkedList.printLinkList(reverseLL(head));   
		    
	}
	
	public static ListNode reverseLL(ListNode head) {
		ListNode temp = head;
		ListNode prev = null;
		while(temp != null) {
			ListNode nextPointer = temp.next;
			temp.next = prev;
			prev = temp;
			temp = nextPointer;
		}
		return prev;
	}

}

package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

public class ReverseLinkedList2 {
	public static void main(String [] args){
		ListNode head = new ListNode(1);
	    head.next = new ListNode(3);
	    head.next.next = new ListNode(2);
	    head.next.next.next = new ListNode(4);
	    PrintLinkedList.printLinkList(middleReverseLinkList(head, 3,2));
	    
	}
	
	public static ListNode middleReverseLinkList(ListNode head, int right, int left) {
		ListNode temp = head;
		int count = 1;
		
		while(temp != null) {
			ListNode prev = temp;
			while( (count >= left && count <= right) && temp != null ) {
				ListNode nextPointer = temp.next;
				temp.next = prev;
				prev = temp;
				temp = nextPointer;
				count ++;
			}
			count++;
			temp = prev.next;
		}
		
		return temp;
	}
}

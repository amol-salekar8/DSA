package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;

public class SeprateOddAndEvenNumber {
	
	 
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5, 6};
	     ListNode head = new ListNode(arr[0]);
	     head.next = new ListNode(arr[1]);
	     head.next.next = new ListNode(arr[2]);
	     head.next.next.next = new ListNode(arr[3]);
	     head.next.next.next.next = new ListNode(arr[4]);
	     head.next.next.next.next.next = new ListNode(arr[5]);
	     
	     ListNode ans = seprateOddEven(head);
	     
	     while( ans != null) {
	    	 System.out.println(ans.val);
	    	 ans = ans.next;
	     }
	     
	}
	
	public static ListNode seprateOddEven(ListNode node) {
		ListNode addAll = new ListNode();
		
		ListNode oddNum = new ListNode();
		ListNode tempOdd = oddNum;
		
		ListNode evenNum = new ListNode();
		ListNode tempEven = evenNum;
		
		ListNode tempHead = node;
		int count =0;
		boolean isAsc = true;
		
		while(tempHead != null) {
			tempOdd.next = tempHead;
			tempOdd = tempOdd;
			tempHead = tempHead.next.next;
		}
		tempHead = node;
		while(tempHead != null) {
			tempEven.next = tempHead;
			tempEven = tempEven.next;
			tempHead = tempHead.next.next.next;
		}
		
		addAll.next = oddNum.next;
		addAll.next = evenNum.next;
		
		return addAll.next;
	}

}

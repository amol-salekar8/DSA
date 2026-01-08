package com.dsa.linkedList.problems.tuf.hard;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

public class SortList {

	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5, 6};
	     ListNode head = new ListNode(arr[0]);
	     head.next = new ListNode(arr[1]);
	     head.next.next = new ListNode(arr[2]);
	     head.next.next.next = new ListNode(arr[3]);
	     head.next.next.next.next = new ListNode(arr[4]);
	     head.next.next.next.next.next = new ListNode(arr[5]);
	     PrintLinkedList.printLinkList(sortLL(head));
	}
	
	public static ListNode sortLL(ListNode head) {
		if(head == null || head.next == null )
			return head;
		
		ListNode middle = findMiddle(head);
		ListNode right = middle.next;
		middle.next = null;
		ListNode left = head;
		
		left = sortLL(left);
		right = sortLL(right);
		
		return mergeTwoLL(left,right);
		
	}
	
	/** Tortoise and hare algorithm*/
	public static ListNode findMiddle(ListNode head) {
		if(head == null || head.next == null )
			return head;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	/** merge algorithm */
	 public static ListNode mergeTwoLL(ListNode left, ListNode right) {
		 ListNode dummyHead = new ListNode(-1);
		 ListNode tail = dummyHead;
		 
		 while(left != null && right != null) {
			 if(left.val <= right.val) {
				 tail.next = left;
				 left = left.next;
			 }else {
				 tail.next = right;
				 right = right.next;
			 }
			 tail = tail.next;
			 
		 }
		 
		 if(left != null) {
			 tail.next = left;
		 }else {
			 tail.next = right;
		 }
		 
		 return dummyHead.next;
	 }
}

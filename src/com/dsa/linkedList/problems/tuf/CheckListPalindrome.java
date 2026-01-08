package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;

/***
 * Example 1
	Input: head -> 3 -> 7 -> 5 -> 7 -> 3
	Output: true
	Explanation: 37573 is a palindrome.
	
	Example 2
	Input: head -> 1 -> 1 -> 2 -> 1
	Output: false
	Explanation: 1121 is not a palindrome.
 * 
 */

public class CheckListPalindrome {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
	    head.next = new ListNode(9);
	    head.next.next = new ListNode(1);
	    head.next.next.next = new ListNode(9);
	    head.next.next.next.next = new ListNode(9);
	    
	    System.out.println(checkPlaindrome(head, reverseList(head)));
	    
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode tail = head;
		ListNode prevPointer =null;
		ListNode nextPointer = null;
		while(tail != null) {
			nextPointer = tail.next;
			tail.next = prevPointer;
			prevPointer = tail;
			tail = nextPointer;
		}
		return prevPointer;
	}
	
	public static boolean checkPlaindrome(ListNode node1, ListNode node2) {
		boolean isPalindrome = false;
		
		while(node1 != null && node2 != null) {
			if(node1.val != node2.val) {
				isPalindrome = false;
				break;
			}else {
				isPalindrome = true;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return isPalindrome;
	}

}

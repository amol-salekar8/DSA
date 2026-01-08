package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

/**
 * Example 1
	Input: head -> 1 -> 2 -> 3
	Output: head -> 1 -> 2 -> 4
	Explanation: The number represented by the linked list = 123.
	123 + 1 = 124.
 * 
 */

public class AddOneNumber {
	public static void main(String[] args) {
		ListNode head = new ListNode(9);
	    head.next = new ListNode(9);
	    head.next.next = new ListNode(9);
	    head.next.next.next = new ListNode(9);
	    head.next.next.next.next = new ListNode(9);
	    ListNode reverse = reverseLL(head);
	    ListNode addElement = addOneListOptimize(reverse);
	    PrintLinkedList.printLinkList(reverseLL(addElement));   
	}
	
	public static ListNode reverseLL(ListNode head) {
		ListNode temp= head;
		ListNode prev = null;
		while( temp != null) {
			ListNode nextPointer = temp.next;
			temp.next = prev;
			prev = temp;
			temp = nextPointer;
		}
		return prev;
	}
	
	public static ListNode addOneList(ListNode head) {
		ListNode temp = head;
		ListNode addNumberList = new ListNode();
		ListNode tempAddNumberList = addNumberList;
		int carry = 0;
		int addNumber = 1;
		while( temp != null || carry != 0) {
			int sum = 0;
			if(temp != null) {
				sum = temp.val + addNumber;
				addNumber /= 10;
			}
			sum += carry;
			carry = sum /10;
			ListNode newNode = new ListNode(sum %10);
			tempAddNumberList.next = newNode;
			tempAddNumberList = tempAddNumberList.next;
			temp = temp.next;
		}
		return addNumberList.next;
	}
	
	
	public static ListNode addOneListOptimize(ListNode head) {
		ListNode temp = head;
		int carry = 1;
		int addNumber = 1;
		while( temp != null ) {
			int sum = 0;
			sum = temp.val + carry;
			carry = sum / 10;
			temp.val = sum %10;
			
			if(carry %10 == 0)
				break;
			
			if(carry != 0 && temp.next == null) {
				temp.next = new ListNode(carry);
				break;
			}
			
			temp = temp.next;
		}
		return head;
	}
}

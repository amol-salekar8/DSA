package com.dsa.linkedList.problems.tuf.hard;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

/**
 * Edge cases
 * Example 1
	Input: head -> 1 -> 2 -> 3 -> 4 -> 5, k = 2
	Output: head -> 4 -> 5 -> 1 -> 2 -> 3
	Explanation:
	List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
	List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.
	
	Example 2
	Input: head -> 1 -> 2 -> 3 -> 4 -> 5, k = 4
	Output: head -> 2 -> 3 -> 4 -> 5 -> 1
	Explanation:
	List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
	List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.
	List after 3 shift to right: head -> 3 -> 4 -> 5 -> 1 -> 2.
	List after 4 shift to right: head -> 2 -> 3 -> 4 -> 5 -> 1.
 * 
 */

public class Rotate_LL_K_Times_Right {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5, 6};
	     ListNode head = new ListNode(arr[0]);
	     head.next = new ListNode(arr[1]);
	     head.next.next = new ListNode(arr[2]);
	     head.next.next.next = new ListNode(arr[3]);
	     head.next.next.next.next = new ListNode(arr[4]);
	     head.next.next.next.next.next = new ListNode(arr[5]);
	     PrintLinkedList.printLinkList(reverseLLToRightByKtime_optimal(head, 9));
	}
	/** -- Brute Force  -- */
	/**
	 * Time complexity O(K*N)
	 * 
	 * */
	public static ListNode reverseLLToRightByKtime(ListNode head, int k) {
		// for Kth time
		for(int i=0;i<k;i++) {
			ListNode temp = head;
			// find second last node
			while(temp.next.next != null ) temp = temp.next;
			// get the last node
			ListNode end = temp.next;
			// second last pointer next becomes null
			temp.next = null;
			// end next pointer is head
			end.next = head;
			// at end becomes head
			head = end;
		}
		return head;
	}

	/** -- Optimal approach -- */
	public static ListNode reverseLLToRightByKtime_optimal(ListNode head, int k) {
		if(head == null || head.next == null)
			return head;
		
		ListNode tail = head;
		int length = 1;
		while(tail.next != null ) {
			tail = tail.next;
			length ++;
		}
		// convert single to circular
		tail.next = head;
		
		// if k is greater than length 
		k = k%length;
		
		int end = length - k;
		
		// go to kth position
		while(end-- > 0) {
			tail = tail.next;
		}
		
		// assign k + 1 to head
		head = tail.next;
		 tail.next = null;
	
		return head;
	}
	
}

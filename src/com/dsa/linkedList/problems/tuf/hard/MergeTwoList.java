package com.dsa.linkedList.problems.tuf.hard;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

/***
 * 
 * Example 1
	Input: list1 = head -> 2 -> 4 -> 7 -> 9, list2 = head -> 1 -> 2 -> 5 -> 6
	Output: head -> 1 -> 2 -> 2 -> 4 -> 5 -> 6 ->7 -> 9
	Explanation: head -> 1 -> 2 -> 2 -> 4 -> 5 -> 6 ->7 -> 9, the underlined nodes come from list2, the others come from list1.
	
	Example 2
	Input: list1 = head -> 1 -> 2 -> 3 -> 4, list2 = head -> 5 -> 6 -> 10
	Output: head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 10
	Explanation: head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 10, the underlined nodes come from list2, the others come from list1.
 * 
 * 
 */
public class MergeTwoList {
	public static void main(String[] args) {
		int[] arr = {1,2, 3, 4, 5, 6};
	     ListNode head = new ListNode(arr[0]);
	     head.next = new ListNode(arr[1]);
	     head.next.next = new ListNode(arr[2]);
	     head.next.next.next = new ListNode(arr[3]);
	     head.next.next.next.next = new ListNode(arr[4]);
	     head.next.next.next.next.next = new ListNode(arr[5]);
	     
	     int[] arr2 = {1, 3, 4, 5, 6};
	     ListNode head2 = new ListNode(arr[0]);
	     head2.next = new ListNode(arr2[1]);
	     head2.next.next = new ListNode(arr2[2]);
	     head2.next.next.next = new ListNode(arr2[3]);
	     head2.next.next.next.next = new ListNode(arr2[4]);
	     
	     PrintLinkedList.printLinkList(sortTwoLL(head, head2));
	}
	
	public static ListNode sortTwoLL(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode tail = dummyHead;
		
		while(list1 != null && list2 != null) {
			
			if(list1.val <= list2.val) {
				tail.next = list1;
				list1 = list1.next;
			}else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		
		if(list1 != null) {
			tail.next = list1;
		}else
			tail.next = list2;
		
		return dummyHead.next;
	}

}

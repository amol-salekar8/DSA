package com.dsa.linkedList.problems.tuf.hard;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

public class Reverse_LL_By_K_Groups {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5, 6};
	     ListNode head = new ListNode(arr[0]);
	     head.next = new ListNode(arr[1]);
	     head.next.next = new ListNode(arr[2]);
	     head.next.next.next = new ListNode(arr[3]);
	     head.next.next.next.next = new ListNode(arr[4]);
	     head.next.next.next.next.next = new ListNode(arr[5]);
	     PrintLinkedList.printLinkList(reverseLLKtime(head, 2));
	}
	
	public static ListNode reverseLLKtime(ListNode head,int k) {
		ListNode temp = head;
		ListNode prevHead = null;
		ListNode firstPointer = null;
		
		int count =0;
		while(temp != null && count < k)
		{
			ListNode nextPointer = temp.next;
			temp.next = prevHead;
			prevHead = temp;
			temp = nextPointer;
			if(count == 0)
				firstPointer = prevHead;
			count++;
		}
		firstPointer.next = temp;
//		int count1 =0;
//		ListNode prevTail = prevHead;
//		while (prevTail != null) {
//			count1 ++;
//			prevTail = prevTail.next;
//			if (count1 == (k-1)) {
//				prevTail.next = temp;
//				break;
//			}
//		}
		return prevHead;
	}

}

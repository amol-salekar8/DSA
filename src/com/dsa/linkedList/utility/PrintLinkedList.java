package com.dsa.linkedList.utility;

public class PrintLinkedList {
	public static void printLinkList(ListNode temp) {
		while (temp != null) {
	        System.out.print(temp.val + " ");
	        temp = temp.next;
	    }
	}
}

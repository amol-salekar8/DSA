package com.dsa.linkedList.problems.tuf.hard;

import com.dsa.linkedList.utility.FlattenListNode;

public class FlatteningOfLL {
	public static void main(String[] args) {
		FlattenListNode head = new FlattenListNode(5);
	        head.child = new FlattenListNode(14);

	        head.next = new FlattenListNode(10);
	        head.next.child = new FlattenListNode(4);

	        head.next.next = new FlattenListNode(12);
	        head.next.next.child = new FlattenListNode(20);
	        head.next.next.child.child = new FlattenListNode(13);

	        head.next.next.next = new FlattenListNode(7);
	        head.next.next.next.child = new FlattenListNode(17);

	        // Print the original linked list structure
	        System.out.println("Original linked list:");
	}
	
	public static void printLinkedList(FlattenListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }
}

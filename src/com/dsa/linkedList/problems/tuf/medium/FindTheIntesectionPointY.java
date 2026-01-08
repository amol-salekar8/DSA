package com.dsa.linkedList.problems.tuf.medium;

import com.dsa.linkedList.utility.ListNode;

/**
 * Case 1: 
 * Input:  intersectVal = 4, skipA = 3, skipB = 2, 
 *  listA: head -> 1 -> 2 -> 3 -> 4 -> 5, 
 * listB: head -> 7 -> 8 -> 4 -> 5
 * Output(value at returned node is displayed): 4
 * Explanation: The two lists have nodes with values 4 and 5 as their tails.
 * 
 * Case 2:
 * Input:  intersectVal = -1, skipA = -1, skipB = -1,  
 * listA: head -> 1 -> 2 -> 3,
 * listB: head -> 8 -> 9
 * Output(value at returned node is displayed): null
 * Explanation: The two lists do not intersect.
 */

public class FindTheIntesectionPointY {
	
	public static void main(String[] args) {
		// Creation of the first list
	    ListNode head1 = new ListNode();
	    insertNode(head1, 1);
	    insertNode(head1, 3);
	    insertNode(head1, 1);
	    insertNode(head1, 2);
	    insertNode(head1, 4);

	    // Create an intersection
	    ListNode intersection = head1.next.next.next;

	    // Creation of the second list
	    ListNode head2 = new ListNode();
	    insertNode(head2, 3);
	    head2.next = intersection;
	    
	    
	}
	
	// Utility function to insert a node at the end of the linked list
	static void insertNode(ListNode head, int val) {
	    // Create a new node with the given value
	    ListNode newNode = new ListNode(val);
	    // If the list is empty, set the new node as the head
	    if (head == null) {
	        head = newNode;
	        return;
	    }
	    // Otherwise, traverse to the end of the list
	    ListNode temp = head;
	    while (temp.next != null) {
	        temp = temp.next;
	    }
	    // Insert the new node at the end of the list
	    temp.next = newNode;
	}

}

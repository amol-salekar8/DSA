package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;

/**
 * 	Input: head -> 1 -> 2 -> 3 -> 4 -> 5
	Output: head -> 1 -> 2 -> 4 -> 5
	Explanation: n = 5.
	[n / 2] + 1 = 3, therefore middle node has index 3 and so the node with value 3 was deleted.
 * 
 */
public class DeleteMiddleNode {

	public static void main(String[] args) {
		
	}
	
	 public ListNode deleteMiddleBruteForce(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        ListNode tempNode = head;
	        // count should start from zero
	        int count = 0;
	        while(tempNode != null){
	            tempNode = tempNode.next;
	            count++;
	        }
	       ListNode temp = head;
	        int i = 1;
	        // traverse through previous of middle
	        while( i < (count/2)){
	             temp = temp.next;
	            i++;
	        }
	        if(temp.next != null )
	         temp.next = temp.next.next;

	        return head;
	    }
	
	 public ListNode deleteMiddleOptimal(ListNode head) {
	        if(head == null || head.next == null){
	            return null;
	        }
	        ListNode fast = head.next.next;
	        ListNode slow = head;

	        while(fast != null &&  fast.next != null){
	            fast = fast.next.next;
	            slow = slow.next;
	        }

	        ListNode deleteMiddle = slow.next;
	        slow.next = slow.next.next;
	        deleteMiddle = null;

	        return head;
	    }
	
}

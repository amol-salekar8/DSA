package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

public class SortLinkedList012 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(1);
        PrintLinkedList.printLinkList(sortLinkedList(head));
        
	}
	
	public static ListNode sortLinkedList(ListNode head) {
		ListNode temp = head;
		
		ListNode zeroHead = new ListNode();
		ListNode oneHead = new ListNode();
		ListNode twoHead = new ListNode();
		ListNode zero = zeroHead;
		ListNode one = oneHead;
		ListNode two = twoHead;
		
		while(temp != null) {
			if(temp.val == 0) {
				zero.next = temp;
				zero = temp;
			}else if(temp.val == 1) {
				one.next = temp;
				one = temp;
			}
			else{
				two.next = temp;
				two = temp;
			}
			
			temp = temp.next;
		}
		two.next = null;
		one.next = twoHead.next;
		zero.next = oneHead.next;
		return zeroHead.next;
	}

}

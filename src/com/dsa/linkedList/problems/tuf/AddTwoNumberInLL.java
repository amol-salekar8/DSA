package com.dsa.linkedList.problems.tuf;

import com.dsa.linkedList.utility.ListNode;
import com.dsa.linkedList.utility.PrintLinkedList;

public class AddTwoNumberInLL {
	
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        
        PrintLinkedList.printLinkList(adTwoNumber(l1 , l2));
	}
    
    public static ListNode adTwoNumber(ListNode listNode1, ListNode listNode2) {
    	ListNode addNodeHead = new ListNode();
    	ListNode addNodeTail = addNodeHead;
    	int carry = 0;
    	while( ( listNode1 != null || listNode2 != null ) || carry != 0) {
    		int sum =0;
    		if(listNode1 != null ) {
    			sum += listNode1.val;
    			listNode1 = listNode1.next;
    		}
    		
    		if(listNode2 != null ) {
    			sum += listNode2.val;
    			listNode2 = listNode2.next;
    		}
    		
    		sum += carry;
    		carry = sum /10;
    		
    		ListNode newNode = new ListNode(sum % 10);
    		addNodeTail.next = newNode;
    		addNodeTail = addNodeTail.next;
    	}
    	
    	return addNodeHead.next;
    }

}

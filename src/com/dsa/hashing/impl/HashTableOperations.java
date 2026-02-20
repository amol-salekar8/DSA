package com.dsa.hashing.impl;


public class HashTableOperations {

	public final static int LOAD_FACTOR = 20;
	
	public static int hashFunction(int data, int size) {
		return data % size;
	}

	public static HashTable crateHashTable(int size) {
		HashTable table = new HashTable();
		table.settSize(size / LOAD_FACTOR);
		for (int i = 0; i < table.gettSize(); i++) {
			table.getTable()[i].setStartNode(null);
		}
		return table;
	}

	public static ListNode hashSearch(HashTable table, int data) {
		ListNode temp;

		temp = table.getTable()[hashFunction(data, table.gettSize())].getStartNode();

		while (temp != null) {
			if (temp.data == data)
				return temp;
			temp = temp.next;
		}
		return temp;
	}
	
	/*public static void hashInsert(HashTable table, int data) {
		int index;
		ListNode temp, newNode;
		
		index = hashFunction(data, table.gettSize());
		
		if(hashSearch(table,data) )
			return;
			
		
		temp = table.getTable()[index].getStartNode().next;
		
		newNode = new ListNode();
		
		newNode.setKey(index);
		newNode.data = data;
		newNode.next = table.getTable()[index].
		
		
		
	}*/

}

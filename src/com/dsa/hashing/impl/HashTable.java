package com.dsa.hashing.impl;

public class HashTable {
	private int tSize;
	private int count;
	private HashTableNode[] table;
	
	public int gettSize() {
		return tSize;
	}
	public void settSize(int tSize) {
		this.tSize = tSize;
		table = new HashTableNode[tSize];
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public HashTableNode[] getTable() {
		return table;
	}
	public void setTable(HashTableNode[] table) {
		this.table = table;
	}
	
	

}

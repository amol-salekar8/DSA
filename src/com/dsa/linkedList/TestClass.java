package com.dsa.linkedList;

import java.util.LinkedList;

public class TestClass {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(12);
		ll.add(13);
		ll.add(14);
		ll.add(15);
		
		LinkedList temp = ll;
		int count =0;
		while(count < ll.size()) {
			temp.get(count);
		}
	}
}

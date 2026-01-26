package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * 
 * 
 * 
 */

public class ZigZagTravelsal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        zigZagTraversalByTUF(root).stream().flatMap(List::stream).forEach(System.out::println);
	}
	
	/**
	 * this approach I get it from DSA book
	 * 1) Finding level order
	 * 2) check for odd level
	 * 3) if we found then with the help of Stack we reverse them
	 * 
	 * */
	public static List<List<Integer>> zigZagTraversal(TreeNode node){
		List<List<Integer>> responseList = new ArrayList();
		List<Integer> levelList = new ArrayList();
		Queue<TreeNode> queue = new LinkedList<>();
		// this flag check the odd level
		boolean flag = false;
		queue.offer(node);
		queue.offer(null);
		
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr != null) {
				levelList.add(curr.data);
				if(curr.left != null) queue.add(curr.left);
				if(curr.right != null) queue.add(curr.right);
			}else {
				if(!queue.isEmpty()) queue.offer(null);
				List<Integer> currList = new ArrayList(levelList);
				if(flag) {
					currList.clear();
					Stack<Integer> stack = new Stack();
					stack.addAll(levelList);
					while(!stack.isEmpty()) {
						currList.add(stack.pop());
					}
				}
				responseList.add(currList);
				levelList.clear();
				flag = !flag;
			}
		}
		return responseList;
	}
	
	
	/***
	 * We uses Collection.nCopies() to create immutable list
	 * with the help boolean we insert the value
	 *
	 *
	 */
	public static  List<List<Integer>> zigZagTraversalByTUF(TreeNode node){
		List<List<Integer>> responseList = new ArrayList();
		boolean leftToRight = true;
		Queue<TreeNode> queue = new LinkedList();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentList = new ArrayList(Collections.nCopies(size, 0));
			/**  --  Perform the level order traversal -- */
			for(int i=0; i < size; i++) {
				TreeNode curr = queue.poll();
				/** -- setting up the index 0 to n or vice versa -- */
				int index = leftToRight ? i : (size - 1- i);
				currentList.set(index, curr.data);
				if(curr.left != null ) queue.add(curr.left);
				if(curr.right != null )queue.add(curr.right);
			}
			responseList.add(currentList);
			leftToRight = !leftToRight;
		}
		return responseList;
	}
	
}

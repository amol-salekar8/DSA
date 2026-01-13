package com.dsa.tree.BinaryTree.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.BinaryTree.utility.TreeNode;


/**
 * 				1			--> root   -- level 0
 * 			/		\
 * 			2		 3  -- siblings		-- level 1
 * 		/		\
 * 	   4		 5  --> leaf node		-- level 2
 * 
 * LRD
 * 	4 5 2 3 1
 * 
 */
public class PostOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        List<Integer> responseList = new ArrayList<>();
        iterativeOrderByTUF(root, responseList);
        
        responseList.forEach(System.out::println);
        
	}
	
	/**
	 *  Because we need to follow LRD concept
	 *  L = left node 
	 *  R =  Right node
	 *  D = current node
	 *  recursion follow the execution of order
	 * */
	public static void recursiveInOrder(TreeNode root, List<Integer> dataList) {
		if(root == null ) return;
		
		recursiveInOrder(root.left,dataList);
		recursiveInOrder(root.right,dataList);
		dataList.add(root.data);
	}
	
	/**
	 * To store order of execution we used stack because of Last in first out behaviour
	 * 1) Create stack to add root pointer
	 * 2) We need to assign two pointer current and previous 
	 * 3) When previous is current parent then we need to traverse
	 * 4) If both left and right does not present then perform action on node
	 * 5)  
	 * 
	 * add left ->  add right -> perform action
	 * 
	 * */
	public static void iterativeOrderByBook(TreeNode root, List<Integer> dataList) {
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		TreeNode prev = null;
		
		while(!stack.isEmpty()) {
			TreeNode currentNode = stack.peek();
			if(prev == null || prev.left == currentNode || prev.right == currentNode ) {
				if(currentNode.left != null)
					stack.push(currentNode.left);
				else if(currentNode.right != null)
					stack.push(currentNode.right);
			}else if(currentNode.left == prev) {
				if(currentNode.right != null)
					stack.push(currentNode.right);
			} else {
					dataList.add(currentNode.data);
					stack.pop();
			}
			prev = currentNode;
		}
	}
	
	/**
	 * The format we used to traverse is DRL and its reverse becomes LRD
	 * 
	 * 
	 * @param root
	 * @param dataList
	 */
	public static void iterativeOrderByTUF(TreeNode root, List<Integer> dataList) {
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			dataList.add(node.data);
			if(node.left != null ) stack.push(node.left);
			if(node.right != null )stack.push(node.right);
		}
		Collections.reverse(dataList);
	}
	
	
}

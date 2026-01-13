package com.dsa.tree.BinaryTree.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * 				1			--> root
 * 			/		\
 * 			2		 3
 * 		/		\
 * 	   4		 5
 * 
 * LDR
 * 4 2 5 1 3
 * 
 */
public class InOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        List<Integer> responseList = new ArrayList<>();
        iterativeOrder(root, responseList);
        
        responseList.forEach(System.out::println);
        
	}
	
	/**
	 *  Because we need to follow LDR concept
	 *  L = left node 
	 *  D = current node
	 *  R =  Right node
	 *  recursion follow the execution of order
	 * */
	public static void recursiveInOrder(TreeNode root, List<Integer> dataList) {
		if(root == null ) return;
		
		recursiveInOrder(root.left,dataList);
		dataList.add(root.data);
		recursiveInOrder(root.right,dataList);
	}
	
	/**
	 * To store order of execution we used stack because of Last in first out behaviour
	 * 1) Define stack and define one pointer to remember node
	 * 2) add the root node then move to left until its points to null
	 * 3) after pointer to null perform action on previously inserted node
	 * 4) then move to right side
	 * 5)  
	 * 
	 * add left ->  perform -> add right
	 * */
	public static void iterativeOrder(TreeNode root, List<Integer> dataList) {
		Stack<TreeNode> stack = new Stack();
		TreeNode currentNode = root;
		/** at start our stack is empty */
		while(true) {
			/** got to left side */
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}else {
				if(stack.isEmpty()) break; // Break when stack is empty
				else {
					/** perform action on previously added node then move to right side */
					currentNode = stack.pop();
					dataList.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}
			
		}
		
	}

}

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
 * DLR
 * 	1 2 4 5 3
 * <a href='https://takeuforward.org/plus/dsa/problems/level-order-traversal?category=binary-trees&subcategory=theory-and-traversals&tab=description'> link </a>
 */

public class PreOrderTraversal {
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
	 *  Because we need to follow DLR concept
	 *  D = current node
	 *  L = left node 
	 *  R =  Right node
	 *  recursion follow the execution of order
	 * */
	public static void recursiveInOrder(TreeNode root, List<Integer> dataList) {
		if(root == null ) return;
		
		dataList.add(root.data);
		recursiveInOrder(root.left,dataList);
		recursiveInOrder(root.right,dataList);
	}
	
	/**
	 * To store order of execution we used stack because of Last in first out behaviour
	 * 1) store the root node in stack
	 * 2) run the while loop up to stack is empty
	 * 3) pop the last TreeNode to process them
	 * 4) check for right to add into stack
	 * 5) check for left to add into stack  
	 * 6) Do until stack is empty
	 *
	 *perform -> add right -> add left
	 *
	 * */
	public static void iterativeOrder(TreeNode root, List<Integer> dataList) {
		Stack<TreeNode> stack = new Stack();
		/* store root because we need to process first*/
		stack.push(root);
		
		while(!stack.isEmpty()) {
			/* Get previously added node to process */
			TreeNode currNode = stack.pop();
			dataList.add(currNode.data);
			/* why we add first right node is */
			if(currNode.right != null ) stack.push(currNode.right);
			if(currNode.left != null ) stack.push(currNode.left);
		}
	}
}	
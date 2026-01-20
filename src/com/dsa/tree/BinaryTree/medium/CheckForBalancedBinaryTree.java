package com.dsa.tree.BinaryTree.medium;

import javax.swing.text.Highlighter.Highlight;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/*
 * Balanced Binary tree is the difference of left and right tree height is <= 1
 * 
 */
public class CheckForBalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		/* with TC O(n^2) */
		System.out.println(balancedBinary_optimalApproach(root));
	}
	
	/**
	 * TC = O(N^2)
	 *  calling two function with recursive approach
	 *  1) go to each node (checkBinaryBalancedtree_recursive) 
	 *  2) find the height of each node (height_recursive)
	 * 
	 */
	public static boolean checkBinaryBalancedtree_recursive(TreeNode root) {
		if(root == null ) return true;
		
		// calculate each node height 
		int leftHeight = height_recursive(root.left);
		int rightHeight = height_recursive(root.right);
		
		// check for difference of left and right is <= 1
		if(Math.abs(leftHeight - rightHeight) > 1) return false;
		
		// go and check for each node
		return checkBinaryBalancedtree_recursive(root.left) 
				&& checkBinaryBalancedtree_recursive(root.right);
	}
	/* calculating height of the tree */
	public static int height_recursive(TreeNode node) {
		if(node == null) return 0;
		
		int leftHeight = height_recursive(node.left);
		int rightHeight = height_recursive(node.right);
		
		return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;
	}
	
	/***
	 * Optimal approach with O(n) TC
	 * 
	 * 1) in one function we return all the logic 
	 * calculate height of each node then check for balanced binary tree
	 * 
	 */
	public static boolean balancedBinary_optimalApproach(TreeNode root) {
		return depthOfBt(root) != -1;
	}
	
	/* calculating height of the tree + check for balanced binary tree*/ 
	public static int depthOfBt(TreeNode node) {
		if(node == null ) return 0;
		
		/* --  check for left side tree height -- */
		int leftHeight = depthOfBt(node.left);
		if(leftHeight == -1) return -1;
		
		
		/* --  check for right side tree height -- */
		int rightHeight = depthOfBt(node.right);
		if(rightHeight == -1) return -1;
		
		/* --  check for balanced binary tree -- */
		if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		
		/* --  calculate height -- */
		return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight; 
	}
}

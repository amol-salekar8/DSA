package com.dsa.tree.BinaryTree.medium;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 *  Symmetrical BT 
 *  the tree is forming mirror at itself from center
 *  
 *  below the root node mirror tree is formed
 *   to compare this we follow preOrder traversal 
 *   left tree (DLR)
 *   Right tree (DRL) 
 *   changes in left and right node of the below subtree not in root node
 */
public class SymmetricalBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.right.right.left = new TreeNode(3);
		/* with TC O(n^2) */
		System.out.println(checkForSymmetrical(root));
	}
	
	/** Leaving the root node and for comparison we send below two sub tree */
	public static boolean checkForSymmetrical(TreeNode node) {
		return node == null || checkForSymmetricalHelper(node.left, node.right);
	}
	
	/** For left sub tree we follow DLR and for right DRL */
	public static boolean checkForSymmetricalHelper(TreeNode leftTree,TreeNode rightTree) {
		if(leftTree == null && rightTree == null ) return true;
		if(leftTree == null || rightTree == null ) return false;
		if(leftTree.data != rightTree.data ) return false;
		return checkForSymmetricalHelper(leftTree.left, rightTree.right) 
				&& checkForSymmetricalHelper(leftTree.right, rightTree.left);
		
	}
	
}

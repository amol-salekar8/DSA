package com.dsa.tree.BinaryTree.hard.construct;

import java.util.HashMap;

import com.dsa.tree.BinaryTree.utility.TreeNode;


/**
 * ---  Construct Tree Using POST  And IN Order Traversal
 * 
 * Concept of building tree is same like PRE and IN Order
 * Difference is PreOrder root element present at start index and in Post Order Root element present at last index of an array
 * 
 * */
public class UsingPostOrderAndInorder {
	public static void main(String[] args) {
		 int[] inOrder = {9, 3, 15, 20, 7};
	     int[] postOrder = {9, 15, 7, 20,3};
	     printInOrderNode(constructBinaryTree(inOrder,postOrder));
	}
	
	public static TreeNode constructBinaryTree(int [] inorder, int [] postOrder) {
		TreeNode root = null;
		HashMap<Integer,Integer> inorderPostionMap = new HashMap<>();		
		
		for(int i=0; i<inorder.length;i++) {
			inorderPostionMap.put(inorder[i], i);
		}
		
		return buildTree(inorder, 0, inorder.length-1, postOrder, 0, postOrder.length-1, inorderPostionMap);
	}
	
	public static TreeNode buildTree(int [] inorder, int inStart, int inEnd, 
			int [] postOrder, int postStart, int postEnd, 
			HashMap<Integer,Integer> inorderPostionMap) {
		
		if(inStart >  inEnd || postStart > postEnd) return null;
		
		TreeNode node = new TreeNode(postOrder[postEnd]);
		/** -- find position in InOrder array -- */
		int rootIndex = inorderPostionMap.get(postOrder[postEnd]);
		
		// Number of nodes in the left subtree
        int numsLeft = rootIndex - inStart;

        // Recursively build the
        /** -- from that  position left side part -- */
        /** -- Processing POST order to find root -- */
        node.left = buildTree(inorder, inStart, rootIndex - 1, postOrder,
        		postStart, postStart + numsLeft - 1,inorderPostionMap);
        /** -- after completing left side part we have right side part -- */
        node.right = buildTree(inorder, rootIndex + 1, inEnd, postOrder,
        		postStart + numsLeft, postEnd - 1, inorderPostionMap);
		
		return node;
	}
	
	public static void printInOrderNode(TreeNode root) {
		if( root == null)
			return;
		
		printInOrderNode(root.left);
		System.out.print(root.data+" ");
		printInOrderNode(root.right);
	}
}

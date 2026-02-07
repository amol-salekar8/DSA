package com.dsa.tree.BinaryTree.hard.construct;

import java.util.HashMap;

import com.dsa.tree.BinaryTree.algorithm.InOrderTraversal;
import com.dsa.tree.BinaryTree.utility.TreeNode;

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
		int rootIndex = inorderPostionMap.get(postOrder[postEnd]);
		
		// Number of nodes in the left subtree
        int numsLeft = rootIndex - inStart;

        // Recursively build the
        // left and right subtrees
        node.left = buildTree(inorder, inStart, rootIndex - 1, postOrder,
        		postStart, postStart + numsLeft - 1,inorderPostionMap);

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

package com.dsa.tree.BinaryTree.hard.construct;

import java.util.HashMap;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * -- Constructing a tree with the help of In-Order Array and Pre-Order array
 * Logic is 
 * PreOrder start is our root node as per traversing order 
 * Find that element in InOder array => to find that we store InOrder array's element to Map with index position
 * from that element index  position in InOrder array  ( Left Data Right ) before part is belong to left side and after side part belong to right side
 * and we to process until start become greater than end
 * 
 * 
 * 
 */


public class UsingPreOrderAndInorder {
	public static void main(String[] args) {
		 int[] inorder = {9, 3, 15, 20, 7};
	     int[] preorder = {3, 9, 20, 15, 7};
	     printInOrderNode(constructBinaryTree(inorder,preorder));
	}
	
	public static TreeNode constructBinaryTree(int[] inorder, int[] preorder) {
		TreeNode root = null;
		HashMap<Integer,Integer> inorderPostionMap = new HashMap<>();		
		
		for(int i=0; i<inorder.length;i++) {
			inorderPostionMap.put(inorder[i], i);
		}
		
		return buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, inorderPostionMap);
	}
	
	public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder,
			int preStart, int preEnd, HashMap<Integer,Integer> inorderPostionMap) {
		/** -- Base Condition -- */
		if(preStart > preEnd || inStart > inEnd) 
			return null;
		/** -- create node -- */
		TreeNode root = new TreeNode(preorder[preStart]);
		/** -- find position in InOrder array -- */
		int rootIndexFromInorder = inorderPostionMap.get(preorder[preStart]);
		/** -- from that  position left side part -- */
		root.left = buildTree(inorder, inStart, rootIndexFromInorder-1,
				preorder, preStart+1, rootIndexFromInorder, inorderPostionMap);
		/** -- from that  position right side part -- */
		root.right = buildTree(inorder, rootIndexFromInorder+1, inEnd, 
				preorder, rootIndexFromInorder +1, preEnd, inorderPostionMap);
		
		return root;
	}
	
	
	 // Recursive helper function to build the tree
    private static TreeNode buildTreeByTuF(int[] inorder, int inStart, int inEnd, int[] preorder,
			int preStart, int preEnd, HashMap<Integer,Integer> inorderPostionMap) {
        // Base case: If the start indices
        // exceed the end indices, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Create a new TreeNode with value
        // at the current preorder index
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the index of the current root
        // value in the inorder traversal
        int inRoot = inorderPostionMap.get(root.data);

        // Calculate the number of
        // elements in the left subtree
        int numsLeft = inRoot - inStart;

        // Recursively build the left subtree
        root.left = buildTree(inorder, inStart, inRoot - 1, 
        		preorder, preStart + 1, preStart + numsLeft, inorderPostionMap);

        // Recursively build the right subtree
        root.right = buildTree(inorder, inRoot + 1, inEnd, 
        		preorder, preStart + numsLeft + 1, preEnd, inorderPostionMap);

        // Return the current root node
        return root;
    }
	
	public static void printInOrderNode(TreeNode root) {
		if( root == null)
			return;
		
		printInOrderNode(root.left);
		System.out.print(root.data+" ");
		printInOrderNode(root.right);
	}
}

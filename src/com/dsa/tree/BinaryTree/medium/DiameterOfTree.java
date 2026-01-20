package com.dsa.tree.BinaryTree.medium;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 https://takeuforward.org/plus/dsa/problems/diameter-of-binary-tree?category=binary-trees&subcategory=medium-problems&tab=editorial
 * 
 * The diameter of binary tree is the longest path between any two nodes in the tree. 
  It may or may not pass through root node.
 *
 * we need to find every nodes Left and Right paths means finding height from that node
 * 
 * 
 * 
 */
public class DiameterOfTree {
	public static void main(String[] args) {
	  TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      System.out.println("Diameter of the binary tree is: " + diameterOfBinaryTreeBruteForce(root));
	}

	/** Height calculation of each node 
	 * bottom up approach
	 * */
	public static int heightCal(TreeNode node) {
		if(node == null ) return 0;
		return 1 + Math.max(heightCal(node.left), heightCal(node.right)); 
	}
	
	/**
	 * TC : O(n^2) 
	 * top down approach
	 * 
	 */
	public static int diameterOfBinaryTreeBruteForce(TreeNode root) {
		if(root == null ) return 0;
		
		// calculate the height of left and right subtree
		int leftH = heightCal(root.left);
		int rightH = heightCal(root.right);
		
		// calculate the diameter of currentNode
		int currentDiameter = leftH + rightH;
		
		// Recursively calculate the diameter of left and right subtrees
		int leftDiameter = diameterOfBinaryTreeBruteForce(root.left);
		int rightDiameter = diameterOfBinaryTreeBruteForce(root.right);
		
		return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
		
	}
	
	/**
	 *  In brute force approach we are calling extra method that 
	 *  cause O(N) to reduce that we initialize one array variable
	 *  to store diameter value
	 *  
	 *  1) while calculating the height we check for diameter also
	 * 
	 */
	public static int diameterOfBT_optimal(TreeNode root) {
		int [] diameter = new int[1];
		diameter[0] = 0;
		height_of_bt_optimal(root, diameter);
		return diameter[0];
	}
	
	/**
	 * Calculation of height
	 * 
	 */
	public static int height_of_bt_optimal(TreeNode root, int [] diameter) {
		if(root == null) return 0;
		
		int [] leftHeight = new int[1];
		int [] rightHeight = new int[1];
		
		/** -- get the height of sub tree -- */
		leftHeight[0] = height_of_bt_optimal(root.left, diameter);
		rightHeight[0] = height_of_bt_optimal(root.right, diameter);
		
		/** --  add both sub tree height -- */
		int currentDia = leftHeight[0] + rightHeight[0];
		
		/** --  check with previous diameter -- */
		diameter[0] = Math.max(diameter[0], currentDia);
		
		/** --  return max height -- */
		return 1 + Math.max(leftHeight[0], rightHeight[0]);
	}
	
	
	
}

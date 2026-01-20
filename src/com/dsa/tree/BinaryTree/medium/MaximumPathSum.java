package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.List;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/***
 * 
 * problem is  combination of height (depth) + width (diameter) 
 * 
 * find the which path have maximum value
 * 				1			--> root   -- level 0
 * 			/		\
 * 			2		 3  -- siblings		-- level 1
 * 		/				\
 * 		4 --> leaf node	 -9				-- level 2
 * 
 * path is = 4->2->1->3
 * we have max sum for this path
 */

public class MaximumPathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(-9);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(12);
        root.right.left.right = new TreeNode(20);
        
        List<List<Integer>> responseList = new ArrayList<>();
        System.out.println(maximumPath(root));
	}
	
	public static int maximumPath(TreeNode root) {
		int [] maximum = {0};
		maximumPathDown(root,maximum);
		return maximum[0];
	}
	
	public static int maximumPathDown(TreeNode node, int[] maximum) {
		
		if(node == null) return 0;
		
		/** -- adding max because of negative value   -- */
		int leftMax = Math.max(0, maximumPathDown(node.left,maximum));
		int rightMax = Math.max(0, maximumPathDown(node.right,maximum));
		
		/** -- UPDATE THE MAX VALUE
		 *  WITH leftMax + rightMax + current value and maximum
		 *  -- */
		maximum[0] = Math.max(maximum[0], leftMax+rightMax+ node.data);
		
		/** -- for choosing the path and add the current value  -- */
		return Math.max(leftMax, rightMax) + node.data;
	}

}

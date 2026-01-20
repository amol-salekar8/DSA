package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * 				1			--> root   -- level 0
 * 			/		\
 * 			2		 3  -- siblings		-- level 1
 * 		/		
 * 		4 --> leaf node		-- level 2
 * 
 * Maximum Depth is 3 because of node 4
 * 
 * Approaches
 * 1 ) Queue based approach (Level order )
 * 2) Recursive approach
 * 
  https://takeuforward.org/plus/dsa/problems/maximum-depth-in-bt?category=binary-trees&subcategory=medium-problems
 */

public class Maximum_Depth_Or_Height_BT {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        
        List<List<Integer>> responseList = new ArrayList<>();
        System.out.println(recursive_algorithm(root));
	}

	/**
	 * By iterative approach using level order algorithm
	 * */
	public static int levelOrderBy_NarsimaRao(TreeNode root) {
        if(root == null) return 0;
		
		Queue<TreeNode> queue = new LinkedList();
		int depth =0;		
		queue.offer(root);
		/**
		 *  using null we got that we are going to start next level
		 *  use full for large level of tree
		 * */
		queue.offer(null);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr != null) {
				if(curr.left != null ) queue.offer(curr.left);
				if(curr.right != null ) queue.offer(curr.right);
			}else {
				depth++;
				if(!queue.isEmpty()) queue.offer(null);
			}
		}
		return depth++;
	}
	
	
	public static int iterative_tuf(TreeNode root) {
		if(root == null) return 0;
		
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		int count = 0;
		
		while(!queue.isEmpty()) {
			for(int i=0; i < queue.size(); i++) {
				TreeNode node = queue.poll();
				if(node.left != null) queue.offer(node);
				if(node.right != null) queue.offer(node.right);
			}
			count++;
		}
		return count;
	}
	
	
	/***
	 * by recursive algorithm
	 * use full for small level of tree
	 */
	
	public static int recursive_algorithm(TreeNode node) {
		if(node == null) return 0;
		// Divide the with two part 	
		int left = recursive_algorithm(node.left);
		int right = recursive_algorithm(node.right);
		// The depth of the tree is 1 current node + the maximum depth of the subtrees
		return 1 + Math.max(left, right);
	}
}

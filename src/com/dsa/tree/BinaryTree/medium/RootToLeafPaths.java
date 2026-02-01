package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.List;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**  -- ROOT-TO-LEAF PATHS in a Binary Tree --
 * 
 * 
 * 
 * Input: root[] = [1, 2, 3, 4, 5, N, N]
 * Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
 * Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3
 * 
 * Approach :  Recursion with Backtracking
 * 
 */
public class RootToLeafPaths {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(-9);
		root.right.right.right = new TreeNode(10);
		System.out.println(paths(root));
		
	}
	
	 static List<List<Integer>> paths(TreeNode root){
		 List<List<Integer>> paths = new ArrayList<>();
		 List<Integer> currentPath = new ArrayList<>();
		 
		 collectPath(root, paths, currentPath);
		 
		 return paths;
	 }
	 
	 static void  collectPath(TreeNode root , List<List<Integer>> paths,List<Integer> currentPath) {
		 if(root == null ) return;
		 /* current node value */
		 currentPath.add(root.data);
		 
		 /** --- check for leaf node then add that path otherwise traverse to leaf node --- */
		 if(root.left == null && root.right == null ) {
			 paths.add(new ArrayList<>(currentPath));
		 }else {
			 collectPath(root.left, paths, currentPath);
			 collectPath(root.right, paths, currentPath);
		 }
		 
		 /** --- After traversing remove the last node to add next path --- **/
		 currentPath.remove(currentPath.size()-1);
		 
	 }
	 

}

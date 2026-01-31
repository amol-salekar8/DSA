package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.List;

import com.dsa.tree.BinaryTree.utility.TreeNode;
import com.sun.source.tree.Tree;

/*** ---------- Lowest common ancestor OF BINARY TREE  -----------
 * 
 * We need to find common ancestor between the two node 
 * 
 * -> Approaches
 *1)-> [Naive approach] Checking if each node is LCA - O(N^2) Time and O(h) space -> ( Recursive)
	 	-> 1) Two recursive function ->
	 	 1)-> check for both the finding node on both the side one by one  ( Concept max height )
	 	 2)-> check for finding node is present or not hasNode()
 *2)-> [Better Approach] Storing Paths of Nodes from Root - O(n) Time and O(n) Space
	 	-> Finding the path of node from root to finding node p and q in two separate array
	  	-> and iterate over that array until we didn't found mismatch element 
	  	-> if mismatch element found on both the the array then return previous one
 *3) -> [Optimal approach] -> [Recursive] -> O(N)
  		-> Base condition root == null || p == root || q == root 
		-> process to left and right part of tree
		-> after processing if left == null -> right || right == null -> left || left == right -> root
 *
 *  			1			--> root   -- level 0
 * 			/		\
 * 			2		 3  	-- siblings	-- level 1
 * 		/		\		\
 * 		4 		5	    -9				-- level 2
 * 							\
 * 							10
 * 
 * OUTPUT => [ 1] p=5 , q=10 
 * 
 * TC : O(N) 
 */
public class LowestCommonAncestor {
	
	public static void main(String[] args) {
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		TreeNode root = new TreeNode(1);
		root.left = p;
		root.right = new TreeNode(3);
		root.left.left = q;
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(-9);
		root.right.right.right = new TreeNode(10);;
		
		System.out.println(optimalApproach(root, p, q));
	}

	/** --- Naive approach  --- 
	 * 
	 * Check for each node twice i.e for p and then for q
	 * 
	 * */
	
	public static TreeNode naiveApproach(TreeNode root , TreeNode p, TreeNode q) {
		if(root == null) return null;
		
		if(hasNode(root.left, p) && hasNode(root.right, q))
			return root;
		
		if(hasNode(root.left, q) && hasNode(root.right, p))
			return root;
		
		TreeNode left = naiveApproach(root.left, p ,q);
		TreeNode right = naiveApproach(root.right, p ,q);
		
		return left != null ? left : right;
	}
	
	public static boolean hasNode(TreeNode root, TreeNode findNode) {
		if(root == null) return false;
		return root == findNode || hasNode(root.left, findNode) || hasNode(root.right, findNode);
		
	}
	
	/** -- Storing Paths of Nodes from Root -- */
	/***
	 * The idea is to store the paths to the target nodes from the root in two separate arrays. 
	 * Then start traversing from the 0th index and look simultaneously into the values stored in the arrays, 
	 * the LCA is the last matching element in both the arrays.
	 * 
	 */
	public static TreeNode betterApproach(TreeNode root , TreeNode p, TreeNode q) {
		
		List<TreeNode> path1List = new ArrayList();
		List<TreeNode> path2List = new ArrayList();
		
		if( !findPath(root, path1List, p) || !findPath(root, path1List, q)) return null;
		
		int i =0;
		for(i=0; i < path1List.size() && i < path2List.size();i++) {
			if(path1List.get(i) != path2List.get(i))
				return path1List.get(i-1);
		}
		
		return path1List.get(i-0);
	}

	public static boolean findPath(TreeNode root, List<TreeNode> pathList, TreeNode toNode) {
		if( root == null ) return false;
		
		pathList.add(root);
		// traverse and check for node
		if(root == toNode 
				|| findPath(root.left, pathList, toNode) 
				|| findPath(root.right, pathList, toNode)) {
			return true;
		}
		
		 // remove root from path and return false
		pathList.remove(pathList.size() - 1);
		
		return false;
	}
	
	/** -- [ Optimal ] Using Single Traversal -- */
	public static TreeNode optimalApproach (TreeNode root, TreeNode p, TreeNode q) {
		// Base condition
		if(root == null || root == p || root == q) return root;
		
		
		TreeNode leftTreeNode = optimalApproach(root.left, p, q);
		TreeNode rightTreeNode = optimalApproach(root.right, p, q);
		// if one of the node is null then return another node
		if( leftTreeNode == null) return rightTreeNode;
		else if ( rightTreeNode == null ) return leftTreeNode;
		else return root;
		
	}
	
	
}

package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/***  ---------- RIGHT VIEW OF BINARY TREE  -----------
 * 
 * If we look the tree from Right position then its will see us 
 * from right outer position and remaining part of left tree that doesn't belong to shadow
 * 
 * -> Approach 
 * ->  with the help of level order 
 * -> (Brute force approach) -> ( Iterative)
		-> Level order + tree map 
		-> Level order + list 
			while iterating the list get the last element of that list
 * -> with the help of PRE order with some shift of traversing i.e. ( DRL )
 * -> ( Optimal approach ) -> (Recursive)
 *
 *  			1			--> root   -- level 0
 * 			/		\
 * 			2		 3  	-- siblings	-- level 1
 * 		/		\		\
 * 		4 		5	    -9				-- level 2
 * 	/		\	\
 * 7		8	10
 * 
 * OUTPUT => [ 1-> 3-> -9-> 10]
 * 
 * 
 */
public class RightSideOfBinaryTree {
	static class Pair{
		TreeNode node;
		int verticalIndex;
		public Pair(TreeNode node, int topViewindex) {
			super();
			this.node = node;
			this.verticalIndex = topViewindex;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(-9);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.left.right.right = new TreeNode(10);
		System.out.println(rightViewBTTraveresalByRecursive(root));
	}
	
	/** -- Optimal Approach ( Recursive )-- */
	public static List<Integer> rightViewBTTraveresalByRecursive(TreeNode root){
		List<Integer> resultList = new ArrayList<>();
		int levelOrderCount = 0;
		preOrderTraversal(root, resultList, levelOrderCount);
		return resultList;
	}
	
	public static void preOrderTraversal(TreeNode node, List<Integer> resultList, int levelCount) {
		/** -- Base condition -- */
		if(node == null) return;
		
		/** -- Data ( level count match with result Size )-- */
		if(levelCount == resultList.size()) resultList.add(node.data);
		
		/** -- first Right then Left -- */
		if(node.right != null) preOrderTraversal(node.right, resultList, levelCount+1);
		if(node.left != null) preOrderTraversal(node.left, resultList, levelCount+1);
		
	}
	
	
	/** -- Brute force Approach ( Iterative )-- */
	/** -- Level order + Tree map -- */
	public static List<Integer> rightViewBTTraveresalByMap(TreeNode root){
		List<Integer> resultList = new ArrayList();
		Queue<TreeNode> queuePair = new LinkedList();
		Map<Integer,Integer> levelOrderMap = new TreeMap();
		int count = 0;
		queuePair.offer(root);
		while(!queuePair.isEmpty()) {
			int size = queuePair.size();
			for(int i = 0; i<size; i++ ) {
				TreeNode node = queuePair.poll();
				if(node.left != null ) queuePair.offer(node.left);
				if(node.right != null ) queuePair.offer(node.right);
				levelOrderMap.put(count, node.data);
			}
			count++;
		}
		
		for(Integer right : levelOrderMap.values())
			resultList.add(right);
		return resultList;
	}
	
	/** -- Level order + List -- */
	public static List<Integer> rightViewBTTraveresalByList(TreeNode root){
		List<Integer> resultList = new ArrayList();
		List<List<Integer>> levelOrderList = new ArrayList();
		Queue<TreeNode> queuePair = new LinkedList();
		int count = 0;
		queuePair.offer(root);
		while(!queuePair.isEmpty()) {
			int size = queuePair.size();
			List<Integer> currList = new ArrayList();
			for(int i = 0; i<size; i++ ) {
				TreeNode currNode = queuePair.poll();
				currList.add(currNode.data);
				if(currNode.left != null ) queuePair.offer(currNode.left);
				if(currNode.right != null ) queuePair.offer(currNode.right);
			}
			levelOrderList.add(currList);
		}
		
		for(List<Integer> levelOrder : levelOrderList)
			resultList.add(levelOrder.get(levelOrder.size()-1));
		return resultList;
	}
	
	
}

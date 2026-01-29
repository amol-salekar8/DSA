package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/*** TOP VIEW TRAVERSAL 
 * If we look the tree from top position then its will see us 
 * from left most outer position -> right most outer position
 * and its shadow other tree node that present in between.
 * 
 * -> Created Pair class who store vertical index and TreeNode
 * -> Create a queue who store class information to perform BFS 
 * -> we use concept of vertical line ( vertical index)
 * -> root at vertical 0 index 
 * -> 			root
 * -> 	-1	/			\ +1
 * ->	leftSide		rightSide
 * -> Store only first vertical index  value into map 
 *
 * 
 *  			1			--> root   -- level 0
 * 			/		\
 * 			2		 3  -- siblings		-- level 1
 * 		/		\		\
 * 		4 		5	    -9				-- level 2
 * 	/		\	\
 * 7		8	10
 * 
 * OUTPUT => [ 7-> 4-> 2 -> 1-> 3-> -9]
 * 
 * TC : O(N) 
 */
public class TopViewTraversal {
	
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
		System.out.println(topViewBTTraveresal(root));
	}
	

	/**
	 *  We use TreeMap because of its key sorting nature
	 * 
	 */
	public static List<Integer> topViewBTTraveresal(TreeNode root){
		List<Integer> resultList = new ArrayList();
		TreeMap<Integer,Integer> topViewMap = new TreeMap();
		Queue<Pair> queue = new LinkedList();
		queue.add(new Pair(root,0));
		
		while(!queue.isEmpty()) {
			Pair currPair = queue.poll();
			TreeNode currNode = currPair.node;
			int topViewIndex = currPair.verticalIndex;
			/** -- Store only  first value-- */
			topViewMap.putIfAbsent(topViewIndex, currNode.data);
			
			if(currNode.left != null) queue.offer(new Pair(currNode.left, topViewIndex-1));
			if(currNode.right != null) queue.offer(new Pair(currNode.right, topViewIndex+1));
		}
		
		for(Integer data : topViewMap.values()) {
			resultList.add(data);
		}
		
		return resultList;
	}
	

	
	

}

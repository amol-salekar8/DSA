package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import com.dsa.tree.BinaryTree.medium.VerticalTraversal.Tuple;
import com.dsa.tree.BinaryTree.utility.TreeNode;

/*** TOP VIEW TRAVERSAL 
 * If we look the tree from top position then its will see us 
 * from left most position -> right most position
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
	
	static class Tuple{
		TreeNode node;
		int topViewindex;
		public Tuple(TreeNode node, int topViewindex) {
			super();
			this.node = node;
			this.topViewindex = topViewindex;
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
	

	public static List<Integer> topViewBTTraveresal(TreeNode root){
		List<Integer> resultList = new ArrayList();
		TreeMap<Integer,Integer> topViewMap = new TreeMap();
		Queue<Tuple> queue = new LinkedList();
		queue.add(new Tuple(root,0));
		
		while(!queue.isEmpty()) {
			Tuple currTuple = queue.poll();
			TreeNode currNode = currTuple.node;
			int topViewIndex = currTuple.topViewindex;
			topViewMap.putIfAbsent(topViewIndex, currNode.data);
			
			if(currNode.left != null) queue.offer(new Tuple(currNode.left, topViewIndex-1));
			if(currNode.right != null) queue.offer(new Tuple(currNode.right, topViewIndex+1));
		}
		
		for(Integer data : topViewMap.values()) {
			resultList.add(data);
		}
		
		return resultList;
	}
	

	
	

}

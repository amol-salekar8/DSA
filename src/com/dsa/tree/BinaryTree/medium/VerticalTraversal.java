package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/*** Vertical TREE TRAVERSAL ( Traversing in vertically from left to right )
 * -> Create a Tuple class who store Node,verticalIndex,levelOrderIndex 
 * -> Create a queue who store class information ( BFS )
 * -> root at vertical 0 index and levelOrderIndex at 0
 * -> 			root
 * -> 	-1	/			\ +1
 * ->	leftSide		rightSide
 * -> Store into map against verticalIndex -> levelOrderIndex -> node
 * 
 *  * 			1	(0,0)		--> root   -- level 0
 * 		-1	/		\ +1
 * 	(-1,0)	2		 3  (1,1)-- siblings		-- level 1
 * 		-1/		\+1		\
 * (-2,2)4  	5(0,2)	 -9(2,2)				-- level 2
 * 	/-1		\+1	 \+1
 * 7(-3,3)	8	 10(1,3)
 * 			(-1,3)
 * OUTPUT => [ 7,4, 2, 8, 1, 5, 3, 10, -9]
 * 
 * 
 */
public class VerticalTraversal {
	
	static class Tuple{
		TreeNode node;
		int verticalIndex;   // row 
		int levelOrderIndex; // column
		
		public Tuple(TreeNode node, int verticalIndex, int levelOrderIndex) {
			super();
			this.node = node;
			this.verticalIndex = verticalIndex;
			this.levelOrderIndex = levelOrderIndex;
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
		/* with TC O(n^2) */
		System.out.println(verticalTraversalBT(root));
	}
	
	public static List<List<Integer>> verticalTraversalBT(TreeNode root){
		List<List<Integer>> resultList = new ArrayList();
		Queue<Tuple> queue = new LinkedList();
		queue.offer(new Tuple(root, 0, 0));
		TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> verticalNodesMap = new TreeMap();
		
		while(!queue.isEmpty()) {
			Tuple currTuple = queue.poll();
			
			TreeNode currNode = currTuple.node;
			int x = currTuple.verticalIndex;
			int y = currTuple.levelOrderIndex;
			
			if(currNode.left != null) queue.offer(new Tuple(currNode.left, x-1, y+1));
			if(currNode.right != null) queue.offer(new Tuple(currNode.right, x+1, y+1));
			
			/* --  If there is no data present against verticalIndex -- */
			verticalNodesMap.putIfAbsent(x, new TreeMap<>());
			
			/* --  If there is no data present against levelOrderIndex -- */
			verticalNodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
			
			/* --  data present against verticalIndex -> levelOrderIndex -> add data-- */
			verticalNodesMap.get(x).get(y).offer(currNode.data);
			
		}
		
		/* -- Iterate over row map -- */
		for(TreeMap<Integer,PriorityQueue<Integer>> levelOrderMap : verticalNodesMap.values()) {
			List<Integer> columnList = new ArrayList();
			/* -- Iterate over column map -- */
			for(PriorityQueue<Integer> queueIntegers : levelOrderMap.values()) {
				while(!queueIntegers.isEmpty()) {
					columnList.add(queueIntegers.poll());
				}
			}
			resultList.add(columnList);
		}
		
		return resultList;
	}

}

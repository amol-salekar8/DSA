package com.dsa.tree.BinaryTree.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/** Minimum time taken to burn the BT from a given TreeNode  || Amount of Time for Binary Tree to Be Infected
 * 
 * Problem is same like Print_All_Nodes_At_Distance_Of_K instead getting node values from target node to Kth node
 * we are traversing whole tree structure
 * 
 * Q Why we used Map ? ==>  Get backtrack mean search for ancestor 
 * 
 * FOR THIS WE HAVE TO TRAVERSE 3 WAY
 * 1) LEFT
 * 2) CHILD
 * 3) PARENT
 * 
 * Approaches 
 * 1) Recursive ( List, Map )
 * 			 - DFS to store parent map ( we store root parent as null )
 * 			 - DFS to get the count
 * 1) Iterative ( List, Map, Set )
 * 			 - BFS to store parent map ( we didn't store root )
 * 			 - BFS to get the count
 *      3
       / \
      5   1
     / \   \
    6   2   8
       / \
      7   4
   
 * Input : root = [3, 5, 1, 6, 2, N, 8, N, N, 7,4] , target = 5, 
 */
public class MinimumTimeTakenToBurnBTFromGivenTreeNode {
	
	public static void main(String[] args) {
		List<Integer> nodes = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
		TreeNode root = createTree(nodes, 0);
	     int target = 5;
	     System.out.println(timeTakenToBurnBTFromBurnNode(root,target));
	}
	
	// Helper function to create a binary tree from a list
	public static TreeNode createTree(List<Integer> nodes, int index) {
		if (index < nodes.size() && nodes.get(index) != null) {
			TreeNode root = new TreeNode(nodes.get(index));
			/** -- Segment tree formula and its also used in to calculate maximum width -- */
			root.left = createTree(nodes, 2 * index + 1);
			root.right = createTree(nodes, 2 * index + 2);
			return root;
		}
		return null;
	}
	
	public static int timeTakenToBurnBTFromBurnNode(TreeNode root, int burnData) {
		Map<TreeNode,TreeNode> childParentMap = new HashMap<>();
		TreeNode burnNode = findBurnNode(root, burnData, childParentMap);
		return findTimeToBurn(burnNode, childParentMap);
		
	}
	
	
	public static  TreeNode findBurnNode(TreeNode root, int burnData, Map<TreeNode,TreeNode> childParentMap) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode burnNode = null;
		
		while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.data == burnData) burnNode = node;
            if(node.left != null){
            	childParentMap.put(node.left,node);
                queue.offer(node.left);
            }
            if(node.right != null){
            	childParentMap.put(node.right,node);
                queue.offer(node.right);
            }
        }
		return burnNode;
	}

	public static int findTimeToBurn(TreeNode burnNode, Map<TreeNode,TreeNode> childParentMap) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(burnNode);
		
		HashSet<TreeNode> visitedNode = new HashSet<>();
		visitedNode.add(burnNode);
		
		int time = -1;
		
		while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null && !visitedNode.contains(currentNode.left)){
                    queue.offer(currentNode.left);
                    visitedNode.add(currentNode.left);
                }
                if(currentNode.right != null && !visitedNode.contains(currentNode.right)){
                    queue.offer(currentNode.right);
                    visitedNode.add(currentNode.right);
                }
                if(childParentMap.containsKey(currentNode) && !visitedNode.contains(childParentMap.get(currentNode))){
                    queue.offer(childParentMap.get(currentNode));
                    visitedNode.add(childParentMap.get(currentNode));
                }
            }
            time++;
        }
		return time;
		
	}
	
	
	
	

}

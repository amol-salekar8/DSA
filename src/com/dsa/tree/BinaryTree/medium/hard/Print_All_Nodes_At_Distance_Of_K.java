package com.dsa.tree.BinaryTree.medium.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * DESC : Given the root of a binary tree, the value of a target node target,
 * and an integer k. Return an array of the values of all nodes that have a
 * distance k from the target node.
 * 
 * Q Why we used Map ? ==>  Get backtrack mean search for ancestor 
 * 
 * Approaches 
 * 1) Recursive ( List, Map )
 * 			 - DFS to store parent map ( we store root parent as null )
 * 			 - DFS to get the Kth position element form target
 * 1) Iterative ( List, Map, Set )
 * 			 - BFS to store parent map ( we didn't store root )
 * 			 - BFS to get the Kth position element form target
 * 
 * 		3
       / \
      5   1
     / \   \
    6   2   8
       / \
      7   4
 *  Input : root = [3, 5, 1, 6, 2, N, 8, N, N, 7,4] , target = 5, k = 2 Output : [1, 4, 7] 
 *  Explanation : The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 */
public class Print_All_Nodes_At_Distance_Of_K {
	static HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		List<Integer> nodes = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
		TreeNode root = createTree(nodes, 0);
		TreeNode targetNode = root.left;
		int kthPositon = 2;
		System.out.println(getKthNodeFromTargetNode(root, targetNode, kthPositon));
	}

	/** Recursive Approach */
	public static List<Integer> findingNodeAtDistanceK(TreeNode root, TreeNode targetNode, int kthPositon) {
		buildParentMap(root, null);
		findNodesAtDistanceK(targetNode, null, kthPositon);
		return result;
	};


    /* -- DFS to build parent relationships for all nodes in the tree  -- */
	private static void buildParentMap(TreeNode currentNode, TreeNode parentNode) {
		if (currentNode == null) {
			return;
		}
		// Store the parent relationship
		parentMap.put(currentNode, parentNode);
		// Recursively process left and right subtrees
		buildParentMap(currentNode.left, currentNode);
		buildParentMap(currentNode.right, currentNode);
	}

	/** DFS to find all nodes at distance k from the starting node */
	private static void findNodesAtDistanceK(TreeNode currentNode, TreeNode previousNode, int remainingDistance) {
		if (currentNode == null) {
			return;
		}
		// If we've reached the required distance, add node to result
		if (remainingDistance == 0) {
			result.add(currentNode.data);
			return;
		}
		// Explore all three possible directions: left child, right child, and parent
		TreeNode[] neighbors = { currentNode.left, currentNode.right, parentMap.get(currentNode) };
		for (TreeNode nextNode : neighbors) {
			// Avoid going back to the node we came from
			if (nextNode != previousNode) {
				findNodesAtDistanceK(nextNode, currentNode, remainingDistance - 1);
			}
		}
	}
	
	/** Iterative Approach
	 * 1) Child -> parent map
	 * 2) Check for nth node from target node
	 * 3) while getting the nth node we have to store visited node
	 * */
	
	public static List<Integer> getKthNodeFromTargetNode(TreeNode root, TreeNode targetNode, int position){
		List<Integer> kthPostionList = new ArrayList<>();
		Map<TreeNode, TreeNode> childParentRelationMap = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		/** Build parent child relation map */
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left != null ) {
				childParentRelationMap.put(node.left, root);
				queue.add(node.left);
			}
			if(node.right != null ) {
				childParentRelationMap.put(node.right, root);
				queue.add(node.right);
			}
		}
		
		/** Check for kth position node + Visited node */
		Set<TreeNode> visitedNode = new HashSet<>();
		queue.offer(targetNode);
		visitedNode.add(targetNode);
		
		while(!queue.isEmpty()) {
			if(position == 0) {
				while(!queue.isEmpty()) {
					kthPostionList.add(queue.poll().data);
				}
				return kthPostionList;
			}
			int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Check left child
                if (node.left != null && !visitedNode.contains(node.left)) {
                    queue.add(node.left);
                    visitedNode.add(node.left);
                }
                // Check right child
                if (node.right != null && !visitedNode.contains(node.right)) {
                    queue.add(node.right);
                    visitedNode.add(node.right);
                }
                // Check parent
                if (childParentRelationMap.containsKey(node) && !visitedNode.contains(childParentRelationMap.get(node))) {
                    queue.add(childParentRelationMap.get(node));
                    visitedNode.add(childParentRelationMap.get(node));
                }
            }
			position --;
		}
		
		return kthPostionList;
	}
	

	// Helper function to create a binary tree from a list
	public static TreeNode createTree(List<Integer> nodes, int index) {
		if (index < nodes.size() && nodes.get(index) != null) {
			TreeNode root = new TreeNode(nodes.get(index));
			root.left = createTree(nodes, 2 * index + 1);
			root.right = createTree(nodes, 2 * index + 2);
			return root;
		}
		return null;
	}
	
}

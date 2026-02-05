package com.dsa.tree.BinaryTree.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/***
 * 
 * Its a concept of In-Order but without using stack and recursion
 * 
 * Cases 1: Assign root node to current node
 * Case 2 : check current node is null or not if its not null  then go for next step
 * Case 3 : check for currentNode -> left is null or not
 *  	3.1 : if its null then process the currentNode and  assign currentNode -> right to  currentNode 
 *  	3.2 : if its not null the assign currentNodes -> left to prevNode
 *  	3.3 : got till prevNode -> right is not null and prevNode-> right is not equal to currentNode
 *  	3.4 : UPTO  prevNode -> right  becomes null till assign currentNode to prevNode-> right [ Transforming into chain ]
 * 		3.5 : if prevNode -> right become null then assign prevNode -> right to current node
 * 		3.6 : otherwise prevNode -> right is current node then change prevNode -> right to null -> process curr node -> currentNode -> right 
 * 
 * 
 * 
 * 				1			--> root
 * 			/		\
 * 			2		 3
 * 		/		\
 * 	   4		 5
 * 				  \
 * 					6
 * 
 * LDR
 * 4 2 5 6 1 3
 * 
 * 
 */
public class MorrisInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.left.right.right = new TreeNode(6);
	        System.out.println(morrisInOrder(root));
	}
	
	public static List<Integer> morrisInOrder(TreeNode root){
		List<Integer> morrisInorderList = new ArrayList<>();
		// Set the root node as curr node
		TreeNode currNode  = root;
		while(currNode != null) {
			/** -- If currNode left  is null then process currNode and go for right side   -- */
			if(currNode.left == null) {
				morrisInorderList.add(currNode.data);
				currNode = currNode.right;
			}else {
				/** -- assign  currNode -> left  to prevNode   -- */
				TreeNode prevNode = currNode.left;
				/** -- If prevNode -> right  is not null and its should not equal to current node    -- */
				while(prevNode.right != null && prevNode.right != currNode) {
					prevNode = prevNode.right;
				}
				/** -- If prevNode -> right is null then change that pointer to current node  -- */
				if(prevNode.right == null) {
					/** -- assign prevNode -> right  pointer ->  currNodes  -- */
					prevNode.right = currNode;
					/** -- change current node to  currNodes.left  */
					currNode = currNode.left;
				}else {
					/** -- if there is prevNode -> right node present and its equal to current node then 
					 * 	make prevNode -> right to null then process it and change the pointer
					 *  -- */
					prevNode.right = null;
					morrisInorderList.add(currNode.data);
					currNode = currNode.right;				
				}
			}
		}
		
		return morrisInorderList;
	}

}

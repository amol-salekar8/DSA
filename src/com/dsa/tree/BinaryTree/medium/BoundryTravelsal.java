package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/*** BOUNDARY TREE TRAVERSAL ( Traversing in Anti-clockwise )
 * -> Left boundary  excluding leaf
 * -> leaf node  ( Perform Pre-Order traversal )
 * -> right boundary excluding leaf in reverse order
 * 
 * 
 */
public class BoundryTravelsal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        List<Integer> resultList = new ArrayList();
        if(!isLeaf(root)) resultList.add(root.data);
        leftBoundry(root, resultList);
        leafNodes(root, resultList);
        rightBoundry(root, resultList);
        resultList.stream().forEach(System.out::println);
	}
	
	public static boolean isLeaf(TreeNode node) {
		if(node.left == null && node.right == null ) return true;
		return false;
	}
	
	public static void leftBoundry(TreeNode node,List<Integer> resultList) {
		TreeNode currNode = node.left;
		while(currNode != null) {
			if(!isLeaf(currNode))resultList.add(currNode.data);
			if(currNode.left != null) currNode = currNode.left;
			else currNode = currNode.right;
		}
	}
	
	public static void rightBoundry(TreeNode node,List<Integer> resultList) {
		TreeNode currNode = node.right;
		Stack<Integer> stack = new Stack();
		while(currNode != null) {
			if(!isLeaf(currNode)) stack.push(currNode.data);
			if(currNode.right != null) currNode = currNode.right;
			else currNode = currNode.left;
		}
		resultList.addAll(stack);
	}
	
	public static void leafNodes(TreeNode node,List<Integer> resultList) {
		if(isLeaf(node)) {
			resultList.add(node.data);
			return;
		}
		leafNodes(node.left,resultList);
		leafNodes(node.right,resultList);
	}
	

}

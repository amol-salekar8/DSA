package com.dsa.tree.BinaryTree.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * 				1			--> root   -- level 0
 * 			/		\
 * 			2		 3  -- siblings		-- level 1
 * 		/		\
 * 	   4		 5  --> leaf node		-- level 2
 * 
 * [[1],[2,3][4,5]]
 * 
 * Queue based approach
 * 
 */
public class LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        List<List<Integer>> responseList = new ArrayList<>();
        levelOrderByTUF(root, responseList);
        
        responseList.forEach(System.out::println);
        
	}

	public static void levelOrderByTUF(TreeNode root, List<List<Integer>> dataList) {
		Queue<TreeNode> queue = new LinkedList();
		List<Integer> levelList = new ArrayList();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr != null) {
				levelList.add(curr.data);
				if(curr.left != null ) queue.offer(curr.left);
				if(curr.right != null ) queue.offer(curr.right);
			}else {
				List<Integer> curr_List = new ArrayList<>(levelList);
				dataList.add(curr_List);
				levelList.clear();
				if(!queue.isEmpty()) queue.offer(null);
			}
		}
	}
}

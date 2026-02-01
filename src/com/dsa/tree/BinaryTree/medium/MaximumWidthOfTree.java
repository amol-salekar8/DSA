package com.dsa.tree.BinaryTree.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.tree.BinaryTree.utility.TreeNode;

public class MaximumWidthOfTree {
	static class Pair<K,V>{
		K k;
		V v;
		Pair(K k, V v){
			this.k = k;
			this.v = v;
		}
		
		public K getK() {
			return k;
		}
		public V getV() {
			return v;
		}
		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(-9);
		root.right.right.right = new TreeNode(10);
		System.out.println(maximumWidth(root));
		
	}
	
	public static int maximumWidth(TreeNode root) {
		Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
		int maxDepth = 0;
		queue.offer(new Pair<>(root,0));
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			int size = queue.size();
			int first=0,last =0;
			TreeNode node = pair.getK()
			for(int i=0;i<size;i++) {
				
				
			}
			
		}
		
		
		return maxDepth;
	}

}

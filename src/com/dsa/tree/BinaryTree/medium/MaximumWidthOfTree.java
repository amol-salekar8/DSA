package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/** --- Maximum Width of Binary tree ---
 * 
 * Approaches 
 * 1) Level order + Pair [ Iterative ]
 * 2) DLR + List  [ Recursion ]
 * 
 * length between left outer most and right outer most 
 * If there null value in between still we have to count that 
 * Suppose we have full binary tree then how many count it will lies in between that nodes
 * 
 * we can calculate that with the help of segment tree formula
 * 							 		 root ( 0 )
 * 	[ 2*(previous_index)+1 ]/							\ [2*(previous_index)+2 ]
 * 							1   							 2		
	[ 2*(previous_index)+1 ]/   \[2*(previous_index)+2 ]	\[2*(previous_index)+2 ]
							3     4     	  				6
 * 
 * firstIndex = 3;
 * lastIndex = 6;
 * 
 * maximumWidth = lastIndex - firstIndex +1;
 * 
 * 
 * if root start at 1 then we need to remove 
 * 				  root ( 1 )
 * 				/			\
 * 		2*1	2   		 	3	(2*1+1) 
 * 
 * */

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
		System.out.println(widthOfBinaryTree(root));
		
	}
	
	/** -- With Iterative -- */
	public static int maximumWidth(TreeNode root) {
		Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
		int maxWidth = 0;
		/**-- We start at root position 0 -- */
		queue.offer(new Pair<>(root,0));
		
		while(!queue.isEmpty()) {
			/** -- to reduce overflow and to start index at zero position  -- */
			int levelStartIndex = (Integer) queue.peek().getV();
			
			int size = queue.size();
			int first = 0, last = 0;
			
			for(int i=0;i<size;i++) {
				TreeNode node = (TreeNode) queue.peek().getK();
				/** -- to start index at zero position  -- */ 
				int current_index = (Integer) queue.peek().getV() - levelStartIndex;
				queue.poll();
				/** -- Store the first and last index  -- */
				if(i==0) first = current_index;
				if(i == size-1) last = current_index;
				/** -- used segment tree formula  -- */
				if(node.left != null ) queue.offer(new Pair<>(node.left, ( 2 * current_index ) + 1));
				if(node.right != null ) queue.offer(new Pair<>(node.right, ( 2 * current_index )+ 2));
			}
			maxWidth = Math.max(maxWidth, last-first+1);
		}
		return maxWidth;
	}
	
	/** -- With Recursion-- */
	private static int maxWidth = Integer.MIN_VALUE;
 	private static List<Integer>leftIndexList = new ArrayList<>();
 	
    private static void findWidth(TreeNode root, int depth, int index){
        if(root == null)return;
        if(depth == leftIndexList.size()){  // we have never visited this level or depth
            leftIndexList.add(index);
        }

        maxWidth = Math.max(maxWidth, index - leftIndexList.get(depth) + 1);
        
        findWidth(root.left, depth+1, 2*index+1);
        findWidth(root.right,depth+1, 2*index+2);
        return;
    }
    
    private static int widthOfBinaryTree(TreeNode root) {
        findWidth(root,0,0); // {root,depth,index}
        return maxWidth;
    }

}

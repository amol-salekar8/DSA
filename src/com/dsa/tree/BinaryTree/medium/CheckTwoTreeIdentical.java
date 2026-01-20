package com.dsa.tree.BinaryTree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.BinaryTree.utility.TreeNode;

/**
 * Input : p = [1, 2, 3] , q = [1, 2, 3]
 * Output : true
 * 
 * TWO approaches 
 * 1) Recursive 
 * 2) Iterative (PRE order => DLR )
 * 
 * Condition 
 * 1) If both root is null then its true
 * 2) Check for data and both pointers
 https://takeuforward.org/plus/dsa/problems/check-if-two-trees-are-identical-or-not?category=binary-trees&subcategory=medium-problems&tab=description&approach=solution
 */
public class CheckTwoTreeIdentical {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);

		System.out.println(checkTwotreeIdentical_Recursive(root, root2));
	}

	public static boolean checkTwotreeIdentical_Recursive(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;

		if (node1.data != node2.data)
			return false;

		return checkTwotreeIdentical_Recursive(node1.left, node2.left) && checkTwotreeIdentical_Recursive(node1.right, node2.right);
	}
	
	public static boolean checkTwotreeIdentical_Iterative(TreeNode node1, TreeNode node2) {
		Stack<TreeNode> node1Stack = new Stack();
        Stack<TreeNode> node2Stack = new Stack();

        node1Stack.push(node1);
        node1Stack.push(node2);

        while( !node1Stack.isEmpty() || !node1Stack.isEmpty() ){
            TreeNode pTreeNode = node1Stack.pop();
            TreeNode qTreeNode = node1Stack.pop();
            // check for both node
             if(pTreeNode == null && qTreeNode == null ) return true;
             
          // check for of the node
             if (pTreeNode == null || qTreeNode == null ) return false;
            
            // check for different data
            if(pTreeNode.data != qTreeNode.data){
                return false;
            }else {
                if(pTreeNode.right != null || qTreeNode.right != null){
                    node1Stack.push(pTreeNode.right);
                    node1Stack.push(qTreeNode.right);
                }
                if(pTreeNode.left != null || qTreeNode.left != null){
                    node1Stack.push(pTreeNode.left);
                    node1Stack.push(qTreeNode.left);
                }
            }

        }
        return true;
	}

}

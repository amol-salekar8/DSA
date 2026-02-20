package com.dsa.tree.BinaryTree.utility;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    // Constructor to initialize the TreeNode with a value
    public TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
    
    
}
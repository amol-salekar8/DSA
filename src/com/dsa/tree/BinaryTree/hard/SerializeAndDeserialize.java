package com.dsa.tree.BinaryTree.hard;

import com.dsa.tree.BinaryTree.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serialize(root));
    }

    public static  String serialize(TreeNode treeNode){
        if(treeNode == null) return "";
        StringBuffer buffer = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while(queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                buffer.append("n ");
                continue;
            }
            buffer.append(node.data+" ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return buffer.toString();
    }

}

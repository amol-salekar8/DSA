package com.dsa.tree.BinaryTree.hard;

import com.dsa.tree.BinaryTree.utility.TreeNode;

import java.util.*;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String treeString = serializePreOrder(root);
        System.out.println(treeString);
        TreeNode node = deserializePreOrder(treeString);
        System.out.println(serializePreOrder(node));
    }

    public static  String serialize(TreeNode treeNode){
        if(treeNode == null) return "";
        StringBuffer buffer = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                buffer.append("n ");
                continue;
            }
            buffer.append(node.data+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return buffer.toString();
    }

    public static  TreeNode deserialize(String tree){
        if(tree == "" ) return  null;

        String [] treeArr = tree.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(treeArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i =1;
        while(i < treeArr.length){
            TreeNode node = queue.poll();
            if(!treeArr[i].equals("n")){
                TreeNode left = new TreeNode(Integer.valueOf(treeArr[i]));
                node.left = left;
                queue.add(left);
            }
            if(!treeArr[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.valueOf(treeArr[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static String serializePreOrder(TreeNode root) {
        if(root == null) return "";
        StringBuffer buffer = new StringBuffer();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null ){
                buffer.append("#,");
                continue;
            }
            buffer.append(node.data+",");
            stack.push(node.right);
            stack.push(node.left);
        }
        return buffer.toString();
    }

    public static TreeNode deserializePreOrder(String data) {
        if (data == null || data.equals("null")) return null;

        String[] values = data.split(",");
        int n = values.length;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int i = 1;

        while (!stack.isEmpty() && i < n) {
            TreeNode current = stack.peek();

            // If left child not processed yet
            if (current.left == null) {
                if (!values[i].equals("#")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                    current.left = leftNode;
                    stack.push(leftNode);
                }
                i++;
            }
            // Process right child
            else {
                if (!values[i].equals("#")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                    current.right = rightNode;
                    stack.push(rightNode);
                }
                stack.pop();  // Done with this node
                i++;
            }
        }

        return root;
    }
}

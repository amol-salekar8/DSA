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
        String[] str = data.split(",");
        int[] index = new int[1];
        return  deserializePreRecursion(str,index);
    }

    public static TreeNode deserializePreRecursion(String[] strArray, int[] index){
        if (strArray[index[0]].equals("#")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strArray[index[0]++]));
        node.left = deserializePreRecursion(strArray,index);
        node.right = deserializePreRecursion(strArray,index);
        return node;
    }

}

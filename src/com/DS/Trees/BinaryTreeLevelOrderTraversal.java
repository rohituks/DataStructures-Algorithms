package com.DS.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    //https://leetcode.com/problems/binary-tree-level-order-traversal/

    /*
    Time Complexity - O(n) , where n is size of the tree
    Space Complexity - O(n) ,
     */
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n22 = new TreeNode(4);
        TreeNode n23 = new TreeNode(5);
        TreeNode n24 = new TreeNode(6);
        TreeNode n36 = new TreeNode(7);
        root.setLeftChild(n11);
        root.setRightChild(n12);
        n11.setRightChild(n22);
        n12.setLeftChild(n23);
        n12.setRightChild(n24);
        n23.setRightChild(n36);
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> hello = binaryTreeLevelOrderTraversal.levelOrder(root);
        System.out.println(hello);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        //Edge case
        if (root == null){
            return new ArrayList<>(root.getVal());
        }
        ArrayList<Integer> hello = new ArrayList<>();

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root); //add add root into the queue
        while (!q.isEmpty() && q != null){// this will execute for values in node. so once for 1 node
            int numnodes = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<=numnodes; i++) {
                TreeNode node = q.poll(); // poll removes head of this queue
                //print out values - append values
                temp.add(node.getVal());
                if (node.getLeftChild() != null) {
                    q.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    q.add(node.getRightChild());
                }
            }
            levels.add(new ArrayList<>(temp));
        }
        return levels;
    }
}

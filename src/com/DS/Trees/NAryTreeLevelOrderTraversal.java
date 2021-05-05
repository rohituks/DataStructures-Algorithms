package com.DS.Trees;

import java.util.*;

public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.setVal(2);
        node.setVal(3);
        node.setVal(4);
        node.setVal(5);
        node.setVal(6);
    }

    /*
    https://leetcode.com/problems/n-ary-tree-level-order-traversal/
    /*
    Time Complexity - O(n) , where n is size of the tree
    Space Complexity - O(n) ,
     */

    public List<List<Integer>> levelOrder(TreeNode root) {

        //Edge case
        if (root == null){
            return new ArrayList<>(root.getVal());
        }
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root); //add add root into the queue
        while (!q.isEmpty() && q != null){// this will execute for values in node. so once for 1 node
            int numnodes = q.size();
            boolean hello = false;
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<=numnodes; i++) {
                TreeNode node = q.poll(); // poll removes head of this queue
                //print out values - append values
                temp.add(node.getVal());
            }
            levels.add(new ArrayList<>(temp));
        }
        Collections.reverse(levels);
        return levels;
    }
}

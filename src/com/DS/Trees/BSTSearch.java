package com.DS.Trees;


public class BSTSearch {
    //https://leetcode.com/problems/search-in-a-binary-search-tree/solution/
    public static void main(String[] args) {
        BSTSearch bstSearch = new BSTSearch();
    }


    public TreeNode searchIterative(TreeNode root, int key) {

        if (root == null || root.getVal() == key) {
            return root;
        }
        while (key != root.getVal()) {
            root = key < root.getVal() ? root.getLeftChild() : root.getRightChild();
            return root;
        }
        return root;
    }

    //Leetcode
    public TreeNode searchIterativeBST(TreeNode root, int val) {
        while (root != null && val != root.getVal())
            root = val < root.getVal() ? root.getLeftChild() : root.getRightChild();
        return root;
    }

    //Leetcode
    public TreeNode searchRecursive(TreeNode root, int key) {
        if (root == null || key == root.getVal()) {
            return root;
        }
        return key < root.getVal() ? searchRecursive(root.getLeftChild(), key) : searchRecursive(root.getRightChild(), key);
    }

    /* Leetcode implementations
    public TreeNode insertRecursive(TreeNode root, int key){
        if( root == null){
            return new TreeNode(key);
        }
        if( key > root.getLeftChild()) root = insertRecursive(root.getLeftChild(), key);
            else  root.left = insertIntoBST(root.left, val);
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null) {
            if (val == root.getKey()) {
                return null;
            } else if (val < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;

            }
        }
        if (val < prev.val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode prev = null;
        TreeNode curr = root;

        while(curr != null){
            if(val == root.val){
                return null;
            }
            else if (val < curr.val){
                prev = curr;
                curr = curr.left;
            }
            else {
                prev = curr;
                curr = curr.right;

            }
        }
        if (val < prev.val){
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
        return root;
    }
     */
}
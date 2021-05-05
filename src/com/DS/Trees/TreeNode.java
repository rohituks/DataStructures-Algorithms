package com.DS.Trees;

import java.util.Iterator;
import java.util.List;

public class TreeNode {

    private int val;
    private TreeNode leftChild;
    private TreeNode rightChild;

    //Constructor for Key
    public TreeNode(int val){
        this.val = val;
    }

/*
    public void insert(int newKey){
        if (newKey == val){
            return;
        }

        if( newKey < val){
            if(leftChild == null){
               leftChild = new TreeNode(newKey);
            }
            leftChild.insert(newKey);
        }

        else {
            if( rightChild == null){
                rightChild = new TreeNode(newKey);
            }
            rightChild.insert(newKey);
        }

    }
*/

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

}

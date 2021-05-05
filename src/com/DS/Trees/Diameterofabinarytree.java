package com.DS.Trees;

public class Diameterofabinarytree {

    private int myDia;
    public static void main(String[] args){
        //root = [1,2,3,4,5,6,7]
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
        Diameterofabinarytree diameterofabinarytree = new Diameterofabinarytree();
        diameterofabinarytree.diameterOfBinaryTree(root);
        System.out.println(diameterofabinarytree.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        myDia =0;
        //Edge case
        if(root == null){
            return myDia;
        }
        findDiameterofTree(root);
        return myDia;
    }

    public int findDiameterofTree(TreeNode node){
        //Base case
        if(node.getLeftChild() == null && node.getRightChild() == null){
            return 0;
        }


        int diameter = 0;
        //Recursive methods
        int leftDia = 0;
        if (node.getLeftChild() != null){
            leftDia =  findDiameterofTree(node.getLeftChild());
            myDia += diameter +1;;
        }
        int rightDia = 0;
        if(node.getRightChild() != null){
            rightDia = findDiameterofTree(node.getRightChild());
            myDia += diameter +1;;
        }
        myDia = Math.max(diameter, myDia);
        return Math.max(leftDia, rightDia) + 1;
    }
}

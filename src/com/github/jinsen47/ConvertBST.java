package com.github.jinsen47;

import com.github.jinsen47.model.TreeNode;

/**
 * Created by Jinsen on 16/4/12.
 */
public class ConvertBST {
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode pMostLeft = convertBST(root.left);
        TreeNode pCur = pMostLeft;
        while (pCur != null && pCur.right != null) {
            pCur = pCur.right;
        }
        if (pCur != null) {
            pCur.right = root;
            root.left = pCur;
        }

        TreeNode pRightChild = convertBST(root.right);
        if (pRightChild != null) {
            root.right = pRightChild;
            pRightChild.left = root;
        }
        return pMostLeft == null ? root : pMostLeft;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);

        TreeNode treeNode = convertBST(root);
        while (treeNode != null) {
            System.out.print(treeNode.val + "\t");
            treeNode = treeNode.right;
        }
    }
}

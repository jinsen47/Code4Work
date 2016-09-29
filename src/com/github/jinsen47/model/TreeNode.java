package com.github.jinsen47.model;

/**
 * Created by Jinsen on 15/11/9.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
  }

    public static TreeNode buildBST(int[] input) {
        TreeNode root = new TreeNode(input[0]);

        for (int i = 1; i < input.length; i++) {
            TreeNode cur = root;
            while (cur != null) {
                if (input[i] < cur.val) {
                    if (cur.left == null) {
                        cur.left = new TreeNode(input[i]);
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else if (input[i] > cur.val) {
                    if (cur.right == null) {
                        cur.right = new TreeNode(input[i]);
                        break;
                    } else {
                        cur = cur.right;
                    }
                } else {
                    throw new IllegalArgumentException("BST element has to be unique!!!");
                }
            }
        }
        return root;
    }
}

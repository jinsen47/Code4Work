package com.github.jinsen47;

import com.github.jinsen47.model.TreeNode;

import java.util.Arrays;

/**
 * Created by Jinsen on 16/4/6.
 */
public class ReContructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null ||
                pre.length == 0 || in.length == 0 ||
                pre.length != in.length) {
            return null;
        }
        TreeNode root = buildTree(pre, in);

        return root;
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        // 只有一个节点, 前序=中序
        if (pre.length == 0) return null;
        if (pre.length == 1) return new TreeNode(pre[0]);

        // 前序遍历 第一个为根节点
        TreeNode root = new TreeNode(pre[0]);

        int indexOfRootInOrder = 0;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                indexOfRootInOrder = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(pre, 1, 1 + indexOfRootInOrder),
                Arrays.copyOfRange(in, 0, indexOfRootInOrder));
        root.right = buildTree(Arrays.copyOfRange(pre, indexOfRootInOrder + 1, pre.length),
                Arrays.copyOfRange(in, indexOfRootInOrder + 1, in.length));
        return root;

    }
}

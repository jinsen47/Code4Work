package com.github.jinsen47;

import com.github.jinsen47.model.TreeNode;

import java.util.*;

/**
 * Created by Jinsen on 15/11/9.
 */
public class BinaryTreeTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode node = stack.pop();
      ret.add(node.val);
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return ret;
  }

    /**
     * 二叉树层序遍历(变种)
     * 要求每一层结束输出一个换行符
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<TreeNode> levelList = new ArrayList<>();
        while(!queue.isEmpty()) {
            while(!queue.isEmpty()) {
                levelList.add(queue.poll());
            }
            for (TreeNode t: levelList) {
                System.out.print(t.val + " ");
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            levelList.clear();
            System.out.println();
        }
    }


  public static void main(String[] args) {
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.right = new TreeNode(12);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(7);
//      root.right.left = new TreeNode(11);
      root.right.right = new TreeNode(13);

      levelOrderTraversal(root);
  }


}

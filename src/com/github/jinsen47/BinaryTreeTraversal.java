package com.github.jinsen47;

import com.github.jinsen47.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


  public static void main(String[] args) {

  }


}

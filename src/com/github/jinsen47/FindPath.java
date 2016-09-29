package com.github.jinsen47;

import com.github.jinsen47.model.TreeNode;
import com.github.jinsen47.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jinsen on 16/9/12.
 */
public class FindPath {

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null || target <= 0) return result;
        Stack<Integer> stack = new Stack<>();
        findCur(root, target, stack, result);
        return result;
    }

    public static void findCur(TreeNode cur, int remain, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result) {
        if (remain < 0) return;
        if (cur.val > remain) return;
        if (cur.val == remain && cur.left == null && cur.right == null) {
            ArrayList<Integer> path = new ArrayList<>();
            path.addAll(stack);
            path.add(cur.val);
            result.add(path);
            return;
        }
        if (cur.left != null) {
            stack.push(cur.val);
            findCur(cur.left, remain - cur.val, stack, result);
            stack.pop();
        }
        if (cur.right != null) {
            stack.push(cur.val);
            findCur(cur.right, remain - cur.val, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildBST(new int[]{10,5,12,4,7});
        ArrayList<ArrayList<Integer>>results = findPath(root, 15);
        for (ArrayList l : results) {
            ArrayUtils.printArray(l);
        }
    }
}

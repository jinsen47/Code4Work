package com.github.jinsen47;

import com.github.jinsen47.model.ListNode;
import com.github.jinsen47.utils.ArrayUtils;

/**
 * Created by Jinsen on 16/4/9.
 */
public class DeleteLinkNode {
    public static ListNode deleteNode(ListNode root, ListNode target) {
        if (root == null || target == null) return null;
        // 删除头结点
        if (target == root) {
            root = root.next;
            target = null;
            return root;
        }
        ListNode targetNext = target.next;
        if (targetNext != null) {
            target.val = targetNext.val;
            target.next = targetNext.next;
        } else {
            // 删除尾结点
            ListNode node = root;
            while (node.next != target) {
                node = node.next;
            }
            node.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = ArrayUtils.buildLinkedList(new int[]{1});
        ListNode target = ArrayUtils.fetchNode(root, 0);
        ArrayUtils.printListNode(deleteNode(root, target));
    }
}

package com.github.jinsen47;

import com.github.jinsen47.model.ListNode;
import com.github.jinsen47.utils.ArrayUtils;

/**
 * Created by Jinsen on 16/4/9.
 */
public class FindLastK {
    public static ListNode findKthToTail(ListNode head,int k) {
        if (head == null) return null;
        if (k == 0) return null;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k-1 && first != null; i++) {
            first = first.next;
        }
        if (first == null) return null;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        ListNode root = ArrayUtils.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ArrayUtils.printListNode(findKthToTail(root, 6));
    }
}

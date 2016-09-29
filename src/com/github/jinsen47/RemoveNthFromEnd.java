package com.github.jinsen47;

import com.github.jinsen47.model.ListNode;
import com.github.jinsen47.utils.ArrayUtils;

/**
 * Created by Jinsen on 16/9/19.
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        ListNode second = head;
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        if (second.next != null) {
            second.next = second.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ArrayUtils.buildLinkedList(new int[]{1});
        ArrayUtils.printListNode(removeNthFromEnd(head, 1));
    }
}

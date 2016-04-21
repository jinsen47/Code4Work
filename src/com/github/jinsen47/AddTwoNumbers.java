package com.github.jinsen47;

import com.github.jinsen47.model.ListNode;

/**
 * Created by Jinsen on 15/12/23.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        ListNode temp = head;
        int addFlag = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            ListNode next = new ListNode(0);
            temp.val = (val1 + val2) % 10 + addFlag;
            addFlag = (val1 + val2) / 10;
            temp.next = next;
            prev = temp;
            temp = next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            }
        if (addFlag == 0) {
            prev.next = null;
            prev = null;
        } else {
            temp.val = addFlag;
        }
        return head;
    }
}

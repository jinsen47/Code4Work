package com.github.jinsen47;

import com.github.jinsen47.model.ListNode;
import com.github.jinsen47.utils.ArrayUtils;

/**
 * Created by Jinsen on 16/4/9.
 */
public class MergeSortedList {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode mergedList = null;
        if (list1.val > list2.val) {
            mergedList = list2;
            list2 = list2.next;
        } else {
            mergedList = list1;
            list1 = list1.next;
        }
        ListNode node = mergedList;

        while (list1 != null || list2 != null) {
            if(list1 == null) {
                node.next = list2;
                break;
            }
            if (list2 == null) {
                node.next = list1;
                break;
            }
            // 都不为空
            if (list1.val > list2.val) {
                node.next = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        return mergedList;
    }

    public static void main(String[] args) {
        ListNode list1 = ArrayUtils.buildLinkedList(new int[]{1,3,5});
        ListNode list2 = ArrayUtils.buildLinkedList(new int[]{2,4,6});
        ArrayUtils.printListNode(Merge(list1, list2));
    }
}

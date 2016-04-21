package com.github.jinsen47;

import com.github.jinsen47.model.ListNode;
import com.github.jinsen47.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created by Jinsen on 16/4/6.
 */
public class ReverseLinkedList {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return null;
        ArrayList<Integer> resultArray = new ArrayList<>();
        while (listNode != null) {
            resultArray.add(listNode.val);
            listNode = listNode.next;
        }
        reverseArray(resultArray);
        return resultArray;
    }

    public static void reverseArray(ArrayList<Integer> array) {
        int low = 0;
        int high = array.size() - 1;
        while (low < high) {
            int temp = array.get(low);
            array.set(low, array.get(high));
            array.set(high, temp);
            low++;
            high--;
        }
    }

    public static ArrayList<Integer> printListFromTailToHeadRecursivly(ListNode listNode) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        printNode(listNode, resultArray);
        return resultArray;
    }

    public static void printNode(ListNode node, ArrayList<Integer> array) {
        if (node == null) return;
        printNode(node.next, array);
        array.add(node.val);
    }

    public static void main(String[] args) {
        ListNode head = ArrayUtils.buildLinkedList(new int[]{58,0,24,12});
//        ArrayUtils.printArray(printListFromTailToHead(head));
        ArrayUtils.printArray(printListFromTailToHeadRecursivly(head));
    }
}

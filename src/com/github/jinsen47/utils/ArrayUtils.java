package com.github.jinsen47.utils;

import com.github.jinsen47.model.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jinsen on 15/11/6.
 */
public class ArrayUtils {
    public static void printArray(List<Integer> l) {
        for (Integer i : l) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printArray(long[] array) {
        for (long i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        // 记录上一趟最后交换的下标
        // 下次肯定在上一趟之前
        int lastSwapIndex = array.length;
        while (lastSwapIndex > 0) {
            int k = lastSwapIndex;
            lastSwapIndex = 0;
            for (int j = 1; j < k; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j-1);
                    lastSwapIndex = j;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            // 从后边的无序中找到最小的
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
            printArray(array);
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 后边每次拿一个和之前的相比, 如果小就冒上来
            for (int j = i; j >= 1; j--) {
                if (array[j-1] > array[j]) {
                    swap(array, j-1, j);
                }
            }
        }
    }

    public static void quicksort(int[] array, int begin, int end) {
        if (begin < end) {
            int q = partition(array, begin, end);
            quicksort(array, begin, q - 1);
            quicksort(array, q, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, end);
        return i+1;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }

    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    public static ListNode buildLinkedList(int[] array) {
        if (array == null || array.length == 0) return null;
        ListNode head = new ListNode(array[0]);
        ListNode tempNode = head;
        if (array.length < 2) return head;

        for (int i = 1; i < array.length; i++) {
            tempNode.next = new ListNode(array[i]);
            tempNode = tempNode.next;
        }
        return head;
    }

    public static ListNode fetchNode(ListNode root, int n) {
        if (n < 0) return null;
        ListNode node = root;
        for (int i = 0; i < n && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
//        int[] quickSortTestArray = {2,8,7,1,3,5,6,4};
//        quicksort(quickSortTestArray, 0, 7);
//        printArray(quickSortTestArray);
//        printListNode(buildLinkedList(new int[]{1, 2, 3, 4}));
//        ListNode root = buildLinkedList(new int[]{1, 2, 3, 4});
//        printListNode(fetchNode(root, 0));
        int[] array = {2,8,7,1,3,5,6,4};
//        bubbleSort(array);
//        selectionSort(array);
        insertSort(array);
        printArray(array);
        reverse(array);
        printArray(array);
    }

}

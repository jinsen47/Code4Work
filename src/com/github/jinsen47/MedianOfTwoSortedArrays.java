package com.github.jinsen47;

import com.github.jinsen47.utils.ArrayUtils;

/**
 * Created by Jinsen on 15/12/24.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            array[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            array[i + nums1.length] = nums2[i];
        }
        ArrayUtils.printArray(array);
        ArrayUtils.quicksort(array, 0, array.length - 1);
        if (array.length % 2 == 0) {
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0d;
        } else {
            return array[(array.length - 1) / 2];
        }
    }

    public static void main(String[] args) {
        int[] test1 = {0,1};
        int[] test2 = {2};
        System.out.println(findMedianSortedArrays(test1, test2));
    }
}

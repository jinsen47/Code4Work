package com.github.jinsen47;

/**
 * Created by Jinsen on 16/4/7.
 */
public class RotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (array[low] >= array[high]) {
            if (low + 1 == high) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;

            if (array[mid] == array[low] && array[low] == array[high]) {
                return min(array, low, high);
            }

            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]){
                high = mid;
            }
        }
        return array[mid];
    }

    public static int min(int[] array, int begin, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = begin; i <= end; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{1,1,1,3,1,1,1}));
    }
}

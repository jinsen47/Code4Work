package com.github.jinsen47;

import com.github.jinsen47.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jinsen on 16/4/17.
 */
public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> outList = new ArrayList<>();
        if (input.length == 0 || k <= 0) {
            return outList;
        }
        if (input.length <= k) {
            for (int i: input) outList.add(i);
            return outList;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
                index = partition(input, start, end);
            } else {
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            outList.add(input[i]);
        }
        return outList;
    }

    public static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if(array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        ArrayUtils.printArray(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 10));
    }
}

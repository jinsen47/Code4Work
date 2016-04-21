package com.github.jinsen47;

import com.github.jinsen47.utils.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Jinsen on 16/4/5.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        // 拿到倒数第一个没有保持降序的数字位置
        int reserveOrderLast = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] > nums[i - 1]) {
                reserveOrderLast = i - 1;
                break;
            }
        }
        if (reserveOrderLast != 0) {
            //进行对换, 排序
            int biggerThanReserveOrderLast = 0;
            for (int i = nums.length - 1; i > reserveOrderLast; i--) {
                if (nums[i] > nums[reserveOrderLast]) {
                    biggerThanReserveOrderLast = i;
                    break;
                }
            }
            ArrayUtils.swap(nums, biggerThanReserveOrderLast, reserveOrderLast);
            Arrays.sort(nums, reserveOrderLast + 1, nums.length);
        } else {
            //全部降序, 完全排序即可
            Arrays.sort(nums, 0, nums.length);
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,1,5,4,3,3,2,1};
        int[] test2 = new int[]{3,2,1};
        int[] test3 = new int[]{1,2};
        nextPermutation(test3);
        ArrayUtils.printArray(test3);
    }
}

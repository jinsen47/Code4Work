package com.github.jinsen47;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Jinsen on 16/9/13.
 */
public class FindGreatestSum {

    public static int findGreatestSum(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (sum < 0) {
                sum = i;
            } else {
                sum += i;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findGreatestSum(new int[]{-2,-8,-5,-1,-9}));
    }
}

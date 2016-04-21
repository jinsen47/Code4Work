package com.github.jinsen47;

import com.github.jinsen47.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinsen on 15/12/22.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // build a map with key = index, value = value
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;

    }

    public static void main(String[] args) {
        int[] arrsy = new int[]{4,4,4,7,11,15};
        int target = 8;
        ArrayUtils.printArray(twoSum(arrsy, target));
    }
}

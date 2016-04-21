package com.github.jinsen47;

import java.util.Arrays;

/**
 * Created by Jinsen on 16/3/29.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestTwoSum = nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            int twoSum = target - nums[i];
            while (lo < hi) {
                int tempSum = nums[lo] + nums[hi];
                if (Math.abs(closestTwoSum - twoSum) > Math.abs(twoSum - tempSum)) {
                    closestTwoSum = tempSum;
                }
                if (tempSum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
            if (Math.abs(target - closestSum) > Math.abs(target - closestTwoSum - nums[i])) {
                closestSum = closestTwoSum + nums[i];
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] {0,2,1,-3};
        System.out.println(threeSumClosest(test1, 1));
    }
}

package com.github.jinsen47;

/**
 * Created by Jinsen on 16/3/29.
 */
public class ContainsMostWater {
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int max = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int temp = (j - i) * (height[j] + height[i]) / 2;
                if (temp > max) temp = max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 1};
        System.out.println(maxArea(test1));
    }
}

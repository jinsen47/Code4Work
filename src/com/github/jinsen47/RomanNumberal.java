package com.github.jinsen47;

/**
 * Created by Jinsen on 15/11/11.
 */
public class RomanNumberal {
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        int[] nums = new int[array.length];
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            switch (array[i]) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
                default:
                    nums[i] = 0;
                    break;
            }
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1]) {
                res -= nums[i];
            } else {
                res += nums[i];
            }

        }
        res += nums[nums.length - 1];
        return res;
    }
    public static void main(String[] args) {
        String testcase = "DCXXI";
        System.out.println(new RomanNumberal().romanToInt(testcase));
    }
}

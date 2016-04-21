package com.github.jinsen47;

import java.util.Stack;

/**
 * Created by Jinsen on 16/1/8.
 */
public class String2Integer {
    public static int myAtoi(String str) {
        int offset = 0;
        int flag = 1;
        if (str == null || str.length() == 0) return 0;
        while (offset < str.length() && !(str.charAt(offset) == '+' || str.charAt(offset) == '-' || (str.charAt(offset) >= '0' && str.charAt(offset) <= '9'))) {
            offset++;
        }
        if (offset >= str.length()) return 0;
        if (str.charAt(offset) == '-') {
            flag = -1;
            offset++;
        } else if (str.charAt(offset) == '+') {
            flag = 1;
            offset++;
        }
        Stack<Integer> digits = new Stack<>();
        while (offset < str.length() && str.charAt(offset) >= '0' && str.charAt(offset) <= '9') {
            digits.push(str.charAt(offset) - '0');
            offset++;
        }
        long result = 0;
        for (int i = 0; !digits.isEmpty(); i++) {
            double tenPower = 0.0d;
            tenPower = Math.pow(10, i) * digits.pop();
            result += tenPower;
        }
        result *= flag;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return ((int) result);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("11228552307"));
    }
}

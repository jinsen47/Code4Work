package com.github.jinsen47;

import java.util.Stack;

/**
 * Created by Jinsen on 16/1/8.
 */
public class InverseInteger {
    public static int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        Stack<Integer> digits = new Stack<>();
        while(x > 0) {
            digits.push(x % 10);
            x = x / 10;
        }
        long result = 0;
        for (int i = 0; !digits.isEmpty(); i++) {
            double tenPower = 0.0d;
            tenPower = Math.pow(10, i) * digits.pop();
            result += tenPower;
        }
        if (result > Integer.MAX_VALUE) {
            result = 0;
        }
        return ((int) (result * flag));
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}

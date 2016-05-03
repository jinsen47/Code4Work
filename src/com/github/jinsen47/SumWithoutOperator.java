package com.github.jinsen47;

/**
 * Created by Jinsen on 16/5/3.
 */
public class SumWithoutOperator {
    public static int sum(int n) {
        int ret = 0;
        boolean ans = n == 0 || (ret = sum(n - 1)) > 0;
        return n + ret;
    }


    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}

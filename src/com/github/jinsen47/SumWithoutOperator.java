package com.github.jinsen47;

/**
 * Created by Jinsen on 16/5/3.
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
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

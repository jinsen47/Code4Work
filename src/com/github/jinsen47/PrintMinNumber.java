package com.github.jinsen47;

import java.util.*;

/**
 * Created by Jinsen on 16/4/23.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static String printMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>(numbers.length);
        for (int i: numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1+s2).compareTo(s2+s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i: list) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printMinNumber(new int[]{3,32,321}));
    }
}

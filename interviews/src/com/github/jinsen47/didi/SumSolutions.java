package com.github.jinsen47.didi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jinsen on 16/9/23.
 */
public class SumSolutions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = in.nextInt();
            in.nextLine();
//            Map<Integer, Integer> map = new HashMap<>();
            String[] line = in.nextLine().split(" ");
            int[] array = new int[n];
            int count = 0;
            for (String s : line) {
                int i = Integer.valueOf(s);
                array[count++] = i;
//                if (map.containsKey(i)) {
//                    map.put(i, map.get(i) + 1);
//                } else {
//                    map.put(i, 1);
//                }
            }
            findSum(sum, 0, new Stack<Integer>(), array);
        }
    }

    private static void findSum(int sum, int index, Stack<Integer> stack, int[] array) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            for (Integer i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        if (array[index] == sum) {
            stack.push(index);
            for (Integer i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            stack.pop();
            return;
        }
        if (array[index] > sum) {
            return;
        }
        stack.push(array[index]);
        sum -= array[index];
        for (int i = index + 1; i < array.length; i++) {
            findSum(sum, i, stack, array);
        }
        stack.pop();
    }
}

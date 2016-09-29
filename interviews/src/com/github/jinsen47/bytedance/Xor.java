package com.github.jinsen47.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Jinsen on 16/9/21.
 */
public class Xor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            Arrays.sort(array);
            int high = (int)Math.pow(2, Integer.toString(m, 2).length() + 1);
            int highIndex = array.length - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (array[i] <= high) {
                    highIndex = i;
                    break;
                }
            }
            for (int i = 0; i <= highIndex; i++) {
                for (int j = i+1; j <= highIndex; j++) {
                    set.add(array[i] ^ array[j]);
                }
            }
            int count = highIndex != array.length - 1 ? highIndex * (array.length - highIndex) : 0;
            for (int i : set) {
                if (i > m) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

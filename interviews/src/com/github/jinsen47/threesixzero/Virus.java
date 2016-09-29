package com.github.jinsen47.threesixzero;

import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/20.
 */
public class Virus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[513];
        for (int i = 0; i < 513; i++) {
            array[i] = i + 1;
        }
        while (in.hasNext()) {
            long input = System.currentTimeMillis();
            long n = in.nextLong();
            for (int i = 0; i < array.length; i++) {
                if (n - Long.valueOf(Integer.toString(array[i], 2)) < 0) {
                    System.out.println(i);
                    System.out.println(System.currentTimeMillis() - input);
                    break;
                }
            }
        }
    }
}

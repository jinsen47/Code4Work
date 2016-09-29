package com.github.jinsen47.didi;

import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/23.
 */
public class ConvertBase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = in.nextLong();
            int base = in.nextInt();
            System.out.println(Long.toString(n, base));
        }
    }
}

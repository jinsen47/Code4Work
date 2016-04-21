package com.github.jinsen47;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            solution(n, m, k);
        }
    }

    public static void solution(int n, int m, int k) {
        long[] array = new long[n * m];
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < m; j++) {
                long val = (i+1) * (j+1);
                long index = m * i + j;
                array[((int) index)] = val;
            }
        }
        Arrays.sort(array);
        System.out.println(array[k - 1]);

    }
}
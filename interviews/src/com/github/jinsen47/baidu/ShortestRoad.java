package com.github.jinsen47.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/20.
 */
public class ShortestRoad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int cases = in.nextInt();
            for (int caseNumber = 1; caseNumber <= cases; caseNumber++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
//                in.nextLine();

                int[][] matrix = new int[m][n];
                for (int i = 0; i < m; i++) {
                    Arrays.fill(matrix[i], Integer.MAX_VALUE);
                }
                for (int i = 0; i < m; i++) {
                    matrix[in.nextInt() - 1][in.nextInt() - 1] = in.nextInt();
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < Math.min(m, n); k++) {
                            if (matrix[i][j] != Integer.MAX_VALUE &&
                                    matrix[i][k] != Integer.MAX_VALUE &&
                                    matrix[k][j] != Integer.MAX_VALUE &&
                                    matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                                matrix[i][j] = matrix[i][k] + matrix[k][j];
                            }
                        }
                    }
                }
                System.out.println("Case #" + caseNumber + ":" + 0);
            }
        }
    }
}

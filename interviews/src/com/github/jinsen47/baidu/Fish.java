package com.github.jinsen47.baidu;

import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/20.
 * ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，而ss每分钟随机钓一个格子。问t分钟后他们谁至少钓到一条鱼的概率大？为多少？
 * 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 * 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)
 *
 * 输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)
 */
public class Fish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int t = in.nextInt();
            float[][] matrix = new float[n][m];
            float pSS = 0.0f;
            in.nextLine();
            for (int i = 0; i < n; i++) {
                String[] line = in.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Float.valueOf(line[j]);
                    pSS += matrix[i][j];
                }
            }
            pSS /= m*n;
            float pCC = matrix[x - 1][y - 1];

            String nPSS = String.format("%.2f", 1 - (float)Math.pow(1-pSS, t));
            String nPCC = String.format("%.2f", 1 - (float)Math.pow(1-pCC, t));

            if (Float.valueOf(nPSS) > Float.valueOf(nPCC)) {
                System.out.println("ss");
                System.out.println(nPSS);
            } else if (nPSS.equals(nPCC)) {
                System.out.println("equal");
                System.out.println(nPSS);
            } else {
                System.out.println("cc");
                System.out.println(nPSS);
            }
        }
    }
}

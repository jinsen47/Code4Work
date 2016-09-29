package com.github.jinsen47.yidianzixun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/22.
 * 奇怪的电梯
 * 一个楼有n层高
 * 电梯很奇怪, 在不同的层只能走固定的层, 每一层能走的层数由一个数组给出, 只能走该数的层数
 * 例如 第二层给出的数字为2, 只能走到第4层
 *
 * 输入第一行为3数字n, a, b, 层数, 开始的层, 到达的层
 * 第二行为 一个长度为n的数组, 表示每一层可以上下的层数
 *
 * 输出为 两行, 第一行为到达所走的次数, 第二行为从a->b经过的所有层, 如果不能到达, 输出-1
 * 测试用例输入:
 * 5 1 5
 * 3 3 1 2 5
 * 输出:
 * 3
 * 1 4 2 5
 */
public class StrangeLoft {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if (n <= 0 || a <= 0 || b <=0 || a > n || b > n ) {
                System.out.println("-1");
                continue;
            }
            int[] input = new int[n+1];
            for (int i = 1; i <= n; i++) {
                input[i] = in.nextInt();
            }
            nextMove(a, b, input, new ArrayList<Integer>());
        }
    }

    private static void nextMove(int curLevel, final int destLevel, final int[] input, List<Integer> traveledList) {
        if (curLevel == destLevel) {
            traveledList.add(curLevel);
            System.out.println(traveledList.size() - 1);
            for (int i : traveledList) {
                System.out.print(i + " ");
            }
            traveledList.remove(traveledList.size() - 1);
            return;
        }
        if (traveledList.contains(curLevel)) {
            System.out.println(-1);
        } else {
            int nextUp = curLevel + input[curLevel];
            int nextDown = curLevel - input[curLevel];
            traveledList.add(curLevel);
            if (nextUp < input.length) {
                nextMove(nextUp, destLevel, input, traveledList);
            }
            if (nextDown > 0) {
                nextMove(nextDown, destLevel, input, traveledList);
            }
            traveledList.remove(traveledList.size() - 1);
        }
    }
}

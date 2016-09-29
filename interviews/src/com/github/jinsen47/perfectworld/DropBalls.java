package com.github.jinsen47.perfectworld;

import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/28.
 */
public class DropBalls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//floors
            int m = in.nextInt();//eggs

            System.out.println(dropping(m, n));
        }
    }

    public static int dropping(int eggs, int floors) {
        int times = 1;
        while (droppingMaxFloor(eggs, times) < floors) {
            times++;
        }
        return times;
    }

    public static int droppingMaxFloor(int eggs, int times) {
        if (eggs == 1) {
            return times;
        }
        if (eggs >= times) {
            return (int)Math.pow(2, times) - 1;
        }
        return droppingMaxFloor(eggs, times - 1) + droppingMaxFloor(eggs - 1, times - 1) + 1;
    }
}

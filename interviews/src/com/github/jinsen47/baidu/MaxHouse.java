package com.github.jinsen47.baidu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinsen on 16/9/20.
 */
public class MaxHouse {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0,0,0}, {0,1,1,0,0}, {0,0,0,0,0}, {0,0,1,1,0}, {0,0,1,0,0}};
        bigHomes(grid);
    }

    public static int bigHomes(int[][] grid) {
        int caseNumber = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    findAHouse(i, j, grid, caseNumber++, map);
                }
            }
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
            }
        }
        System.out.println(max);
        return max;
    }

    public static void findAHouse(int x, int y, int[][] grid, int caseNumber, Map<Integer, Integer> map) {
        if (grid[x][y] != 1) return;
        grid[x][y] = 2;
        if (map.containsKey(caseNumber)) {
            map.put(caseNumber, map.get(caseNumber) + 1);
        } else {
            map.put(caseNumber, 1);
        }
        if (x - 1 >= 0) {
            findAHouse(x -1, y, grid, caseNumber, map);
        }
        if (x + 1 < grid.length) {
            findAHouse(x + 1, y, grid, caseNumber, map);
        }
        if (y - 1 >= 0) {
            findAHouse(x, y - 1, grid, caseNumber, map);
        }
        if (y + 1 < grid[0].length) {
            findAHouse(x, y + 1, grid, caseNumber, map);
        }
    }
}

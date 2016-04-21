package com.github.jinsen47;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinsen on 15/11/11.
 */
public class NQueens {
    //一维数组的下标表示横坐标,数组的值表示纵坐标
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] column = new int[n];
        nQueens(0, column, res);
        return res;
    }

    public void nQueens(int row, int[] column, List<List<String>> res) {
        int n = column.length;
        if(row == n) {
            res.add(draw(column));
            return;
        } else {
            for(int i = 0; i < n; i++) {
                column[row] = i;
                if(isValid(row, column)) {
                    nQueens(row+1, column, res);
                }
            }
        }
    }

    public ArrayList<String> draw(int[] column) {
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i < column.length; i++) {
            char[] line = new char[column.length];
            java.util.Arrays.fill(line, '.');
            line[column[i]] = 'Q';
            res.add(String.valueOf(line));
        }
        return res;
    }

    public boolean isValid(int row, int[] array) {
        for(int i = 0; i < row; i++) {
            if(array[row] == array[i] || Math.abs(array[row] - array[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}

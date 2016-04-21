package com.github.jinsen47;

import com.github.jinsen47.utils.ArrayUtils;

import java.util.*;

/**
 * Created by Jinsen on 16/4/20.
 */
public class Maze {
    // 迷宫算法
    // 有一个 n * n 矩阵
    // 0,1,2 分别表示可以走, 不能走, 得分
    // 给出初始坐标 (x, y) 算出能得的最大分数
    // 得过的分不能重新得

    private int[][] mMaze;
    private final int MAX_COL;
    private final int MAX_ROW;
    private int MAX_COUNT;
    public int mMaxScore;
    private Stack<Integer> mSteps = new Stack<>();
    private Stack<Point> mPoints = new Stack<>();

    private Point pStart;

    public Maze(int[][] mMaze, int maxCount, Point startPoint) {
        this.mMaze = mMaze;
        MAX_COL = mMaze.length;
        MAX_ROW = mMaze[0].length;
        this.MAX_COUNT = maxCount;
        this.pStart = startPoint;
    }

    private void start() {
        int count = 0;
        mPoints.push(pStart);
        mSteps.push(pStart.get(mMaze));
        visit(count);
    }

    private void visit(int count) {
        Point cur = mPoints.peek();
        int curVal = mSteps.peek();
        // 走过的部分清零
        mMaze[cur.x][cur.y] = 0;

        // 到达最大次数
        if (count >= MAX_COUNT) {
            List<Integer> list = new ArrayList<>(mSteps);
            int sum = getSum(list);
            if (sum > mMaxScore) {
                mMaxScore = sum;
            }
            return;
        }

        //        上 = 1
        //
        // 左 = 4          右 = 2
        //
        //        下 = 3
        //
        // 将方向和分数编码 例如: 2上 = 21
        // 如果编码 = 0 说明该方向不能走
        int[] directions = new int[4];

        if (cur.x + 1 < MAX_COL) {
            //右
            directions[1] = 2 + 10 * mMaze[cur.x + 1][cur.y];
        }
        if (cur.x - 1 >= 0) {
            //左
            directions[3] = 4 + 10 * mMaze[cur.x - 1][cur.y];
        }
        if (cur.y + 1 < MAX_ROW) {
            //下
            directions[2] = 3 + 10 * mMaze[cur.x][cur.y + 1];
        }
        if (cur.y - 1 >= 0) {
            //上
            directions[0] = 1 + 10 * mMaze[cur.x][cur.y - 1];
        }

        Arrays.sort(directions);
        ArrayUtils.reverse(directions);

        // 四周都是墙, 第一次进来出不去了
        if (directions[0] < 20 && directions[3] > 10) {
            mMaxScore = curVal;
            return;
        }

        for (int d: directions) {
            if (d == 0) break; // 过界了

            int direction = d % 10;
            int point = d / 10;
            if (point == 1) continue; //  这是墙
            Point pNext = null;
            switch (direction) {
                case 1: // 上
                    pNext = new Point(cur.x, cur.y - 1);
                    break;
                case 2: // 右
                    pNext = new Point(cur.x + 1, cur.y);
                    break;
                case 3: // 下
                    pNext = new Point(cur.x, cur.y + 1);
                    break;
                case 4: // 左
                    pNext = new Point(cur.x - 1, cur.y);
            }
            mPoints.push(pNext);
            mSteps.push(pNext.get(mMaze));
            visit(++count);
        }
        mPoints.pop();
        mMaze[cur.x][cur.y] = mSteps.pop();
        count--;
    }

    public static int getSum(List<Integer> l) {
        int sum = 0;
        for (Integer i: l) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mazeMatrix = new int[][]{
                {1,1,1,1,1},
                {1,2,1,2,1},
                {1,1,0,1,1},
                {1,2,1,0,1},
                {1,1,1,1,1}};
        Maze mazeSolution = new Maze(mazeMatrix, 8, new Point(1,3));
        mazeSolution.start();
        System.out.println(mazeSolution.mMaxScore);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int get(int[][] maze) {
            return maze[x][y];
        }
    }
}

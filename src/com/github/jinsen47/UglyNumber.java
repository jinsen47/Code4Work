package com.github.jinsen47;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Jinsen on 16/4/23.
 *
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

/**
 * 1）初始化array和队列：Q2 Q3 Q5
 * 2）将1插入array
 * 3）分别将1*2、1*3 、1*5插入Q2 Q3 Q5
 * 4)令x为Q2 Q3 Q5中的最小值，将x添加至array尾部
 * 5）若x存在于：
 * Q2：将 x * 2、x * 3、x*5 分别放入Q2 Q3 Q5，从Q2中移除x
 * Q3：将 x * 3、x*5 分别放入Q3 Q5，从Q3中移除x
 * Q5：将 x * 5放入Q5，从Q5中移除x
 * 6）重复步骤4~6，知道找到第k个元素
 */
public class UglyNumber {
    public static int getUglyNumber(int index) {
        if (index <= 0) return 0;
        int count = 1;
        Queue<Integer> q2 = new ArrayDeque<>();
        Queue<Integer> q3 = new ArrayDeque<>();
        Queue<Integer> q5 = new ArrayDeque<>();

        q2.add(2);
        q3.add(3);
        q5.add(5);
        int cur = 1;
        while (count < index) {
            int cur2 = q2.peek();
            int cur3 = q3.peek();
            int cur5 = q5.peek();
            cur = Math.min(Math.min(cur2, cur3), cur5);
            if (cur == cur2) {
                //来自q2
                q2.poll();
                q2.add(cur2 * 2);
                q3.add(cur2 * 3);
                q5.add(cur2 * 5);
            } else if (cur == cur3) {
                //来自q3
                q3.poll();
                q3.add(cur3 * 3);
                q5.add(cur3 * 5);
            } else {
                //来自q5
                q5.poll();
                q5.add(cur5 * 5);
            }
            count++;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(7));
    }
}

package com.github.jinsen47;

import java.util.Stack;

/**
 * Created by Jinsen on 16/4/10.
 */
public class StackPushSequence {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int pushIndex = 1;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        while(!stack.isEmpty() && popIndex < popA.length) {
            if (popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            } else {
                if (pushIndex < pushA.length) {
                    stack.push(pushA[pushIndex++]);
                } else {
                    return false;
                }

            }
        }
        if (stack.isEmpty() && popIndex == popA.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}

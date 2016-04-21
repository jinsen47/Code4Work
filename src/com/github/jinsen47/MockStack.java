package com.github.jinsen47;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jinsen on 16/4/20.
 */
public class MockStack {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int val) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(val);
            return;
        }
        if (!queue1.isEmpty()) {
            queue1.add(val);
        } else {
            queue2.add(val);
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        Queue<Integer> qOccupied;
        Queue<Integer> qEmpty;
        if (queue1.isEmpty()) {
            qEmpty = queue1;
            qOccupied = queue2;
        } else {
            qEmpty = queue2;
            qOccupied = queue1;
        }
        while (qOccupied.size() > 1) {
            qEmpty.add(qOccupied.poll());
        }
        return qOccupied.poll();
    }

    public static void main(String[] args) {
        MockStack mockStack = new MockStack();
        Stack<Integer> realStack = new Stack<>();

        for (int i = 1; i < 4; i++) {
            mockStack.push(i);
            realStack.push(i);
        }

        System.out.println(mockStack.pop());
        System.out.println(realStack.pop());

        System.out.println(mockStack.pop());
        System.out.println(realStack.pop());

        System.out.println(mockStack.pop());
        System.out.println(realStack.pop());

        System.out.println("test finish");

    }
}

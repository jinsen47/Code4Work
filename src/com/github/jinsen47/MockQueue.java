package com.github.jinsen47;

import java.util.Stack;

/**
 * Created by Jinsen on 16/4/7.
 */
public class MockQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        MockQueue queue = new MockQueue();
    }
}

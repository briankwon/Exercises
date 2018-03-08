package com.brian.AlgorithmTraining.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Q09TwoQueuesToStack {
    public static void main(String[] args) {
        MockStack stack = new MockStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class MockStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int num) {
        if (queue1.isEmpty()) {
            queue2.add(num);
        } else {
            queue1.add(num);
        }
    }

    public int peek() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }

            int temp = queue2.peek();
            queue1.add(queue2.poll());
            return temp;
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }

            int temp = queue1.peek();
            queue2.add(queue1.poll());
            return temp;
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }

            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }

            return queue1.poll();
        }
    }
}
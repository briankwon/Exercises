package com.brian.AlgorithmTraining.offer;

import java.util.Stack;

public class Q09TwoStacksToQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public Q09TwoStacksToQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int num) {
        stackPush.push(num);
    }

    public int poll() {
        //如果pop栈为空，将push栈中的元素全都压入pop中
       if (stackPop.isEmpty()) {
           while (!stackPush.isEmpty()) {
               stackPop.push(stackPush.pop());
           }
       }
       return stackPop.pop();
    }

    public int peek() {
        //如果pop栈为空，将push栈中的元素全都压入pop中
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }
}

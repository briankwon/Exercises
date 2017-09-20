package com.brian.test;

import java.util.Stack;

public class validParentheses {
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();

        if (s == null || s.length() == 0) {
            return false;
        }

        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            }

            if (c == '}') {
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
            }

            if (c == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.empty();
    }
    public static void main(String[] args) {
        System.out.println(isValidParentheses("]"));
    }

}

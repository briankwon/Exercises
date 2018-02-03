package com.brian.lintcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by briankwon on 2017/6/30.
 */
public class validParenthesis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String s;
        for (int i = 0; i < N; i++) {
            s = scan.next();
            if (isMatch(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    private static boolean isMatch(String s) {
        Stack<Character> sk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sk.push('(');
            }
            if (s.charAt(i) == ')') {
                if (!sk.isEmpty() && sk.pop() == '(')//如果sk为空的情况下收到close parenthesis，说明已经不合法
                    continue;
                else
                    return false;
            }
            if (s.charAt(i) == '[') {
                sk.push('[');
            }
            if (s.charAt(i) == ']') {
                if (!sk.isEmpty() && sk.pop() == '[')
                    continue;
                else
                    return false;
            }
            if (s.charAt(i) == '{') {
                sk.push('{');
            }
            if (s.charAt(i) == '}') {
                if (!sk.isEmpty() && sk.pop() == '{')
                    continue;
                else
                    return false;
            }
        }
        if (sk.isEmpty())
            return true;
        else
            return false;
    }
}

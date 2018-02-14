package com.brian.AlgorithmTraining.VII;

//打印n层汉诺塔从最左边移动到最右边的全部过程
public class hanoi {
    public static void process(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move " + "1 from " + from + " to " + to);
        } else {
            process(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            process(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        process(n, "left", "right", "middle");
    }
}

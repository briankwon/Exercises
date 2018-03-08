package com.brian.AlgorithmTraining.offer;

/**
 * 用Fib(n)表示青蛙跳上n阶台阶的跳法数，青蛙一次性跳上n阶台阶的跳法数1(n阶跳)，设定Fib(0) = 1；
 当n = 1 时， 只有一种跳法，即1阶跳：Fib(1) = 1;
 当n = 2 时， 有两种跳的方式，一阶跳和二阶跳：Fib(2) = Fib(1) + Fib(0) = 2;
 当n = 3 时，有三种跳的方式，第一次跳出一阶后，后面还有Fib(3-1)中跳法； 第一次跳出二阶后，后面还有Fib(3-2)中跳法；第一次跳出三阶后，后面还有Fib(3-3)中跳法
 Fib(3) = Fib(2) + Fib(1)+Fib(0)=4;
 当n = n 时，共有n种跳的方式，第一次跳出一阶后，后面还有Fib(n-1)中跳法； 第一次跳出二阶后，后面还有Fib(n-2)中跳法..........................第一次跳出n阶后，后面还有 Fib(n-n)中跳法.
 Fib(n) = Fib(n-1)+Fib(n-2)+Fib(n-3)+..........+Fib(n-n)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-1)
 又因为Fib(n-1)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
 两式相减得：Fib(n)-Fib(n-1)=Fib(n-1)         =====》  Fib(n) = 2*Fib(n-1)     n >= 2
 */
public class Q10FreakJump {
    public static void main(String[] args) {
        System.out.println(jump(100));
        System.out.println(jump2(10));
        System.out.println(jumpFloorII(10));
    }

    private static int jump(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return 2 * jump(n - 1);
        }
    }

    private static int jump2(int number) {
        if (number == 0){
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= number; i++){
            sum += jump2(number - i);
        }
        return sum;
    }

    private static int jumpFloorII(int target) {

        if (target <= 0) {
            return target;
        }
        // 数学归纳法可以得到f(n)=2^(n-1)
        return (int) Math.pow(2, target - 1);
    }
}

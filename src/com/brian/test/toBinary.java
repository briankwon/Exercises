package com.brian.test;

public class toBinary {
    private static int n = 78;
    public static void main(String[] args) {
        int count = countBit(n);
        int k = n + 1;
        System.out.println(countBit(k));
        while (countBit(k) != count) {
            k++;
        }
        System.out.println(k);
    }

    private static int countBit(int num){
        int count = 0;
        for(; num > 0; count++)
        {
            num &= (num - 1);
        }
        return count;
    }

}

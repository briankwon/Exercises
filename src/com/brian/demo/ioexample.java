package com.brian.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by briankwon on 2017/4/5.
 */
public class ioexample {
    public static void checkInput(int input) {
        if (input <= 0) {
            System.out.println("输入值小于等于0");
            System.exit(input);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int serveTimes = 0;
        int unitPrice = 0;
        int amount = 0;
        ioexample x = new ioexample();
        System.out.println("输入顾客数量");
        serveTimes = Integer.parseInt(reader.readLine());
        checkInput(serveTimes);
        for (int i = 0; i < serveTimes; i++) {
            System.out.println("输入商品价格");
            unitPrice = Integer.parseInt(reader.readLine());
            checkInput(unitPrice);
            System.out.println("输入商品数量");
            amount = Integer.parseInt(reader.readLine());
            checkInput(amount);


        }

    }



}

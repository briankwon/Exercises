package com.brian.test;

import java.util.*;
public class jd3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            deal(num);
        }
    }
    public static void deal(int num){
        int sum=0;
        int kind =num-2;
        for(int i=2;i<num;i++){
            sum+=fun2(num,i);
        }
        int con =fun(sum,kind);
        System.out.println(sum/con+"/"+kind/con);
    }
    //一个数字按不同进制的各个位加和
    public static int fun2(int num,int x){
        int res=0;
        while(num!=0){
            res+=num%x;
            num/=x;
        }
        return res;
    }
    //求出最大公约数
    public static int fun(int a, int b){
        while(a%b!=0){
            int c =a%b;
            a=b;
            b=c;
        }
        return b;
    }
}

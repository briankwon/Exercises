package com.brian.AlgorithmTraining.haikang;

public class test {
    public static void main(String[] args) {
        String prefix = "A-B-C-";
        System.out.println("index = " + prefix.indexOf("A-"));
        System.out.println(prefix.substring(0, prefix.indexOf("A-") + 2));
    }
}

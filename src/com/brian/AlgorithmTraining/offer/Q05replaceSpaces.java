package com.brian.AlgorithmTraining.offer;

public class Q05replaceSpaces {
    public static void main(String[] args) {
        System.out.println(process("I am brian kwon"));
    }

    private static String process(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }
}

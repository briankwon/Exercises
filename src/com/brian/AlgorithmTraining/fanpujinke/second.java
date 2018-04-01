package com.brian.AlgorithmTraining.fanpujinke;

import java.util.Scanner;

public class second {
    public static String plusOne(String str) {
        char[] num = new StringBuffer(str).reverse().toString().toCharArray();
        int[] result = new int[num.length + 1];

        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                result[i] = Integer.parseInt(String.valueOf(num[i])) + 1;
            } else {
                result[i] = Integer.parseInt(String.valueOf(num[i]));
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        StringBuffer sb = new StringBuffer();

        if (result[result.length - 1] != 0) {
            sb.append(result[result.length - 1]);
        }

        for (int i = result.length - 2; i >= 0; i--) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static int compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 0;
        }

        if (s2.length() > s1.length()) {
            return 1;
        }

        int len = s1.length();

        for (int i = len - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
            int n2 = Integer.parseInt(String.valueOf(s2.charAt(i)));

            if (n1 > n2) {
                return 0;
            }

            if (n2 > n1) {
                return 1;
            }
        }

        return -1;
    }

    public static String getX(String str, String x) {
        String res = str;

        for (int i = 0; i < x.length(); i++) {
            res = sub(res, x.substring(i, i + 1));
        }

        return res;
    }

    public static String sub(String str, String n) {
        int[] result = new int[str.length()];
        char[] c = new StringBuffer(str).reverse().toString().toCharArray();
        result[0] = Integer.valueOf(String.valueOf(c[0])) - Integer.valueOf(n);

        for (int i = 1; i < result.length; i++) {
            result[i] = Integer.valueOf(String.valueOf(c[i]));
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();

        if (result[result.length - 1] != 0) {
            sb.append(result[result.length - 1]);
        }

        for (int i = result.length - 2; i >= 0; i--) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(plusOne("19"));
        System.out.println(plusOne("123"));
        System.out.println(sub("123","5"));
        System.out.println(sub("123","123"));
        System.out.println(getX("123","123"));

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        boolean flag = true;
        String x = plusOne(num);

        while (flag) {
            String temp = x;
            String cache = getX(temp, temp);
            int res = compare(cache, num);

            if (res <= 0) {
                flag = false;
                System.out.println(temp);
            }

            x = plusOne(x);
        }
    }
}

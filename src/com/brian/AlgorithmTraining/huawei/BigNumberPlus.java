package com.brian.AlgorithmTraining.huawei;

public class BigNumberPlus {
    public static void main(String[] args) {
        String n1 = "123456789";
        String n2 = "321654189416551";
        plus(n1, n2);
    }

    public static void plus(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            System.out.println("error");
            return;
        }

        char[] c1 = new StringBuffer(s1).reverse().toString().toCharArray();
        char[] c2 = new StringBuffer(s2).reverse().toString().toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;
        int l = l1 > l2 ? l1 : l2;
        int[] res = new int[l + 1];

        for (int i = 0; i < l + 1; i++) {
            int n1 = i < l1 ? c1[i] - '0' : 0;
            int n2 = i < l2 ? c2[i] - '0' : 0;
            res[i] = n1 + n2;
        }

        for (int i = 0; i < l + 1; i++) {
            if (res[i] >= 10) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        boolean flag = true;

        for (int i = l; i >= 0; i--) {
            if (res[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(res[i]);
        }

        System.out.println(sb.toString());
    }
}

package com.brian.AlgorithmTraining.II;

/**
 * 求最长回文子串的长度
 */
public class Manacher {
    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < charArr.length; i++) {
            //pR > i来看i是否在R之内，i' = index * 2 - i
            //pR - i是i可能的回文半径之一
            //对于i来讲，它的回文半径应该是pArr[i']和pR - i中较小的那一个
            //考虑一下情况
            //|Y[ab c baY| k Yab c ba]D
            //      i'     c     i
            //很明显pArr[i']比pArr[i]要大，因此pArr[i]只能是pArr[i']和pR - i中较小的一个
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;

            //i在pR的外侧，需要暴力扩展
            //另外pArr[i]正好卡在R上，这种情况时也需要进行暴力扩展
            //另外还有pArr[i']在左边界之内的情况，这时pArr[i]也是pArr[i']
            //虽然不需要暴力扩展不过走下面的过程不会提高时间复杂度，会在第一个if语句就break掉
            while (i + pArr[i] < charArr.length && i - pArr[i] >= 0) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }

            max = Math.max(max, pArr[i]);
        }
        //字符串已经用#处理过了，因此最长回文半径长度 - 1就是原始字符串最长回文子串的长度
        return max - 1;
    }

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}

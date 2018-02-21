package com.brian.test;

public class wordCount {
    public static void main(String[] args) {
        String s = "  i    come from     china  ";
        int r = wordCount(s);
        System.out.println(r);
    }

    //返回str中代表的单词个数
    public static int wordCount(String str){
        int count = 0;
        boolean isWhiteSpace = true;//标记当前是否处在"空格"模式

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //  int c = str.charAt(i);
            if(c == ' ' || c == '\t' || c == '\n') {//如果碰到的是分隔符,else语句不会执行
            //ASCII码值，a - z = 97 - 122, A - Z = 65 - 90
            //if (c < 65 || (90 < c && c < 97) || c > 122) {
                isWhiteSpace = true;
            } else if(isWhiteSpace) {//当碰到非分隔符,刚好且 处在 "空格"模式时,单词计数加1
                count++;
                isWhiteSpace = false;
            }
        }

        return count;
    }
}

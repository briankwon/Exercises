package com.brian.AlgorithmTraining.offer;

public class Q17PrintFrom1ToNBit {
//    public static void main(String[] args) {
//        int n = 2;
//        //processBad(n);
//    }

    private static void processBad(int n) {
        int num = 1;

        for (int i = 1; i <= n; i++) {
            num *= 10;
        }

        for (int i = 1; i <num; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits_2(20);
    }

    public static void Print1ToMaxOfNDigits_2(int n){

        if(n <= 0){
            return;
        }
        StringBuffer number = new StringBuffer();

        for(int i = 0; i < n; i++){
            number.append('0');

        }

        while(!Increment(number)){
            PrintNumber(number);
        }
    }

    /**
     * 加1操作，从低位开始+1+carry，如果小于10，直接加1后break;
     * 如果大于10，则改位为+sum-10的值，置carry=1；如果最高位的值大于10，则说明溢出了，停止打印。
     * @param s
     * @return
     */
    public static boolean Increment(StringBuffer s){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for(int i = nLength - 1; i >= 0; i--){
            int nSum = s.charAt(i) - '0' + nTakeOver;//得到对应位置的数 + carry。需要 - '0'防止变成字符串拼接
            if( i == nLength - 1){//只有是最后一位时+1
                nSum++;
            }
            if(nSum >= 10){//如果数字>=10要进位
                if(i == 0){//如果i == 0说明在最开始的一个位置要进位了，会溢出
                    isOverflow = true;
                }else{
                    nSum -= 10;//将对应位置的数字-10来表示归零
                    nTakeOver = 1;//carry设置为1
                    s.setCharAt(i, (char) ('0' + nSum));//当前位置设置为0
                }

            }else{
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    public static void PrintNumber(StringBuffer s){
        boolean isBeginning0 = true;
        for(int i = 0; i < s.length(); i++){
            //遇到第一个不为‘0’的字符开始打印
            if(isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }
}

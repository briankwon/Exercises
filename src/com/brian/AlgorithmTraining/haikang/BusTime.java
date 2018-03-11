package com.brian.AlgorithmTraining.haikang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class BusTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(",");
            int interval = 15;
            int stopNum = Integer.valueOf(strs[0]);

            if (stopNum < 3) {
                System.out.println("incorrect data");
                continue;
            }

            Date start, end;
            DateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                start = st.parse(strs[1]);
                end = st.parse(strs[2]);

                long diff = (end.getTime() - start.getTime()) / (1000 * 60); //得到间隔的分钟数

                if (diff < 0) {
                    System.out.println("incorrect data");
                    continue;
                }

                long circles = diff / (interval * stopNum) + 1;
                long restTime = diff % (interval * stopNum);
                long M = restTime / interval;
                long N = restTime % interval;

                //System.out.print(circles + ";");

//                if (N >= 0 && N <= 5) {
//                    System.out.println((circles + ";" + M % stopNum + 1) + "-" + (M % stopNum + 1));
//                } else {
//                    System.out.println(circles + ";" + (M % stopNum + 1) + "-" + (M % stopNum + 2) % stopNum);
//                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}

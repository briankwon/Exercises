package com.brian.JDK8;

import java.time.*;
import java.util.Calendar;

/**
 * @author: quan.chunyi
 * @date: 2018/8/16 下午7:38
 */
public class time {
    public static void main(String[] args) {
        System.out.println("LocalDate");
        LocalDate localDate = LocalDate.of(2018, 8, 16);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.lengthOfMonth());
        System.out.println(localDate.lengthOfYear());
        System.out.println(localDate.isLeapYear());

        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        System.out.println("LocalTime");
        LocalTime localTime = LocalTime.of(19, 41, 32);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

        System.out.println("--------------");
        LocalTime lt24 = LocalTime.now().minusHours(24);
        System.out.println(lt24);

        System.out.println("LocalDateTime");
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);
        localDateTime = localTime.atDate(localDate);
        System.out.println(localDateTime);

        System.out.println("Instant");
        Instant instant = Instant.now();
        System.out.println(instant);
        instant = Instant.ofEpochSecond(1534391618);
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());

        Instant ins = instant.minus(Duration.ofHours(24));
        System.out.println(ins);
        System.out.println(ins.getEpochSecond());
        System.out.println(instant.minus(Duration.ofHours(24)).getEpochSecond());

        Calendar c = Calendar.getInstance();
        System.out.println(c);
    }
}

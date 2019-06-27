package com.xiaode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by liyangde on May, 2019
 */
public class DateTest {
    public static void main(String[] args) throws ParseException
    {
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = new GregorianCalendar(2019, 04, 30);
        format.setCalendar(c);
        String str=format.format(c.getTime());
        System.out.println(str);
        Date d2=format.parse(str);
        LocalDate d3 = d2.toInstant()
                .plus(1, ChronoUnit.DAYS)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        System.out.println(d3.getDayOfMonth());
        /////////////////得到想要测试的时间整天


        int dayMis=1000*60*60*24;//一天的毫秒-1
        System.out.println("一天的毫秒-1:"+dayMis);

        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long curMillisecond=d2.getTime();//当天的毫秒
        System.out.println("curMillisecond:"+new Date(curMillisecond));

        long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
        System.out.println("resultMis:"+resultMis);

        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //得到我需要的时间    当天最后一秒
        Date resultDate=new Date(resultMis);
        System.out.println("resultDate:"+resultDate);
        System.out.println("FormatResult:"+format2.format(resultDate));

    }
}




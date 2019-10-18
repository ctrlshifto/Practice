package com.localdate;

        import java.time.LocalDate;
        import java.time.Month;
        import java.time.ZoneId;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/6/28 16:37
 */
public class LocalDateExample {
    public static void main(String[] args) {

        // 当前日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期=" + today);

        // 通过传入的参数创建LocalDate对象
        LocalDate firstday2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("指定日期=" + firstday2014);

        // 获取不同时区的日期 "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("当前印度标准日期=" + todayKolkata);

        // 从基准日期获取日期  例如： 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("基准日期的第365天= " + dateFromBase);

        //2014年的第一百天
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("2014年的第一百天=" + hundredDay2014);
    }
}

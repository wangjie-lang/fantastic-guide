package com.dataStructure;



public class Time {
    private final int baseYear = 1970;
    private final int leapYearDays = 366;
    private final int unLeapYearDays = 365;
    private final long dayMilis  = 86400000;
    private final long currentHourMilis = 3600000;
    private final long currentMinutesuteMilis = 60000;


    private final long secMilis = 1000;

    private final int[]  yearMonthDays={31,28,31,30,31,30,31,31,30,31,30,31};

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;

    public static void main(String[] args) {
        Time t = new Time();
        t.getCurrentTime(System.currentTimeMillis());

    }

    private void getCurrentTime(long t){
        int startYear = baseYear;
        int currentYear = baseYear;
        long yearMilis = isLeapYear(startYear)?leapYearDays*dayMilis:unLeapYearDays*dayMilis;
        //精确到年
        while (t>=yearMilis){
            t-=yearMilis;
            currentYear++;
            yearMilis = isLeapYear(++startYear)?leapYearDays*dayMilis:unLeapYearDays*dayMilis;
        }
        year = currentYear;
        if(isLeapYear(currentYear)){
            yearMonthDays[1]++;//闰月
        }
        int currentMonth = 1;
        //精确到月
        while (t>=yearMonthDays[currentMonth-1]*dayMilis){
            t-=yearMonthDays[currentMonth++-1]*dayMilis;
        }
        month = currentMonth;
        //精确到日
        int currentDay = 1;
        while (t>=dayMilis){
            t-=dayMilis;
            currentDay++;
        }
        day = currentDay;
        //精确到小时
        t+=8*currentHourMilis;//将UTC格林威治时间+8小时转化为北京时间
        int currentHour = 0;
        while (t>=currentHourMilis){
            t-=currentHourMilis;
            currentHour++;
        }
        hour = currentHour;
        //精确到分钟
        int currentMinutes = 0;
        while (t>=currentMinutesuteMilis){
            t-=currentMinutesuteMilis;
            currentMinutes++;
        }
        minute = currentMinutes;
        //精确到秒
        int sec = 0;
        while (t>=secMilis){
            t-=secMilis;
            sec++;
        }
        seconds = sec;
        //System.out.println("Now is:"+currentYear+"/"+currentMonth+"/"+currentDay+" "+currentHour+":"+ currentMinutes+":"+sec);
    }
    private boolean isLeapYear(int year){
        return (year%4==0&&year%100!=0)||year%400==0;
    }





    public int getYear() {
        getCurrentTime(System.currentTimeMillis());
        return year;
    }

    public int getMonth() {
        getCurrentTime(System.currentTimeMillis());
        return month;
    }

    public int getDay() {
        getCurrentTime(System.currentTimeMillis());
        return day;
    }

    public int getHour() {
        getCurrentTime(System.currentTimeMillis());
        return hour;
    }

    public int getMinute() {
        getCurrentTime(System.currentTimeMillis());
        return minute;
    }

    public int getSeconds() {
        getCurrentTime(System.currentTimeMillis());
        return seconds;
    }
    public String getTime(){
        getCurrentTime(System.currentTimeMillis());
        return year+"/"+month+"/"+day+" "+hour+":"+ minute+":"+seconds;
    }
}

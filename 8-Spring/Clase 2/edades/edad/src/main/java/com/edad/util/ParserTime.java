package com.edad.util;

public class ParserTime {
    public static double milliSecondsToYears(long milliSeconds){
        double toSecond = 1000;
        double toMinute = 60;
        double toHour = 60;
        double toDay = 24;
        double toYear = 365;

        return milliSeconds/(toSecond*toMinute*toHour*toDay*toYear);
    }
}

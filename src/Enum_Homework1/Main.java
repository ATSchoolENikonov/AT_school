package Enum_Homework1;

import static Enum_Homework1.DaysOfWeek.*;



public class Main {
    public static void main(String[] args) {
        Week week2 = new Week();
        week2.day1.setDayOfWeek(MONDAY);
        week2.day1.setCountMonth(3);
        week2.day2.setDayOfWeek(TUESDAY);
        week2.day2.setCountMonth(4);
        week2.day3.setDayOfWeek(WEDNESDAY);
        week2.day3.setCountMonth(5);
        week2.day4.setDayOfWeek(THURSDAY);
        week2.day4.setCountMonth(6);
        week2.day5.setDayOfWeek(FRIDAY);
        week2.day5.setCountMonth(7);
        week2.day6.setDayOfWeek(SATURDAY);
        week2.day6.setCountMonth(8);
        week2.day7.setDayOfWeek(SUNDAY);
        week2.day7.setCountMonth(9);
        week2.countYear = 2;
        System.out.println(week2);
        Week week10 = new Week();
        week10.day1.setDayOfWeek(MONDAY);
        week10.day1.setCountMonth(5);
        week10.day2.setDayOfWeek(TUESDAY);
        week10.day2.setCountMonth(6);
        week10.day3.setDayOfWeek(WEDNESDAY);
        week10.day3.setCountMonth(7);
        week10.day4.setDayOfWeek(THURSDAY);
        week10.day4.setCountMonth(8);
        week10.day5.setDayOfWeek(FRIDAY);
        week10.day5.setCountMonth(9);
        week10.day6.setDayOfWeek(SATURDAY);
        week10.day6.setCountMonth(10);
        week10.day7.setDayOfWeek(SUNDAY);
        week10.day7.setCountMonth(11);
        week10.countYear = 10;
        System.out.println(week10);
        Week week15 = new Week();
        week15.day1.setDayOfWeek(MONDAY);
        week15.day1.setCountMonth(22);
        week15.day2.setDayOfWeek(TUESDAY);
        week15.day2.setCountMonth(23);
        week15.day3.setDayOfWeek(WEDNESDAY);
        week15.day3.setCountMonth(24);
        week15.day4.setDayOfWeek(THURSDAY);
        week15.day4.setCountMonth(25);
        week15.day5.setDayOfWeek(FRIDAY);
        week15.day5.setCountMonth(26);
        week15.day6.setDayOfWeek(SATURDAY);
        week15.day6.setCountMonth(27);
        week15.day7.setDayOfWeek(SUNDAY);
        week15.day7.setCountMonth(128);
        week15.countYear = 15;
        System.out.println(week15);

    }
}

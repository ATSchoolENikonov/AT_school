package Enum_Homework1;

import static Enum_Homework1.DaysOfWeek.*;



public class Main {
    public static void main(String[] args) {
        Week week3 = new Week();
        week3.day1.setDayOfWeek(MONDAY);
        week3.day1.setCountMonth(3);
        week3.day2.setDayOfWeek(TUESDAY);
        week3.day2.setCountMonth(4);
        week3.day3.setDayOfWeek(WEDNESDAY);
        week3.day3.setCountMonth(5);
        week3.day4.setDayOfWeek(THURSDAY);
        week3.day4.setCountMonth(6);
        week3.day5.setDayOfWeek(FRIDAY);
        week3.day5.setCountMonth(7);
        week3.day6.setDayOfWeek(SATURDAY);
        week3.day6.setCountMonth(8);
        week3.day7.setDayOfWeek(SUNDAY);
        week3.day7.setCountMonth(9);
        week3.countYear = 3;
        System.out.println(week3);
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

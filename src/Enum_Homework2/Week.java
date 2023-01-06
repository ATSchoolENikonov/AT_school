package Enum_Homework2;

public class Week {
    Day day1 = new Day();
    Day day2 = new Day();
    Day day3 = new Day();
    Day day4 = new Day();
    Day day5 = new Day();
    Day day6 = new Day();
    Day day7 = new Day();
    int countYear;

    public Week(int mon, int tue, int wed, int th, int fri, int sat, int sun, int countYear) {
        this.day1.setDayOfWeek(DaysOfWeek.MONDAY);
        this.day1.setCountMonth(mon);
        this.day2.setDayOfWeek(DaysOfWeek.TUESDAY);
        this.day2.setCountMonth(tue);
        this.day3.setDayOfWeek(DaysOfWeek.WEDNESDAY);
        this.day3.setCountMonth(wed);
        this.day4.setDayOfWeek(DaysOfWeek.THURSDAY);
        this.day4.setCountMonth(th);
        this.day5.setDayOfWeek(DaysOfWeek.FRIDAY);
        this.day5.setCountMonth(fri);
        this.day6.setDayOfWeek(DaysOfWeek.SATURDAY);
        this.day6.setCountMonth(sat);
        this.day7.setDayOfWeek(DaysOfWeek.SUNDAY);
        this.day7.setCountMonth(sun);

        this.countYear = countYear;
    }

    @Override
    public String toString() {
        return "Неделя ["+countYear+ "] :\n" +
                day1 + "\n" +
                day2 + "\n" +
                day3 + "\n" +
                day4 + "\n" +
                day5 + "\n" +
                day6 + "\n" +
                day7 + "\n"
                ;
    }
}

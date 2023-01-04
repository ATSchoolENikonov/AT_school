package Enum_Homework1;

public class Day {
    private String dayOfWeek;
    private int countMonth;

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
    }

    @Override
    public String toString() {
        return dayOfWeek + " " + countMonth + " число";
    }
}

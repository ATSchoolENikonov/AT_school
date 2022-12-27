package Enum_Homework2;

public class Day {
    private DaysOfWeek dayOfWeek;
    private int countMonth;

    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
    }

    @Override
    public String toString() {
        return
                dayOfWeek + " " +
                        countMonth + " число"
                ;
    }
}


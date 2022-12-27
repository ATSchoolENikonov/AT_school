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

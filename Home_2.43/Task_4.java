public class Task_4 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]);
        Integer b = Integer.valueOf(args[1]);
        Integer c = Integer.valueOf(args[2]);
        int maxSide = 0;
        int firstSide = 0;
        int secondSide = 0;
        /**
         * Условия задания 4.В данной реализации вариант impossible действительно impossible to reach
         */
        if (c > a && c > b) {
            maxSide = c;
            firstSide = a;
            secondSide = b;
        } else if (b > a) {
            maxSide = b;
            firstSide = a;
            secondSide = c;
        } else {
            maxSide = a;
            firstSide = b;
            secondSide = c;
        }
        if ((a + b) > c && (b + c) > a && (a + c) > b) {
            if (maxSide * maxSide == (firstSide * firstSide + secondSide * secondSide)) {
                System.out.println("right");
            } else if (maxSide * maxSide < (firstSide * firstSide + secondSide * secondSide)) {
                System.out.println("acute");
            } else if (maxSide * maxSide > (firstSide * firstSide + secondSide * secondSide)) {
                System.out.println("obtuse");
            }
        } else {
            System.out.println("impossible");
        }
    }
}

public class Task_2 {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(args[0]);
        if (x > 0 && x < 8) {
            System.out.println("There is mistake");
            return;
        }
            switch (x) {
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
            }
        }
    }


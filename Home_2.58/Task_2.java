public class Task_2 {
    public static void main(String[] args) {
        int maxLenght = 0;

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                if ((args[i].charAt(j) < '0' || args[i].charAt(j) > '9') && (args[i].charAt(j) < 'a' || args[i].charAt(j) > 'z')) {
                    System.out.println("Введены некорректные символы");
                    System.exit(12);
                }
            }

        }
        if (args.length == 0) {
            System.out.println("Не заполнены входные параметры");
            System.exit(11);
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].length() > maxLenght) {
                maxLenght = args[i].length();
            }
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() == maxLenght) {
                System.out.print(args[i] + " ");
            }
        }

    }
}


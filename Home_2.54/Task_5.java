public class Task_5 {
    static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        if (isInteger(args[0])) {
            System.out.println("Строка является целым числом");
        } else
            System.out.println("Строка не является целым числом");
    }
}

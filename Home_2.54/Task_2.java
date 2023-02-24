public class Task_2 {
    public static void main(String[] args) {
        String str = args[0];
        for (int i = 1; i < args.length; i++) {
            str += " " + args[i];
        }
        if (str.endsWith("/") || str.endsWith("\\")) {
            System.out.println("Введен некорректный путь до файла.");
            System.exit(22);
        }
        if (str.contains("/")) {
            printSlash(str, "/");
        } else {
            printSlash(str, "\\");
        }
    }

    static void printSlash(String str, String slash) {
        System.out.println("Путь: " + str.substring(0, str.lastIndexOf(slash) + 1));
        System.out.println("Имя файла: " + str.substring(str.lastIndexOf(slash) + 1));
    }
}

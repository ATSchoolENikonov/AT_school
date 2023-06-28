public class Task_2 {
    public static String strVivod(String[] str) {
        String strAn = str[0];
        for (int i = 1; i < str.length; i++) {
            strAn += " " + str[i];
        }
        if (strAn.endsWith("/") || strAn.endsWith("\\")) {
            System.out.println("Введен некорректный путь до файла.");
            System.exit(22);
        }
        if (strAn.contains("/")) {
            return printSlash(strAn, "/");
        } else {
            return printSlash(strAn, "\\");
        }
    }

    public static void main(String[] args) {
        System.out.println(strVivod(args));
    }

    static String printSlash(String str, String slash) {
        return ("Путь: " + str.substring(0, str.lastIndexOf(slash) + 1) + "\n" +
                "Название файла: " + str.substring(str.lastIndexOf(slash) + 1));
    }
}

public class Task_1 {
    public static String str = "Циклом называется многократное выполнение одних и тех же действий.";

    public static void main(String[] args) {
        int a = str.indexOf(args[0]);
        System.out.println(str.substring(0, a).replace(" ", "").length());
    }


}

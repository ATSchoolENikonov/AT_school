public class Task_4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(args[0]);
        for (int i = 0; i < sb.length(); i++) {
            if (!(sb.charAt(i) > '0' && sb.charAt(i) < '9')) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(sb);
    }
}

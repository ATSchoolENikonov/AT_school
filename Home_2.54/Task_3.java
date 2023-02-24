public class Task_3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(args[0]);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.insert(i, "1");
                sb.deleteCharAt(i + 1);
            } else if (sb.charAt(i) == '1') {
                sb.insert(i, "0");
                sb.deleteCharAt(i + 1);
            }
        }
        System.out.println(sb);
    }

}

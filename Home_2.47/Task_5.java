
public class Task_5 {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(args[0]);
        Integer y = Integer.valueOf(args[2]);
        String sign = args[1];
        switch (sign) {
            case "+":
                System.out.println(Calculator.add(x, y));
                break;
            case "-":
                System.out.println(Calculator.sub(x, y));
                break;
            case "*":
                System.out.println(Calculator.multi(x, y));
                break;
            case "/":
                System.out.println(Calculator.divide(x, y));
                break;
            default:
                System.out.println("Список поддерживаемых операций: " + "\n +" + "\n -" + "\n *" + "\n /");
        }
    }
}

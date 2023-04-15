import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Integer> applyFunction(String[] st, Function func) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < st.length; i++) {
            res.add((i - 1), func.evaluate(Integer.parseInt(st[i])));
        }
        return res;
    }

    static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    void print(String[] st){
        List<Integer> was=new ArrayList<>();
        for (int i = 1; i < st.length; i++) {
            was.add(Integer.parseInt(st[i]));
        }
        System.out.println(was);
    }

    public static void main(String[] args) {
        Main operation = new Main();
        if (args.length == 0) {
            System.out.println("Не передано название операции");
            System.exit(3);
        }
        if (args.length == 1) {
            for (int i = 0; i < args.length; i++) {
                if (!isInteger(args[i])) {
                    System.out.println("Не переданы числа для операции");
                    System.exit(4);
                }
            }
        }
        operation.print(args);
        switch (args[0]) {
            case "Half":
                Half half = new Half();
                System.out.println(operation.applyFunction(args, half));
                break;
            case "Double":
                Double doub = new Double();
                System.out.println(operation.applyFunction(args, doub));
                break;
            case "Exact":
                Exact exact = new Exact();
                System.out.println(operation.applyFunction(args, exact));
                break;
            case "Square":
                Square square = new Square();
                System.out.println(operation.applyFunction(args, square));
                break;
            default:
                System.out.println("Операция ->" + args[0] + "<- не поддерживается");
        }

    }
}

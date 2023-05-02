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

    List<Integer> applyFunction(String[] st, Function func, List<Integer> old) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < st.length; i++) {
            res.add((i - 1), func.evaluate(Integer.parseInt(st[i])));
            if (i > 1) {
                res.set(i - 1, (res.get(i - 1) + old.get(i - 2)));
            }
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
        List<Integer> was = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            was.add(Integer.parseInt(args[i]));
        }
        Function wave = new Function() {
            @Override
            public int evaluate(int x) {
                return x;
            }
        };
        Function evenSquare = x -> {
            if (x % 2 == 0) {
                return x * x;
            } else {
                return x;
            }
        };
        System.out.println(was);
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
            case "Wave":
                System.out.println(operation.applyFunction(args, wave, was));
                break;
            case "SquareEven":
                System.out.println(operation.applyFunction(args, evenSquare));
                break;
            default:
                System.out.println("Операция ->" + args[0] + "<- не поддерживается");
        }

    }
}

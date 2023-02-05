public class Calculator {
    static int add(int x, int y) {
        return x + y;
    }

    static int sub(int x, int y) {
        return x - y;
    }

    static int multi(int x, int y) {
        return x * y;
    }

    static int divide(int x, int y) {
        if (y == 0) {
            System.out.println("Операция не может быть выполнена");
            System.exit(13);
        }
        return x / y;
    }
}

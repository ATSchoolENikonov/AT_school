import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test_44 {
    @Check_task_44
    private final Main operation = new Main();

    @Tag("gradle_test")
    @Test
    public void checkHalf() {
        String[] st = {"этот отброситься", "4", "6", "8"};
        Half half = new Half();
        List<Integer> exp = List.of(2, 3, 4);
        Assertions.assertEquals(exp, operation.applyFunction(st, half));
    }

    @Tag("gradle_test")
    @Test
    public void checkDouble() {
        String[] st = {"этот отброситься", "4", "6", "8"};
        Double doubl = new Double();
        List<Integer> exp = List.of(8, 12, 16);
        Assertions.assertEquals(exp, operation.applyFunction(st, doubl));
    }

    @Tag("gradle_test")
    @Test
    public void checkExact() {
        String[] st = {"этот отброситься", "4", "6", "8"};
        Exact exact = new Exact();
        List<Integer> exp = List.of(4, 6, 8);
        Assertions.assertEquals(exp, operation.applyFunction(st, exact));
    }

    @Tag("gradle_test")
    @Test
    public void checkSquare() {
        String[] st = {"этот отброситься", "4", "6", "8"};
        Square square = new Square();
        List<Integer> exp = List.of(16, 36, 64);
        Assertions.assertEquals(exp, operation.applyFunction(st, square));
    }

    @Tag("gradle_test")
    @Test
    public void checkEmpty() {
        String[] st = {};
        String error = "Не передано название операции";
        Assertions.assertEquals(error, operation.isValid(st));
    }

    @Tag("gradle_test")
    @Test
    public void checkEmptyNumbers() {
        String[] st = {"этого не будет"};
        String error = "Не переданы цифры";
        Assertions.assertEquals(error, operation.isValid(st));
    }

}

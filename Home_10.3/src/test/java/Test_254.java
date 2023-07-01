import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class Test_254 {
    @Check_task_254
    @ParameterizedTest
    @MethodSource
    public void TestCount(int input) {
        Stream<Integer> exp = Stream.of(0, 7, 57);
        Assertions.assertTrue(exp.anyMatch(k -> k == input));
    }

    static Stream<Integer> TestCount() {
        int a = Task_1.str.indexOf("Ц");
        int b = Task_1.str.indexOf("а");
        int c = Task_1.str.indexOf(".");
        return Stream.of(Task_1.countLetters(Task_1.str, a),
                Task_1.countLetters(Task_1.str, b),
                Task_1.countLetters(Task_1.str, c));
    }

    //    @Test
//    public void TestPath() {
//        String[] word = {"/bin/java"};
//        String exp = "Путь: /bin/\n" +
//                "Название файла: java";
//        Assertions.assertEquals(exp, Task_2.strVivod(word));
//    }
//
//    @Test
//    public void TestPath2() {
//        String[] word = {"C:\\Program Files\\Java\\bin\\java"};
//        String exp = "Путь: C:\\Program Files\\Java\\bin\\\n" +
//                "Название файла: java";
//        Assertions.assertEquals(exp, Task_2.strVivod(word));
//    }
//
//    @Test
//    public void TestPath3() {
//        String[] word = {"/"};
//        Assertions.assertEquals("Введен некорректный путь до файла.", Task_2.strVivod(word));
//    }
    @ParameterizedTest
    @MethodSource
    public void checkPath(String str) {
        Stream<String> exp = Stream.of("Путь: /bin/\n" +
                        "Название файла: java",
                "Путь: C:\\Program Files\\Java\\bin\\\n" +
                        "Название файла: java",
                "Введен некорректный путь до файла.");
        Assertions.assertTrue(exp.anyMatch(k -> k.equals(str)));
    }

    static Stream<String> checkPath() {
        String[] word1 = {"/bin/java"};
        String[] word2 = {"C:\\Program Files\\Java\\bin\\java"};
        String[] word = {"/"};
        return Stream.of(Task_2.strVivod(word1),
                Task_2.strVivod(word2),
                Task_2.strVivod(word));
    }

}

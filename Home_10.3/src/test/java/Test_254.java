import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class Test_254 {

    @Check_task_254
    @ParameterizedTest
    @MethodSource
    public void TestCount(int exp, int index, String str) {
        Assertions.assertEquals(Task_1.countLetters(str, index), exp);
    }

    static Stream<Arguments> TestCount() {
        int a = Task_1.str.indexOf("Ц");
        int b = Task_1.str.indexOf("а");
        int c = Task_1.str.indexOf(".");
        return Stream.of(Arguments.arguments(0, a, Task_1.str),
                Arguments.arguments(7, b, Task_1.str),
                Arguments.arguments(57, c, Task_1.str));
    }

    @ParameterizedTest
    @MethodSource({"checkPath"})
    public void checkPath(String exp, String[] str) {
        Assertions.assertEquals(exp, Task_2.strVivod(str));
    }

    static Stream<Arguments> checkPath() {
        String[] word1 = {"/bin/java"};
        String[] word2 = {"C:\\Program Files\\Java\\bin\\java"};
        String[] word = {"/"};
        return Stream.of(
                Arguments.arguments("Путь: /bin/\n" +
                        "Название файла: java", word1),
                Arguments.arguments("Путь: C:\\Program Files\\Java\\bin\\\n" +
                        "Название файла: java", word2),
                Arguments.arguments("Введен некорректный путь до файла.", word));
    }

}

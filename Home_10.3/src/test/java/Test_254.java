import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class Test_254 {

    @Check_task_254
    @ParameterizedTest
    @MethodSource
    public void TestCount(int input, int exp) {
        Assertions.assertEquals(exp, input);
    }

    static Stream<Arguments> TestCount() {
        int a = Task_1.str.indexOf("Ц");
        int b = Task_1.str.indexOf("а");
        int c = Task_1.str.indexOf(".");
        return Stream.of(Arguments.arguments(0, Task_1.countLetters(Task_1.str, a)),
                Arguments.arguments(7, Task_1.countLetters(Task_1.str, b)),
                Arguments.arguments(57, Task_1.countLetters(Task_1.str, c)));
    }

    @ParameterizedTest
    @MethodSource({"checkPath"})
    public void checkPath(String str, String exp) {
        Assertions.assertEquals(exp, str);
    }

    static Stream<Arguments> checkPath() {
        String[] word1 = {"/bin/java"};
        String[] word2 = {"C:\\Program Files\\Java\\bin\\java"};
        String[] word = {"/"};
        return Stream.of(
                Arguments.arguments("Путь: /bin/\n" +
                        "Название файла: java", Task_2.strVivod(word1)),
                Arguments.arguments("Путь: C:\\Program Files\\Java\\bin\\\n" +
                        "Название файла: java", Task_2.strVivod(word2)),
                Arguments.arguments("Введен некорректный путь до файла.", Task_2.strVivod(word)));
    }

}

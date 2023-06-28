import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class Test_254 {
    @Tag("gradle test")
    @ParameterizedTest
    @ValueSource(strings = {"Ц", "а", "."})
    public void TestCount(String check) {
        int a = Task_1.str.indexOf(check);
        Assertions.assertEquals(0, Task_1.countLetters(Task_1.str, a));
    }

    @Test
    @Tag("gradle test")
    public void TestPath() {
        String[] word = {"/bin/java"};
        String exp = "Путь: /bin/\n" +
                "Название файла: java";
        Assertions.assertEquals(exp, Task_2.strVivod(word));
    }

    @Test
    @Tag("gradle test")
    public void TestPath2() {
        String[] word = {"C:\\Program Files\\Java\\bin\\java"};
        String exp = "Путь: C:\\Program Files\\Java\\bin\\\n" +
                "Название файла: java";
        Assertions.assertEquals(exp, Task_2.strVivod(word));
    }

    @Test
    @Tag("gradle test")
    public void TestPath3()  {
        String[] word = {"/"};
        Assertions.fail(Task_2.strVivod(word));
    }

}

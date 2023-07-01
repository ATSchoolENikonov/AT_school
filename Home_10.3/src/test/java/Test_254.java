import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class Test_254 {
    @Check_task_254
    @Tag("gradle_test")
    @Test
    public void TestCount() {
        int a = Task_1.str.indexOf("Ц");
        Assertions.assertEquals(0, Task_1.countLetters(Task_1.str, a));
        int b = Task_1.str.indexOf("а");
        Assertions.assertEquals(7, Task_1.countLetters(Task_1.str, b));
        int c = Task_1.str.indexOf(".");
        Assertions.assertEquals(57, Task_1.countLetters(Task_1.str, c));
    }

    @Test
    @Tag("gradle_test")
    public void TestPath() {
        String[] word = {"/bin/java"};
        String exp = "Путь: /bin/\n" +
                "Название файла: java";
        Assertions.assertEquals(exp, Task_2.strVivod(word));
    }

    @Test
    @Tag("gradle_test")
    public void TestPath2() {
        String[] word = {"C:\\Program Files\\Java\\bin\\java"};
        String exp = "Путь: C:\\Program Files\\Java\\bin\\\n" +
                "Название файла: java";
        Assertions.assertEquals(exp, Task_2.strVivod(word));
    }

    @Test
    @Tag("gradle_test")
    public void TestPath3() {
        String[] word = {"/"};
        Assertions.assertEquals("Введен некорректный путь до файла.", Task_2.strVivod(word));
    }

}

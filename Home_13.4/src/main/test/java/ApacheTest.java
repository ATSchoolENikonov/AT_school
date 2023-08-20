import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApacheTest {
    SetUp setUp = new SetUp();

    @Epic(value = "Dummy")
    @Feature(value = "Получение гет")
    @Story(value = "User Data")
    @DisplayName("Проверка получения данных пользователя")
    @Test
    @Step("Проверка получения пользователя")
    void checkGetUser() {
        Response<User> expected = setUp.getExpectedUser();
        Response<User> actual = setUp.impl.getUser(DummyJsonClientImpl.id);
        Assertions.assertEquals(expected, actual);
    }

    @Epic(value = "Dummy")
    @Feature(value = "Отправка пост")
    @Story(value = "User token")
    @DisplayName("Проверка получения токена")
    @Test
    @Step("Проверка получения токена при логине")
    void checkGetToken() {
        Response<Token> actual = setUp.impl.login(setUp.user);
        Assertions.assertNotNull(actual);
    }

    @Epic(value = "Dummy")
    @Feature(value = "Получение гет")
    @Story(value = "User Post")
    @DisplayName("Проверка получения поста")
    @Test
    @Step("Проверка получения постов конкретного пользователя")
    void checkGetPost() {
        Response<List<Post>> expected = setUp.getExpectedPost();
        Response<List<Post>> actual = setUp.impl.getPosts(setUp.user, setUp.token);
        Assertions.assertEquals(expected, actual);
    }
}

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApacheTest {
    SetUp setUp = new SetUp();
    private static final Logger logger= LogManager.getLogger(ApacheTest.class);
    @BeforeAll
    public static void logLevel(){
        logger.info("The Apache Test has begun");
    }


    @Epic(value = "Dummy")
    @Feature(value = "Получение гет")
    @Story(value = "User Data")
    @DisplayName("Проверка получения данных пользователя")
    @Test
    void checkGetUser() {
        logger.debug("-----Step starts here-----");
        Response<User> expected = setUp.getExpectedUser();
        Response<User> actual = setUp.impl.getUser(DummyJsonClientImpl.id);
        logger.warn("Test {} {}",expected,actual);
        Assertions.assertEquals(expected, actual);
    }

    @Epic(value = "Dummy")
    @Feature(value = "Отправка пост")
    @Story(value = "User token")
    @DisplayName("Проверка получения токена")
    @Test
    void checkGetToken() {
        logger.debug("-----Step starts here-----");
        Response<User> response = setUp.impl.getUser(DummyJsonClientImpl.id);
        User user=setUp.impl.getDataUser(response);
        Response<Token> actual = setUp.impl.login(user);
        logger.warn("Test {} ",actual);
        Assertions.assertNotNull(actual);
    }

    @Epic(value = "Dummy")
    @Feature(value = "Получение гет")
    @Story(value = "User Post")
    @DisplayName("Проверка получения поста")
    @Test
    void checkGetPost() {
        logger.debug("-----Step starts here-----");
        Response<User> response = setUp.impl.getUser(DummyJsonClientImpl.id);
        User user=setUp.impl.getDataUser(response);
        Response<List<Post>> expected = setUp.getExpectedPost();
        Token token=setUp.impl.getToken(setUp.impl.login(user));
        Response<List<Post>> actual = setUp.impl.getPosts(user, token);
        logger.warn("Test {} {}",expected,actual);
        Assertions.assertEquals(expected, actual);
    }
}

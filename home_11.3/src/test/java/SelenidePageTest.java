import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class SelenidePageTest {
    //Task_1
    @Test
    void checkPage() {
        Configuration.timeout = 10000;
        open(LoginPage.url);
        LoginPage loginPage = new LoginPage();
        Assert.isTrue(loginPage.initLogo.getText().contains("Swag Labs"), "Wrong Text!!!!");
    }

    //Task_2
    @Test
    void checkBurger() {
        Configuration.timeout = 10000;
        open(LoginPage.url);
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();
        String cor = "https://www.saucedemo.com/inventory.html";
        loginPage.userName.val("standard_user");
        loginPage.userPassword.val("secret_sauce");
        loginPage.logButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.isTrue(currentUrl.contains(cor), "Wrong Url");
        Assert.isTrue(productsPage.searchFieldProduct.getText().contains("Products"), "Wrong Page!!!");
        productsPage.burgerButton.shouldBe(Condition.visible, Duration.ofSeconds(100)).click();
        productsPage.logoutButton.shouldBe(Condition.visible, Duration.ofSeconds(100)).click();
        String currentUrlLog = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.isTrue(currentUrlLog.contains(LoginPage.url), "Wrong Url");
        Assert.isTrue(loginPage.searchFieldLogin.getText().contains("Swag Labs"), "Wrong Text!!!!");
    }

    //Task_3
    @Test
    void checkTheThird() {
        Configuration.timeout = 10000;
        open(InternetPage.url);
        InternetPage internetPage = new InternetPage();
        Assertions.assertFalse(internetPage.hiddenElement.exists());
        internetPage.button.shouldBe(Condition.visible).click();
        Wait().until(ExpectedConditions.visibilityOf(internetPage.hiddenElement));
        Assert.isTrue(Wait().until(ExpectedConditions.visibilityOf(internetPage.hiddenElement))
                .isDisplayed(), "Some think gone wrong");
    }


}

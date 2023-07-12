import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class SelenidePage {

    //Task_1
    @Test
    void checkPage() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(LoginPage.url);
        PageFactory.initElements(driver, loginPage);
        String text = loginPage.initLogo.getText();
        Assert.isTrue(text.contains("Swag Labs"), "Wrong Text!!!!");
        driver.quit();
    }

    //Task_2
    @Test
    void checkBurger() {
        Configuration.timeout = 10000;
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();
        open(LoginPage.url);
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
}

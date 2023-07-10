import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePage {

//Task_1
    @Test
    void checkPage() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/driver/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(LoginPage.url);
        PageFactory.initElements(driver, loginPage);
        String text = loginPage.buttonLogo.getText();
        Assert.isTrue(text.contains("Swag Labs"), "Wrong Text!!!!");
        driver.quit();
    }
//Task_2
    @Test
    void checkBurger() {
        Configuration.timeout = 10000;
        open(LoginPage.url);
        SelenideElement searchFieldProduct = $(byText("Products"));
        SelenideElement searchFieldLogin = $(By.xpath("//div[@class='login_logo']"));
        String cor = "https://www.saucedemo.com/inventory.html";
        $x("//input[@id='user-name']").val("standard_user");
        $x("//input[@id='password']").val("secret_sauce");
        $x("//input[@id='login-button']").click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.isTrue(currentUrl.contains(cor), "Wrong Url");
        Assert.isTrue(searchFieldProduct.getText().contains("Products"), "Wrong Page!!!");
        $x("//button[@id='react-burger-menu-btn']").shouldBe(Condition.visible, Duration.ofSeconds(100)).click();
        $x("//a[@id='logout_sidebar_link']").shouldBe(Condition.visible, Duration.ofSeconds(100)).click();
        String currentUrlLog = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.isTrue(currentUrlLog.contains(LoginPage.url), "Wrong Url");
        Assert.isTrue(searchFieldLogin.getText().contains("Swag Labs"), "Wrong Text!!!!");
    }
}

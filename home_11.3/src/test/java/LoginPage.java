import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    @FindBy(how= How.XPATH,using = "//div[.='Swag Labs']")
    WebElement initLogo;
    static String url="https://www.saucedemo.com/";
    SelenideElement userName= $x("//input[@id='user-name']");
    SelenideElement userPassword= $x("//input[@id='password']");
    SelenideElement logButton= $x("//input[@id='login-button']");
    SelenideElement searchFieldLogin = $(By.xpath("//div[@class='login_logo']"));

}

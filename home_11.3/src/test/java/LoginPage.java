import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {
    @FindBy(how= How.XPATH,using = "//div[.='Swag Labs']")
    WebElement buttonLogo;
    static String url="https://www.saucedemo.com/";
    @FindBy(how= How.XPATH,using = "//input[@id='user-name']")
    WebElement username;
    @FindBy(how= How.XPATH,using = "//input[@id='password']")
    WebElement password;
    @FindBy(how= How.XPATH,using = "//input[@id='login-button']")
    WebElement buttonLogin;

}

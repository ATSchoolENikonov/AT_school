import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    SelenideElement initLogo = $x("//div[.='Swag Labs']");
    static String url = "https://www.saucedemo.com/";
    SelenideElement userName = $x("//input[@id='user-name']");
    SelenideElement userPassword = $x("//input[@id='password']");
    SelenideElement logButton = $x("//input[@id='login-button']");
    SelenideElement searchFieldLogin = $x("//div[@class='login_logo']");

    void login(){
        userName.val("standard_user");
        userPassword.val("secret_sauce");
        logButton.click();

    }

}

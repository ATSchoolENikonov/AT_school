import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    SelenideElement productLogo=$x("//span[.='Products']");
    SelenideElement burgerButton=$x("//button[@id='react-burger-menu-btn']");
    SelenideElement logoutButton=$x("//a[@id='logout_sidebar_link']");
    SelenideElement searchFieldProduct = $(byText("Products"));
}

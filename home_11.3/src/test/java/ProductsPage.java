import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage {
    @FindBy(how= How.XPATH,using = "//span[.='Products']")
    WebElement ProductLogo;
    @FindBy(how= How.XPATH,using = "//button[@id='react-burger-menu-btn']")
    WebElement burgerButton;
    @FindBy(how= How.XPATH,using = "//a[@id='logout_sidebar_link']")
    WebElement logoutButton;
}

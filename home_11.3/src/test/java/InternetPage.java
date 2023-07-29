import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InternetPage {
    static String url="https://the-internet.herokuapp.com/dynamic_loading/1";
    SelenideElement button=$x("//button[.='Start']");
    SelenideElement hiddenElement=$x("//h4[.='Hello World!']");
}

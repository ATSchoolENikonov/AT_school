
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;

public class ProductItem {
    SelenideElement productName;
    SelenideElement productDescrypt;
    SelenideElement productCost = $x("//div[contains(@class,'inventory_item_price')]");
    SelenideElement buyButton;

//    BigDecimal getPrice(SelenideElement productCost){
//        if(productCost.getText().contains())
//        return new BigDecimal(Integer.parseInt(productCost.getText()));
//    }
}

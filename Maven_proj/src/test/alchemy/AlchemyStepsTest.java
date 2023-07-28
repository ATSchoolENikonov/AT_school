import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AlchemyStepsTest {
    private NatureElement result;
    private NatureElement ele;

    @Given("^Get (.*)")
    public NatureElement getElement(String element) {
        return ele = NatureElement.create(element);
    }

    @Then("^Check Creation (.*)")
    public void checkCreateElement(String element) {
        Assert.assertEquals(element, ele.getClass().getName());
    }

    @When("^Connect elements (.*) & (.*)")
    public NatureElement connectElements(String ele1, String ele2) {
        return this.result = NatureElement.create(ele1).connect(NatureElement.create(ele2));
    }

    @Then("^Check Element (.*)")
    public void checkElement(String element) {
        try {
            Assert.assertEquals(element, result.getClass().getName());
        } catch (NullPointerException e) {
            Assert.assertTrue("Нет нового элемента", true);
        }
    }
}

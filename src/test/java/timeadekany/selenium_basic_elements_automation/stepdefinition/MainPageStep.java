package timeadekany.selenium_basic_elements_automation.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageStep extends BaseStep {

    @Given("I open the page")
    public void i_open_the_page() throws Exception{
        chromeDriver.navigate().to(BASE_URL);
    }

    @And("I close the pop up")
    public void i_close_the_pop_up() throws Exception{
        WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[title=Close]")));
        chromeDriver.findElementByCssSelector("a[title=Close]").click();
    }

    @And("I click on the Input Forms menu")
    public void i_click_on_the_input_form_menu_item() throws Exception{
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        chromeDriver.findElementByCssSelector(".nav:nth-child(1) > .dropdown:nth-child(1) > .dropdown-toggle").click();
    }

}

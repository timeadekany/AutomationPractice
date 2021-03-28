package timeadekany.selenium_basic_elements_automation.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SingleInputFormStep extends MainPageStep {

 /*   String BASE_URL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
    //String BASE_URL = "http://automationpractice.com/index.php";
    //String BASE_URL = "https://www.phptravels.net/home";
    WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

    @Given("I open the page")
    public void i_open_the_page(){
        chromeDriver.navigate().to(BASE_URL);
    }

    @And("I close the pop up")
    public void i_close_the_pop_up(){
        WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[title=Close]")));
        chromeDriver.findElementByCssSelector("a[title=Close]").click();
    }

    @And("I click on the Input Forms menu")
    public void i_click_on_the_input_form_menu_item() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        chromeDriver.findElementByCssSelector(".nav:nth-child(1) > .dropdown:nth-child(1) > .dropdown-toggle").click();
    } */

    @And("I click on the First Menu item")
    public void i_click_on_first_menu_item(){
        chromeDriver.findElementByCssSelector(".open li:nth-child(1) > a").click();
    }

    @Then("I redirected to the Input form page")
    public void i_redirected_to_input_form_page(){
            String URL = chromeDriver.getCurrentUrl();
            assertEquals(URL, "https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    @When("I Fill the Single Input Field")
    public void i_fill_the_single_input_field(){
        chromeDriver.findElementByCssSelector("input#user-message").sendKeys("Teszt");
    }

    @And("I click on the Show Message button")
    public void i_click_on_the_show_message_button(){
        chromeDriver.findElementByCssSelector("button.btn-default:nth-child(2)").click();
    }


    @Then("I validate the Single Input message")
    public void i_validate_the_single_input_message(){
        String assertText = chromeDriver.findElementByCssSelector("div#user-message > span#display").getText();
        assertEquals(assertText, "Teszt");
    }

    @When("I Fill Two Input Fields")
    public void i_fill_the_both_two_input_fields(){
        chromeDriver.findElementByCssSelector("input#sum1").sendKeys("3");
        chromeDriver.findElementByCssSelector("input#sum2").sendKeys("3");
    }

   @And("I click on the Get Total button")
   public void i_click_on_the_the_get_total_button(){
       chromeDriver.findElementByCssSelector(".btn:nth-child(3)").click();
   }

    @Then("I validate the Total input message")
    public void i_validate_the_total_input_message(){
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#displayvalue")));
        assertEquals(chromeDriver.findElementByCssSelector("#displayvalue").getText(), "6");
        //wait.until(ExpectedConditions.textToBe(By.cssSelector("#displayvalue"),"6"));
    }

    @And("Close the browser")
    public void i_close_the_browser(){
        chromeDriver.quit();
    }
}

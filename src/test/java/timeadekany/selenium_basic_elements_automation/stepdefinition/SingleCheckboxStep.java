package timeadekany.selenium_basic_elements_automation.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleCheckboxStep extends MainPageStep {
    @And("I click on the CheckBox Demo menu item")
    public void i_click_on_the_checkbox_menu_item(){

    }

    @When("I click on the checkbox")
    public void i_click_on_the_checkbox(){
        chromeDriver.findElementByCssSelector("input#isAgeSelected").click();
    }

    @Then("The checkbox is ticked")
    public void the_checkbox_is_ticked(){
        assertTrue(chromeDriver.findElementByCssSelector("input#isAgeSelected").isSelected());
        //chromeDriver.findElementByCssSelector("input#isAgeSelected").isSelected();
    }

    @And("Validate the message")
    public void validate_the_message(){
        String text = chromeDriver.findElementByCssSelector("div#txtAge").getText();
        assertEquals(text,"Success - Check box is checked");
    }
}

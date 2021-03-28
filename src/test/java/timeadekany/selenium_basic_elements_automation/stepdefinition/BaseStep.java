package timeadekany.selenium_basic_elements_automation.stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import static timeadekany.selenium_basic_elements_automation.driver.Driver.getChromeDriver;

public class BaseStep {

    String BASE_URL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
    ChromeDriver chromeDriver = getChromeDriver();


}
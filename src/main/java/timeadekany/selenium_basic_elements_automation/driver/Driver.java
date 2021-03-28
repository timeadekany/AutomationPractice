package timeadekany.selenium_basic_elements_automation.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    private static ChromeDriver driver;
    /**
     * Returns a working ChromeDriver.
     *
     * @return the ChromeDiver
     */
    public static ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions().setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        chromeOptions.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}

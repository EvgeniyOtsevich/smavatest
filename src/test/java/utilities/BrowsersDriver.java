package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BrowsersDriver {

    protected WebDriver driver = returnDriver();

    private WebDriver returnDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");
            options.addArguments("chrome.switches","--disable-extensions");
            options.addArguments("--window-size=1920,1080");
            driver = new EventFiringWebDriver(new ChromeDriver(options));
        }
        return driver;
    }
}

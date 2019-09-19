package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(id = "cookie-accepted-ok")
    private WebElement cookieAcceptedOkButton;

    private final int TIME_OUT_SEC = 3;
    private final int SLEEP_MILLIS = 500;
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIME_OUT_SEC, SLEEP_MILLIS);
    }

    public LandingPage navigateToLandingPage(){
        driver.get("https://www.smava.de");
        return new LandingPage(driver);
    }

    public void acceptCookie(){
        wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptedOkButton)).click();
    }

}

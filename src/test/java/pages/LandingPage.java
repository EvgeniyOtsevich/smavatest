package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//input[@name='category']/..")
    private WebElement categoryField;

    @FindBy(xpath = "//input[@name='amount']/..")
    private WebElement amountField;

    @FindBy(xpath = "//input[@name='duration']/..")
    private WebElement durationField;

    @FindBy(css = "a.ButtonNext__button")
    private WebElement nextButton;

    @FindBy(css = "nav.TopMenu__toggles")
    private WebElement menuLoginButton;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button.LoginForm__button")
    private WebElement formLoginButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select '{0}' categoty")
    public LandingPage selectCategory(String option){
        selectOptionFrom(categoryField, option);
        return this;
    }

    @Step("Select '{0}' amount")
    public LandingPage selectAmount(String option){
        selectOptionFrom(amountField, option);
        return this;
    }

    @Step("Select '{0}' duration")
    public LandingPage selectDuration(String option){
        selectOptionFrom(durationField, option);
        return this;
    }

    private void selectOptionFrom(WebElement from, final String option){
        wait.until(ExpectedConditions.elementToBeClickable(from)).click();
        from.findElements(By.cssSelector("[role=listbox] div"))
                .stream()
                .filter(el -> el.getText().replace(".", "").contains(option))
                .findFirst()
                .get()
                .click();
    }

    @Step("Click on 'Jetzt Kreditvergleich starten' button")
    public void calculateLoan(){
        nextButton.click();
        new LoanRequestPage(driver);
    }

    @Step("Click on 'Anmelden' button")
    public LandingPage clickLogin() {
        menuLoginButton.click();
        return this;
    }

    @Step("Input '{0}' email")
    public LandingPage inputEmail(String email) {
        if(email != null) emailField.sendKeys(email);
        return this;
    }

    @Step("Input '{0}' password")
    public LandingPage inputPassword(String password) {
        if(password != null) passwordField.sendKeys(password);
        return this;
    }

    @Step("Select 'Anmelden' button in login form")
    public LandingPage signIn() {
        formLoginButton.click();
        return this;
    }

    @Step("Verify user login attempt is failed")
    public void verifyLoginFailed(){
        try {
            wait.until(ExpectedConditions.stalenessOf(formLoginButton));
        } catch (TimeoutException ignored) {}
        assertThat("Login button is no longer displayed.", formLoginButton.isDisplayed(), is(true));
    }
}

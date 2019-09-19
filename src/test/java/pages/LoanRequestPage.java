package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoanRequestPage extends BasePage{

    @FindAll(@FindBy(css = ".segmented"))
    private List<WebElement> radioSegmentedList;

    @FindBy(id = "applicant0.personal.firstName")
    private WebElement firstNameField;

    @FindBy(id = "applicant0.personal.lastName")
    private WebElement surnameField;

    @FindBy(id = "applicant0.personal.birthDate")
    private WebElement birthDateField;

    @FindBy(id = "applicant0.contacts.phoneMobile")
    private WebElement phoneField;

    @FindBy(id = "applicant0.contacts.email")
    private WebElement emailField;

    @FindBy(id = "applicant0.conditions.schufaAgreementAccepted")
    private WebElement agreementCheckbox;

    @FindBy(css = "button[name=cta_btn_0]")
    private WebElement nextButton;

    @FindBy(css = ".field-set__title")
    private WebElement personalDataTitle;

    @FindBy(id = "back_btn_1")
    private WebElement backButton;

    public LoanRequestPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify page is loaded")
    public void verifyPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(backButton));
        } catch (TimeoutException ignored){ }
        assertThat("Page is not displayed fully.", backButton.isDisplayed(), is(true));
    }

    @Step("Select number of borrowers: {0}")
    public LoanRequestPage numberOfBorrowers(int number){
        if (number == 1) radioSegmentedList.get(0).findElements(By.cssSelector(".segmented__radio_chip")).get(0).click();
        else radioSegmentedList.get(0).findElements(By.cssSelector(".segmented__radio_chip")).get(1).click();
        return this;
    }

    @Step("Gender: {0}")
    public LoanRequestPage selectGender(User.Gender gender){
        if (gender == User.Gender.Male) radioSegmentedList.get(1).findElements(By.cssSelector(".segmented__radio_chip")).get(0).click();
        else radioSegmentedList.get(1).findElements(By.cssSelector(".segmented__radio_chip")).get(1).click();
        return this;
    }

    @Step("Input first name: {0}")
    public LoanRequestPage inputFirstName(String name){
        firstNameField.sendKeys(name);
        return this;
    }

    @Step("Input surname: {0}")
    public LoanRequestPage inputLastName(String name){
        surnameField.sendKeys(name);
        return this;
    }

    @Step("Input date of birds: {0}")
    public LoanRequestPage inputBirthDateName(String date){
        birthDateField.sendKeys(date);
        return this;
    }

    @Step("Input phone: {0}")
    public LoanRequestPage inputPhone(String phone){
        phoneField.sendKeys(phone);
        return this;
    }

    @Step("Input email: {0}")
    public LoanRequestPage inputEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    @Step("Accept agreement")
    public LoanRequestPage acceptAgreement(){
        agreementCheckbox.click();
        return this;
    }

    @Step("Click on 'Weiter' button")
    public LoanRequestPage clickNext(){
        nextButton.click();
        return this;
    }
}

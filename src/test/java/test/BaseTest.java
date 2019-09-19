package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import pages.LandingPage;
import pages.LoanRequestPage;
import user.User;
import utilities.BrowsersDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest extends BrowsersDriver {

    LandingPage landingPage;
    LoanRequestPage loanResultPage;
    User user = new User();

    @BeforeAll
    public void setup(){
        landingPage = new LandingPage(driver);
        loanResultPage = new LoanRequestPage(driver);
        landingPage.navigateToLandingPage().acceptCookie();
    }

   @AfterEach
    public void returnToHome(){
        landingPage.navigateToLandingPage();
    }

    @AfterAll
    public void tearDown(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

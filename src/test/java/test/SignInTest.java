package test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import io.qameta.allure.Story;
import io.qameta.allure.Description;

class SignInTest extends BaseTest {

    @Story("As a user I want to click on 'Anmelden' and be able to introduce data, but not being able to log-in because the data is not correct.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user not being able to log-in because the data is not correct")
    @ParameterizedTest(name = "{index} ==> email=''{0}'', password=''{1}''")
    @CsvSource({
            "Test@test.com,testpass",
            ",",
            "testmail@mail.com,",
            ",password",
            "testmail.com,password"
    })
    void loginWithIncorrectData(String email, String password){
        landingPage
                .clickLogin()
                .inputEmail(email)
                .inputPassword(password)
                .signIn()
                .verifyLoginFailed();
    }
}

package test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import io.qameta.allure.Story;

class LoanTest extends BaseTest{

    @Story("As a user I want to ask for a loan of amount '2750' at smava.de, to pay during '24' months for 'Wohnen', click on next (Weiter) and verify that the page is completely loaded.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can ask for loan")
    @ParameterizedTest(name = "{index} ==> category=''{0}'', amount={1}, duration={2} months")
    @CsvSource({"Wohnen,2750,24"})
    void AskForLoanTest(String category, String amount, String duration){
        landingPage
                .selectCategory(category)
                .selectAmount(amount)
                .selectDuration(duration)
                .calculateLoan();

        loanResultPage
                .selectGender(user.getGender())
                .inputFirstName(user.getFirstName())
                .inputLastName(user.getSurname())
                .inputBirthDateName(user.getDOB())
                .inputPhone(user.getPhone())
                .inputEmail(user.getEmail())
                .acceptAgreement()
                .clickNext()
                .verifyPageLoaded();
    }
}

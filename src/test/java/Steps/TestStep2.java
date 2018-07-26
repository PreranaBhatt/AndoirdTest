package Steps;

import Page.LocalDriver;
import Page.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;
import io.appium.java_client.android.AndroidDriver;

public class TestStep2 implements En {
    private AndroidDriver driver;
    Login login;

    public TestStep2() {
        Given("^Launching an app$", () -> {
            driver = BaseStep.driver;
            login = new Login(driver);
        });

        And("^clicking on GetStarted btn$", () -> {

            login.clickGetStartedBtn();
        });

        And("^clicking on HambergerManu$", () -> {
            login.closeSkintoneQuestionarePopup();
            login.ClickHambergerMenu();
        });
    }
}

package Steps;

import Page.Login;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.appium.java_client.android.AndroidDriver;

public class TestStep {
    private AndroidDriver driver;
    Login login=null;

    @Given("^Launch an app$")
    public void LaunchApp() {
        driver = BaseStep.driver;
        System.out.println(driver.getDeviceTime());
        System.out.println(" **********************");
        System.out.println(driver.getContext());
    }

    @And("^click on GetStarted btn$")
    public void getStarted() {

        System.out.println("driver" + driver);
        login = new Login(BaseStep.driver);

        login.clickGetStartedBtn();
        login.closeSkintoneQuestionarePopup();
    }

    @And("^click on HambergerManu$")
    public void clickOnHambergerMenu() {
        login.ClickHambergerMenu();
    }


}

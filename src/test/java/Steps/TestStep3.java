package Steps;

import Page.BMSHomePage;
import Page.BMSLaunchPage;
import Page.MoviesPage;
import cucumber.api.java8.En;
import io.appium.java_client.android.AndroidDriver;

public class TestStep3 implements En {

    private AndroidDriver driver;
    BMSLaunchPage bmsLaunchPage = null;
    BMSHomePage bmshomePage = null;
    MoviesPage moviesPage = null;

    public TestStep3() {

        Given("^i will open bookmyshow app in mobile$", () -> {
           // driver = BaseStep.driver;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           // bmsLaunchPage = new BMSLaunchPage(BaseStep.driver);
            bmsLaunchPage.clickOnGetStartedBTn();
            bmsLaunchPage.clickOnEleSkipBtn();
            bmsLaunchPage.clickOnMonitorPhysicalLocationPopup();
            bmsLaunchPage.clickOnMonitorPhysicalLocationPopup();
            bmsLaunchPage.selectRegion("Bengaluru");

        });


        And("^i will select first available movie$", () -> {

          //  bmshomePage = new BMSHomePage(BaseStep.driver);
            bmshomePage.selectAnyCategory("Movies");

        //    moviesPage = new MoviesPage(BaseStep.driver);
            moviesPage.selectFirstAvailableBookBtn();
            moviesPage.selectDayforMovie();
            moviesPage.selectFirstAvailableShow();
            moviesPage.ClickAcceptTermsAndConditionBtn();

        });
        And("^i will select seat  for two$", () -> {
            moviesPage.clickSelectSeatBtn();
        });
        Then("^i should get payment page$", () -> {
            // moviesPage.selectPayOption();
            System.out.println(" payment option is displayed");
        });
    }
}

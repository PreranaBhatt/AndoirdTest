package Steps;

import Page.LocalDriver;
import Page.Login;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;


public class BaseStep {
    public static AndroidDriver driver;

    @Before
    public void initiate() throws IOException {
        driver = LocalDriver.getDriver();
    }

    @After
    public void teardown() {
        driver.quit();

    }
}

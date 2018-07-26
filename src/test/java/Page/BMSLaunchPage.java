package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BMSLaunchPage {

    public BMSLaunchPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.bt.bms:id/language_text_view_label")
    private WebElement eleGetStartedBtn;

    public void clickOnGetStartedBTn()  {
        eleGetStartedBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AndroidFindBy(id = "com.bt.bms:id/launcher_tv_for_skip")
    private WebElement eleSkipSignInBtn;

    public void clickOnEleSkipBtn() {
        eleSkipSignInBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AndroidFindBy(xpath="//android.widget.Button[contains(@text,'OK') or contains(@text,'Allow')]")
    private WebElement locationPopupOkBtn;


    public void clickOnLocationPopupBtn() {
        try {
            locationPopupOkBtn.isDisplayed();
            locationPopupOkBtn.click();
        } catch (Exception e) {

        }
    }


    @AndroidFindAll({
            @AndroidBy(id = "com.bt.bms:id/location_pop_cities_name")
    })
    private List<WebElement> citiesName;

    public void selectRegion(String cityName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            if (citiesName.size() > 0)
                System.out.println(citiesName.size());
                for (int i = 0; i <= citiesName.size() - 1; i++) {
                    System.out.println(citiesName.get(i).getText());
                    if (citiesName.get(i).getText().equals(cityName))
                        citiesName.get(i).click();
                    break;
                }

        } catch (Exception e) {

        }
    }
}

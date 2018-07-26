package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;

public class MoviesPage extends basePage {
    AndroidDriver driver;

    public MoviesPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBys({
            @AndroidBy(id = "com.bt.bms:id/movie_details_activity_btn_book")
    })
    private List<WebElement> eleBookBtnList;


    public void selectFirstAvailableBookBtn() {
        if (eleBookBtnList.size() >= 0) {
            eleBookBtnList.get(0).click();

        } else {
            Assert.fail(" movie list is not displayed");
        }
    }


    @AndroidFindBys({
            @AndroidBy(xpath = "//android.widget.HorizontalScrollView//android.view.View/android.widget.TextView[2]")
    })

    private List<WebElement> eleDate;

    public void selectDayforMovie() {

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH) + 1;


        for (int i = 0; i <= eleDate.size() - 1; i++) {
            if (eleDate.get(i).getText().equals(Integer.toString(day))) {
                eleDate.get(i).click();
                break;
            }
        }


    }


    @AndroidFindBys({
            @AndroidBy(xpath = "//android.view.View/android.widget.TextView")
    })
    private List<WebElement> eleTheaterName;


    @AndroidFindBys({
            @AndroidBy(xpath = "//android.widget.ImageView[1]/../../android.view.View/android.widget.TextView")

    })
    private List<WebElement> eleShowTime;


    public void selectFirstAvailableShow() {

        System.out.println("showtime" + eleShowTime.size());

        System.out.println(eleShowTime.get(0).getText());
        if (eleShowTime.size() > 0) {
            eleShowTime.get(0).click();
        } else {
            Assert.fail("either show time is not available");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Accept')]")
    private WebElement AcceptBtn;

    public void ClickAcceptTermsAndConditionBtn() {
        AcceptBtn.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='Select Seats']")
    private WebElement eleSelectSeatBtn;

    public void clickSelectSeatBtn() {
        eleSelectSeatBtn.click();
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Pay')]")
    private WebElement elePay;

    public void selectPayOption() {
        elePay.click();
    }


}

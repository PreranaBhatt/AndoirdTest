package Page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    public Login(AndroidDriver driver) {
        System.out.println("driver" + driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.voonik.android:id/login_complete_but")
    private MobileElement getStartedBtn;

    public void clickGetStartedBtn() {

        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        getStartedBtn.click();
    }

    @AndroidFindBy(id = "com.voonik.android:id/close_style_quiz")
    private MobileElement advCloseBtn;

    public void closeSkintoneQuestionarePopup() {
        try {
            advCloseBtn.isDisplayed();
            advCloseBtn.click();
        } catch (Exception e) {

        }
    }

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement hambergerMenu;

    public void ClickHambergerMenu() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        hambergerMenu.click();
    }


    @FindBys({
            @FindBy(id = "com.voonik.android:id/title")
    })
    private  List<WebElement> categoryList;
    public void selectAnyCategoryItem(String category) {
    for(int i=0;i<=categoryList.size()-1;i++)
    {
        if(categoryList.get(i).getText().equalsIgnoreCase(category))
        {
            categoryList.get(i).click();
        }
    }
    }

}

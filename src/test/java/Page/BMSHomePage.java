package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BMSHomePage {

    public BMSHomePage(AndroidDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBys({
            @AndroidBy(id="com.bt.bms:id/tab_title_tv_v3")
    })
    private List<WebElement> categoryList;



    public void selectAnyCategory(String givenCategory)
    {
        for(int i=0;i<=categoryList.size()-1;i++) {
            if (categoryList.get(i).getText().equalsIgnoreCase(givenCategory))
            {
                categoryList.get(i).click();
                break;
            }
        }
    }


}

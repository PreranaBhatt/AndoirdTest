package Page;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocalDriver {

    public static AndroidDriver<MobileElement> driver;
    public static DesiredCapabilities cap = null;

    public static AndroidDriver<MobileElement> getDriver() throws IOException {

        setDeviceInfo(System.getProperty("Devicename"));

        System.out.println(System.getProperty("DEVICE_NAME"));

        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");



       /* cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.voonik.android");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.voonik.android.SplashScreen");*/
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,System.getProperty("DEVICE_NAME"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, System.getProperty("PLATFORM_VERSION"));
        cap.setCapability(MobileCapabilityType.UDID,System.getProperty("UDID"));

        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bt.bms");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.movie.bms.splash.views.activities.SplashScreenActivity");
        //  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        return driver;
    }


    private static void setDeviceInfo(String data) {

        if(data.equals("LenovoA7700"))
        {
            System.setProperty("DEVICE_NAME","LenovoA7700");
            System.setProperty("PLATFORM_VERSION","6.0");
            System.setProperty("UDID","HGEPX64G");
        }
        else if(data.equals("OPPO A37f"))
        {
            System.setProperty("DEVICE_NAME","OPPO A37f");
            System.setProperty("PLATFORM_VERSION","5.1.1");
            System.setProperty("UDID","77329b70");
        }
        else {
            System.out.println("Given device is not listed");
        }

    }


}
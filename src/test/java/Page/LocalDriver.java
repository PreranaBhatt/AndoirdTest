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

        System.out.println(" create");
       // setDeviceInfo(System.getProperty("Devicename"));

        //System.out.println(System.getProperty("DEVICE_NAME"));

        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");



       /* cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.voonik.android");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.voonik.android.SplashScreen");*/
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Google Nexus 7 - 5.1.0 - API 22 - 800x1280");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1");
        cap.setCapability(MobileCapabilityType.UDID,"192.168.56.101:5555");

        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.embibe.institute.skv.app");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.embibe.app.activities.SplashActivity");


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
        else if (data.equals("LT-8001"))
        {
            System.setProperty("DEVICE_NAME","LT-8001");
            System.setProperty("PLATFORM_VERSION","5.1.1");
            System.setProperty("UDID","RFXTBEC00005405");
        }
        else {
            System.out.println("Given device is not listed");
        }

    }


}
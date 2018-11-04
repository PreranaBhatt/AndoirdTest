import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class script {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/preranabhatt/Desktop/testfolder/mobiletest/chromedriver");
        driver = new ChromeDriver();

        // driver.get("http://www.google.co.in");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "http://www.google.co.in";
        String script = " window.location = \'" + url + "\'";
        js.executeScript(script);


        String domain = js.executeScript(" return document.domain;").toString();
        System.out.println(domain);

        String docURL = js.executeScript("return document.URL;").toString();

        System.out.println(docURL);

        String doctitle = js.executeScript("return document.title;").toString();

        System.out.println(doctitle);


        WebElement ele=driver.findElement(By.xpath("//input[@name='q'] "));

        js.executeScript("arguments[0].click();",ele);
        ele.sendKeys("badminton");
        List<WebElement> autogenlst=driver.findElements(By.xpath("//div[@class=\"sbsb_a\"]/ul/li"));
        System.out.println(autogenlst.size());

        autogenlst.get(0).click();



    }
}

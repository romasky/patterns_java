package factories;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverTestFactory {
    public static WebDriver getTestDriver(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("android")) {
            capabilities.setCapability(MobilePlatform.ANDROID, "android");
            //some caps
            AndroidDriver driver =  new AndroidDriver(new URL("http://127.0.0.1:4808/wd/hub"), capabilities);
            WebDriverRunner.setWebDriver(driver);
            return driver;
        } else if (platform.equalsIgnoreCase("ios")) {
            capabilities.setCapability(MobilePlatform.IOS, "ios");
            //some caps
            IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4808/wd/hub"), capabilities);
            WebDriverRunner.setWebDriver(driver);
            return driver;
        } else if (platform.equalsIgnoreCase("windows")) {
            Configuration.browserSize = "1920x1080";
            Configuration.screenshots = true;
            return WebDriverRunner.getWebDriver();
        } else {
            throw new IllegalArgumentException("Unknown mobile platform: " + platform);
        }
    }
}

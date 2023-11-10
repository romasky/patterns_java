package tests;

import factories.DriverTestFactory;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FactoryTests {
    @Test
    public void mobileTests() throws MalformedURLException {
        WebDriver driver = DriverTestFactory.getTestDriver("ios");
        WebElement signButton = driver.findElement(AppiumBy.iOSClassChain("signIn"));
        Assertions.assertTrue(signButton.isDisplayed());
    }

    @Test
    public void androidTest() throws MalformedURLException {
        WebDriver driver = DriverTestFactory.getTestDriver("android");
        WebElement signButton = driver.findElement(AppiumBy.androidUIAutomator("signIn"));
        Assertions.assertTrue(signButton.isDisplayed());
    }
}

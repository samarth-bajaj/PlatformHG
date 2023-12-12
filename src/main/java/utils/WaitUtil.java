package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(10);

    public static void isClickable(WebDriver driver, By locator) {
        isClickable(driver, locator, DEFAULT_WAIT);
    }

    // If custom wait time is needed
    public static void isClickable(WebDriver driver, By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void isVisible(WebDriver driver, By locator) {
        isVisible(driver, locator, DEFAULT_WAIT);
    }

    // If custom wait time is needed
    public static void isVisible(WebDriver driver, By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Same as isVisible but doesn't throw an exception for times when you need to check if an element is visible
    // but don't want the test to fail if the element is not visible
    public static boolean isVisibleNoThrow(WebDriver driver, By locator) {
        return isVisibleNoThrow(driver, locator, DEFAULT_WAIT);
    }

    // If custom wait time is needed
    public static boolean isVisibleNoThrow(WebDriver driver, By locator, Duration timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}

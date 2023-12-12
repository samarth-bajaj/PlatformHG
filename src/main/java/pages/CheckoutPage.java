package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By continueButton = By.id("continue");
    private By firstnameField = By.id("first-name");
    private By lastnameField = By.id("last-name");
    private By postcodeField = By.id("postal-code");
    private By errorMessage = By.cssSelector(".error-message-container.error");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public ConfirmationPage confirmOrder() {
        driver.findElement(continueButton).click();
        WaitUtil.isVisibleNoThrow(driver, errorMessage, Duration.ofSeconds(1));
        return new ConfirmationPage(driver);
    }

    public void enterFirstname(String firstName) {
        driver.findElement(firstnameField).sendKeys(firstName);
    }

    public void enterLastname(String lastName) {
        driver.findElement(lastnameField).sendKeys(lastName);
    }

    public void enterPostcode(String postcode) {
        driver.findElement(postcodeField).sendKeys(postcode);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public By getContinueButton() { return continueButton; }
    public By getFirstnameField() { return firstnameField; }
    public By getLastnameField() { return lastnameField; }
    public By getPostcodeField() { return postcodeField; }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private WebDriver driver;

    private By finishButton = By.id("finish");
    private By confirmationLogo = By.className("pony_express");
    private By confirmationMessage = By.className("complete-header");
    private By dispatchMessage = By.className("complete-text");
    private By backHomeButton = By.id("back-to-products");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
        return new HomePage(driver);
    }

    public ConfirmationPage clickFinishButton() {
        driver.findElement(finishButton).click();
        return this;
    }
    public By getConfirmationLogo() { return confirmationLogo; }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public String getDispatchMessage() {
        return driver.findElement(dispatchMessage).getText();
    }

    public By getBackHomeButton() { return backHomeButton; }
}

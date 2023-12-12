package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container.error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUser(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        WaitUtil.isVisibleNoThrow(driver, errorMessage, Duration.ofSeconds(1));
        return new HomePage(driver);
    }

    public By getLoginButtonLocator() { return loginButton; }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}

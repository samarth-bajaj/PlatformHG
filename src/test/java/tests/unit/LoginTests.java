package tests.unit;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ElementUtil;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickMenu();

        boolean isLogoutButtonPresent = ElementUtil.isPresent(driver, homePage.getLogoutButtonLocator());

        Assert.assertTrue(isLogoutButtonPresent, "Element is not visible");
    }

    @Test
    public void testSuccessfulLogout() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username,password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.logout();

        boolean isLoginButtonPresent = ElementUtil.isPresent(driver, loginPage.getLoginButtonLocator());

        Assert.assertTrue(isLoginButtonPresent, "Element is not visible");
    }

    @Test
    public void testLoginOnlyUsername() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);

        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Epic sadface: Password is required"),
                "Error message did not appear as expected.");
    }

    @Test
    public void testLoginOnlyPassword() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);

        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Epic sadface: Username is required"),
                "Error message did not appear as expected.");
    }

    @Test
    public void testFailedLogin() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("invalidUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Epic sadface: Sorry, this user has been locked out."),
                "Error message did not appear as expected.");
    }
}

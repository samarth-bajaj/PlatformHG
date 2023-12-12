package tests.unit;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;
import utils.ElementUtil;

public class CheckoutTests extends BaseTest {

    @Test
    public void testConfirmCheckoutButton() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addOnesieToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();
        checkoutPage.enterFirstname("testFname");
        checkoutPage.enterLastname("testLname");
        checkoutPage.enterPostcode("AB1 2CD");
        ConfirmationPage confirmationPage = checkoutPage.confirmOrder();
        confirmationPage.clickFinishButton();

        confirmationPage.getConfirmationLogo();
        String confirmationMessage = confirmationPage.getConfirmationMessage();
        String dispatchMessage = confirmationPage.getDispatchMessage();
        confirmationPage.getBackHomeButton();

        boolean isConfirmationLogoPresent = ElementUtil.isPresent(driver, confirmationPage.getConfirmationLogo());
        boolean isBackHomeButtonPresent = ElementUtil.isPresent(driver, confirmationPage.getBackHomeButton());
        Assert.assertTrue(isConfirmationLogoPresent, "Element is not visible");
        Assert.assertTrue(isBackHomeButtonPresent, "Element is not visible");

        Assert.assertTrue(confirmationMessage.contains("Thank you for your order!"),
                "Message is " + confirmationMessage + " - not what was expected.");
        Assert.assertTrue(dispatchMessage.contains("Your order has been dispatched, and will arrive just as " +
                        "fast as the pony can get there!"),
                "Message is " + dispatchMessage + " - not what was expected.");
    }

    @Test
    public void testBackHomeButtonAfterCheckout() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addOnesieToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();
        checkoutPage.enterFirstname("testFname");
        checkoutPage.enterLastname("testLname");
        checkoutPage.enterPostcode("AB1 2CD");
        ConfirmationPage confirmationPage = checkoutPage.confirmOrder();
        confirmationPage.clickFinishButton();
        HomePage homePage1 = confirmationPage.clickBackHomeButton();
        homePage1.getProductsHeading();

        boolean isProductHeadingPresent = ElementUtil.isPresent(driver, homePage1.getProductsHeading());
        Assert.assertTrue(isProductHeadingPresent, "Element is not visible");
    }

    @Test
    public void testEmptyFirstNameField() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addOnesieToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();
        checkoutPage.enterFirstname("");
        checkoutPage.enterLastname("testLname");
        checkoutPage.enterPostcode("AB1 2CD");
        checkoutPage.confirmOrder();

        String errorMessage = checkoutPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Error: First Name is required"),
                "Message is " + errorMessage + " - not what was expected.");
    }

    @Test
    public void testEmptyLastNameField() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addOnesieToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();
        checkoutPage.enterFirstname("testFname");
        checkoutPage.enterLastname("");
        checkoutPage.enterPostcode("AB1 2CD");
        checkoutPage.confirmOrder();

        String errorMessage = checkoutPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Error: Last Name is required"),
                "Message is " + errorMessage + " - not what was expected.");
    }

    @Test
    public void testEmptyPostcodeField() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addOnesieToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();
        checkoutPage.enterFirstname("testFname");
        checkoutPage.enterLastname("testLname");
        checkoutPage.enterPostcode("");
        checkoutPage.confirmOrder();

        String errorMessage = checkoutPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Error: Postal Code is required"),
                "Message is " + errorMessage + " - not what was expected.");
    }
}

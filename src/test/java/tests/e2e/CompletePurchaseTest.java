package tests.e2e;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;
import utils.ConfigReader;
import utils.ElementUtil;

public class CompletePurchaseTest extends BaseTest {

    @Test
    public void testCompletePurchase() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addOnesieToBasket();
        homePage.addBikeLightToBasket();
        homePage.addTshirtRedToBasket();

        BasketPage basketPage = homePage.goToBasket();
        basketPage.removeTshirtRedFromBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();
        checkoutPage.enterFirstname("testFname");
        checkoutPage.enterLastname("testLname");
        checkoutPage.enterPostcode("AB1 2CD");
        ConfirmationPage confirmationPage = checkoutPage.confirmOrder();
        confirmationPage.clickFinishButton();
        HomePage homePage1 = confirmationPage.clickBackHomeButton();
        homePage1.logout();

        boolean isLoginButtonPresent = ElementUtil.isPresent(driver, loginPage.getLoginButtonLocator());

        Assert.assertTrue(isLoginButtonPresent, "Element is not visible");
    }
}
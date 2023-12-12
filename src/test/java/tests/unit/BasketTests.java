package tests.unit;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ElementUtil;

public class BasketTests extends BaseTest {

    @Test
    public void testIfBasketNumberMatchesAfterClickingOnBasket() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();
        int basketQuantityHomePage = homePage.getBasketQuantity();

        BasketPage basketPage = homePage.goToBasket();
        basketPage.getBackpackItemID();
        basketPage.getBackpackItemName();
        int basketQuantityBasketPage = basketPage.getBasketQuantity();

        Assert.assertTrue(basketQuantityHomePage == basketQuantityBasketPage);
    }

    @Test
    public void testItemNameInBasketPage() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();

        BasketPage basketPage = homePage.goToBasket();
        String backpackID = basketPage.getBackpackItemID().toString();
        String backpackName = basketPage.getBackpackItemName();

        Assert.assertTrue(backpackName.contains("Sauce Labs Backpack"),
                "Item name is " + backpackName + " - not what was expected.");
        Assert.assertTrue(backpackID.contains("item_4_title_link"),
                "Item ID is " + backpackID + " - not what was expected.");
    }

    @Test
    public void testRemoveItemFromBasketPage() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();
        homePage.addBikeLightToBasket();

        BasketPage basketPage = homePage.goToBasket();
        int basketQuantityCartPageBeforeRemove = basketPage.getBasketQuantity();
        basketPage.removeBikeLightFromBasket();
        int basketQuantityCartPageAfterRemove = basketPage.getBasketQuantity();

        Assert.assertTrue(basketQuantityCartPageAfterRemove == basketQuantityCartPageBeforeRemove - 1);
    }

    @Test
    public void testCheckoutButtonOneItem() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();

        boolean isFirstnameFieldPresent = ElementUtil.isPresent(driver, checkoutPage.getFirstnameField());
        boolean isLastnameFieldPresent = ElementUtil.isPresent(driver, checkoutPage.getLastnameField());
        boolean isPostcodeFieldPresent = ElementUtil.isPresent(driver, checkoutPage.getPostcodeField());
        boolean isContinueButtonPresent = ElementUtil.isPresent(driver, checkoutPage.getContinueButton());

        Assert.assertTrue(isFirstnameFieldPresent, "Element is not visible");
        Assert.assertTrue(isLastnameFieldPresent, "Element is not visible");
        Assert.assertTrue(isPostcodeFieldPresent, "Element is not visible");
        Assert.assertTrue(isContinueButtonPresent, "Element is not visible");
    }

    @Test
    public void testCheckoutButtonMultipleItems() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();
        homePage.addBikeLightToBasket();
        homePage.addBoltTshirtToBasket();
        homePage.addFleeceJacketToBasket();
        homePage.addOnesieToBasket();
        homePage.addTshirtRedToBasket();

        BasketPage basketPage = homePage.goToBasket();
        CheckoutPage checkoutPage = basketPage.proceedToCheckout();

        boolean isFirstnameFieldPresent = ElementUtil.isPresent(driver, checkoutPage.getFirstnameField());
        boolean isLastnameFieldPresent = ElementUtil.isPresent(driver, checkoutPage.getLastnameField());
        boolean isPostcodeFieldPresent = ElementUtil.isPresent(driver, checkoutPage.getPostcodeField());
        boolean isContinueButtonPresent = ElementUtil.isPresent(driver, checkoutPage.getContinueButton());

        Assert.assertTrue(isFirstnameFieldPresent, "Element is not visible");
        Assert.assertTrue(isLastnameFieldPresent, "Element is not visible");
        Assert.assertTrue(isPostcodeFieldPresent, "Element is not visible");
        Assert.assertTrue(isContinueButtonPresent, "Element is not visible");
    }
}

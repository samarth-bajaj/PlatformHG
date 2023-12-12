package tests.unit;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ElementUtil;

public class ShoppingTests extends BaseTest {

    @Test
    public void testAddItemToBasket() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();
        int basketQuantity = homePage.getBasketQuantity();

        boolean isBackpackRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getBackpackRFCLocator());

        Assert.assertTrue(isBackpackRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(basketQuantity == 1);
    }

    @Test
    public void testRemoveItemFromBasket() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getProperty("url");
        String username = configReader.getProperty("validUsername");
        String password = configReader.getProperty("password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(username, password);

        HomePage homePage = loginPage.clickLoginButton();
        homePage.addBackpackToBasket();
        homePage.removeBackpackFromBasket();

        boolean isBackpackATCButtonPresent = ElementUtil.isPresent(driver, homePage.getBackpackATCLocator());
        boolean isBasketQuantityPresent = ElementUtil.isPresent(driver, homePage.getBasketQuantityLocator());

        Assert.assertTrue(isBackpackATCButtonPresent, "Element is not visible");
        Assert.assertFalse(isBasketQuantityPresent, "Element is visible");
    }

    @Test
    public void testAddMultipleItemsToBasket() {
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
        int basketQuantity = homePage.getBasketQuantity();

        boolean isBackpackRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getBackpackRFCLocator());
        boolean isBikeLightRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getBikeLightRFCLocator());
        boolean isBoltTshirtRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getBoltTshirtRFCLocator());
        boolean isFleeceJacketRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getFleeceJacketRFCLocator());
        boolean isOnesieRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getOnesieRFCLocator());
        boolean isTshirtRedRFCButtonPresent = ElementUtil.isPresent(driver, homePage.getTshirtRedRFCLocator());

        Assert.assertTrue(isBackpackRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(isBikeLightRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(isBoltTshirtRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(isFleeceJacketRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(isOnesieRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(isTshirtRedRFCButtonPresent, "Element is not visible");
        Assert.assertTrue(basketQuantity == 6);
    }
}

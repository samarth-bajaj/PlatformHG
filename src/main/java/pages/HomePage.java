package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SiteItems;
import utils.WaitUtil;

public class HomePage {
    private WebDriver driver;

    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");
    private By basketLink = By.id("shopping_cart_container");
    private By productsHeading = By.className("title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage logout() {
        driver.findElement(menuButton).click();
        WaitUtil.isClickable(driver, logoutButton);
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    public HomePage clickMenu() {
        driver.findElement(menuButton).click();
        WaitUtil.isClickable(driver, logoutButton);
        return this;
    }

    public BasketPage goToBasket() {
        driver.findElement(basketLink).click();
        return new BasketPage(driver);
    }

    public int getBasketQuantity() {
        String quantityText = driver.findElement(SiteItems.BASKET_QUANTITY).getText();
        return Integer.parseInt(quantityText);
    }

    public By getProductsHeading() {
        return productsHeading;
    }

    public HomePage addBackpackToBasket() {
        driver.findElement(SiteItems.BACKPACK_ATC).click(); return this;
    }

    public HomePage removeBackpackFromBasket() {
        driver.findElement(SiteItems.BACKPACK_RFC).click(); return this;
    }

    public HomePage addBikeLightToBasket() {
        driver.findElement(SiteItems.BIKE_LIGHT_ATC).click(); return this;
    }

    public HomePage removeBikeLightFromBasket() {
        driver.findElement(SiteItems.BIKE_LIGHT_RFC).click(); return this;
    }

    public HomePage addBoltTshirtToBasket() {
        driver.findElement(SiteItems.BOLT_TSHIRT_ATC).click(); return this;
    }

    public HomePage removeBoltTshirtFromBasket() {
        driver.findElement(SiteItems.BOLT_TSHIRT_RFC).click(); return this;
    }

    public HomePage addFleeceJacketToBasket() {
        driver.findElement(SiteItems.FLEECE_JACKET_ATC).click(); return this;
    }

    public HomePage removeFleeceJacketFromBasket() {
        driver.findElement(SiteItems.FLEECE_JACKET_RFC).click(); return this;
    }

    public HomePage addOnesieToBasket() {
        driver.findElement(SiteItems.ONESIE_ATC).click(); return this;
    }

    public HomePage removeOnesieFromBasket() {
        driver.findElement(SiteItems.ONESIE_RFC).click(); return this;
    }

    public HomePage addTshirtRedToBasket() {
        driver.findElement(SiteItems.TSHIRT_RED_ATC).click(); return this;
    }

    public HomePage removeTshirtRedFromBasket() {
        driver.findElement(SiteItems.TSHIRT_RED_RFC).click(); return this;
    }

    public By getLogoutButtonLocator() {
        return logoutButton;
    }
    public By getBackpackATCLocator() { return SiteItems.BACKPACK_ATC; }
    public By getBackpackRFCLocator() { return SiteItems.BACKPACK_RFC; }
    public By getBikeLightATCLocator() { return SiteItems.BIKE_LIGHT_ATC; }
    public By getBikeLightRFCLocator() { return SiteItems.BIKE_LIGHT_RFC; }
    public By getBoltTshirtATCLocator() { return SiteItems.BOLT_TSHIRT_ATC; }
    public By getBoltTshirtRFCLocator() { return SiteItems.BOLT_TSHIRT_RFC; }
    public By getFleeceJacketATCLocator() { return SiteItems.FLEECE_JACKET_ATC; }
    public By getFleeceJacketRFCLocator() { return SiteItems.FLEECE_JACKET_RFC; }
    public By getOnesieATCLocator() { return SiteItems.ONESIE_ATC; }
    public By getOnesieRFCLocator() { return SiteItems.ONESIE_RFC; }
    public By getTshirtRedATCLocator() { return SiteItems.TSHIRT_RED_ATC; }
    public By getTshirtRedRFCLocator() { return SiteItems.TSHIRT_RED_RFC; }
    public By getBasketQuantityLocator() { return SiteItems.BASKET_QUANTITY; }
}


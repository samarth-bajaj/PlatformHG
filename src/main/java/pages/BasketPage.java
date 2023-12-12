package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SiteItems;

public class BasketPage {
    private WebDriver driver;

    private By proceedToCheckoutButton = By.id("checkout");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getBasketQuantity() {
        String quantityText = driver.findElement(SiteItems.BASKET_QUANTITY).getText();
        return Integer.parseInt(quantityText);
    }

    public CheckoutPage proceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
        return new CheckoutPage(driver);
    }

    public By getBackpackItemID() { return SiteItems.BACKPACK_ITEM_ID; }
    public By getBikeLightItemID() { return SiteItems.BIKE_LIGHT_ITEM_ID; }
    public By getBoltTshirtItemID() { return SiteItems.BOLT_TSHIRT_ITEM_ID; }
    public By getFleeceJacketItemID() { return SiteItems.FLEECE_JACKET_ITEM_ID; }
    public By getOnesieItemID() { return SiteItems.ONESIE_ITEM_ID; }
    public By getTshirtRedItemID() { return SiteItems.TSHIRT_RED_ITEM_ID; }

    public String getBackpackItemName() { return SiteItems.BACKPACK_ITEM_NAME; }
    public String getBikeLightItemName() { return SiteItems.BIKE_LIGHT_ITEM_NAME; }
    public String getBoltTshirtItemName() { return SiteItems.BOLT_TSHIRT_ITEM_NAME; }
    public String getFleeceJacketItemName() { return SiteItems.FLEECE_JACKET_ITEM_NAME; }
    public String getOnesieItemName() { return SiteItems.ONESIE_ITEM_NAME; }
    public String getTshirtRedItemName() { return SiteItems.TSHIRT_RED_ITEM_NAME; }

    public BasketPage removeBackpackFromBasket() {
        driver.findElement(SiteItems.BACKPACK_RFC).click(); return this;
    }

    public BasketPage removeBikeLightFromBasket() {
        driver.findElement(SiteItems.BIKE_LIGHT_RFC).click(); return this;
    }

    public BasketPage removeBoltTshirtFromBasket() {
        driver.findElement(SiteItems.BOLT_TSHIRT_RFC).click(); return this;
    }

    public BasketPage removeFleeceJacketFromBasket() {
        driver.findElement(SiteItems.FLEECE_JACKET_RFC).click(); return this;
    }

    public BasketPage removeOnesieFromBasket() {
        driver.findElement(SiteItems.ONESIE_RFC).click(); return this;
    }

    public BasketPage removeTshirtRedFromBasket() {
        driver.findElement(SiteItems.TSHIRT_RED_RFC).click(); return this;
    }
}
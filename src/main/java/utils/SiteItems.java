package utils;

import org.openqa.selenium.By;

public class SiteItems {

    //Item names

    public static final String BACKPACK_ITEM_NAME = "Sauce Labs Backpack";
    public static final String BIKE_LIGHT_ITEM_NAME = "Sauce Labs Bike Light";
    public static final String BOLT_TSHIRT_ITEM_NAME = "Sauce Labs Bolt T-Shirt";
    public static final String FLEECE_JACKET_ITEM_NAME = "Sauce Labs Fleece Jacket";
    public static final String ONESIE_ITEM_NAME = "Sauce Labs Onesie";
    public static final String TSHIRT_RED_ITEM_NAME = "Test.allTheThings() T-Shirt (Red)";

    //Item IDs when on the Basket page

    public static final By BACKPACK_ITEM_ID = By.id("item_4_title_link");
    public static final By BIKE_LIGHT_ITEM_ID = By.id("item_0_title_link");
    public static final By BOLT_TSHIRT_ITEM_ID = By.id("item_1_title_link");
    public static final By FLEECE_JACKET_ITEM_ID = By.id("item_5_title_link");
    public static final By ONESIE_ITEM_ID = By.id("item_2_title_link");
    public static final By TSHIRT_RED_ITEM_ID = By.id("item_3_title_link");

    //Buttons - ATC (Add To Cart), RFC (Remove From Cart)

    public static final By BACKPACK_ATC = By.id("add-to-cart-sauce-labs-backpack");
    public static final By BACKPACK_RFC = By.id("remove-sauce-labs-backpack");
    public static final By BIKE_LIGHT_ATC = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By BIKE_LIGHT_RFC = By.id("remove-sauce-labs-bike-light");
    public static final By BOLT_TSHIRT_ATC = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    public static final By BOLT_TSHIRT_RFC = By.id("remove-sauce-labs-bolt-t-shirt");
    public static final By FLEECE_JACKET_ATC = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public static final By FLEECE_JACKET_RFC = By.id("remove-sauce-labs-fleece-jacket");
    public static final By ONESIE_ATC = By.id("add-to-cart-sauce-labs-onesie");
    public static final By ONESIE_RFC = By.id("remove-sauce-labs-onesie");
    public static final By TSHIRT_RED_ATC = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    public static final By TSHIRT_RED_RFC = By.id("remove-test.allthethings()-t-shirt-(red)");

    //Cart Quantity

    public static final By BASKET_QUANTITY = By.className("shopping_cart_badge");

}

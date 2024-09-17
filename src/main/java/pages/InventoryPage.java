package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By burgerMenuButton = By.id("menu_button_container");
    By shoppingCartContainer = By.id("shopping_cart_container");
    By shoppingCartBadgeCounter = By.xpath("//*[@id='shopping_cart_container']/a/span");
    By sortDropDownDownButton = By.className(".product_sort_");

/*    public String getShoppingCartBadgeCounter() {
        try {
            WebElement cartBagdeCounter = driver.findElement(shoppingCartBadgeCounter);
            return cartBagdeCounter.getText();
        } catch (NoSuchElementException e) {
            System.out.println("The Shopping cart is currently empty" + e);
            return "0";
        }
    }*/

    public void verifyCartItemsUpdateCorrectly() {
        List<WebElement> elements = driver.findElements(shoppingCartBadgeCounter);
        if (!elements.isEmpty()) {
            System.out.println("The Shopping cart badge updated after adding items");
        } else {
            System.out.println("The Shopping cart is currently empty");
        }
    }

    public void addToCartDesiredProduct(String criteria) {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        for(WebElement product:products) {
            String productName = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
           // System.out.println(productName);
            if(productName.contains(criteria)) {
                WebElement addtoCart = product.findElement(By.xpath(".//button[contains(text(),'ADD TO CART')]"));
                addtoCart.click();
                return;
            }
        }
        System.out.println(criteria + "desired product not found");
    }

    public void removeProductFromCart(String criteria) {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        for (WebElement product : products) {
            String productName = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            // System.out.println(productName);
            if (productName.contains(criteria)) {
                WebElement removeProduct = product.findElement(By.xpath(".//button[contains(text(),'REMOVE')]"));
                removeProduct.click();
                return;
            }
        }
    }

    public void clickOnShoppingCart(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer));
        driver.findElement(shoppingCartContainer).click();
    }


}





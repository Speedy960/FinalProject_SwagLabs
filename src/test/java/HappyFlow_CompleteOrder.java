import org.apache.commons.lang3.builder.EqualsBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HappyFlow_CompleteOrder {


    private WebDriver driver;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;

    public HappyFlow_CompleteOrder() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");

        this.driver =  new ChromeDriver(options);
        driver.manage().window().maximize();

        this.inventoryPage = new InventoryPage(driver);
        this.loginPage = new LoginPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.overviewPage = new OverviewPage(driver);
    }

    @Test

    public void fullOrderTest(){
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.loginCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.addToCartDesiredProduct("Fleece Jacket");
        inventoryPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputCheckoutInfo("XYZ", "ABC", "123456");
        checkoutPage.continueButton();
        overviewPage.clickFinishButton();
        Assert.assertEquals(overviewPage.getCompleteMessage(),"THANK YOU FOR YOUR ORDER");
    }
}

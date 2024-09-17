import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCartTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public AddToCartTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
    }

    @Test

    public void metodaTestAddToCart() {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.loginCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.addToCartDesiredProduct("Fleece Jacket");
        inventoryPage.verifyCartItemsUpdateCorrectly();
    }

    @Test

    public void metodaRemoveProductFromCart() {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.loginCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.addToCartDesiredProduct("Backpack");
        inventoryPage.removeProductFromCart("Backpack");
        inventoryPage.verifyCartItemsUpdateCorrectly();
    }

}
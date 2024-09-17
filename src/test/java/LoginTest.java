import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginTest() {
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Test

    public void metodaTestLoginValid(){
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.loginCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
        driver.quit();
    }

    @Test
    public void metodaTestLoginInvalid(){
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.loginCredentials("standard_userr", "secret_sauce");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
}


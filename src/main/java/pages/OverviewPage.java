package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OverviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By finishButton = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]/a[2]");
    // By cancelButton
    By completedOrderMessage = By.xpath("//*[@class='complete-header']");

    public void clickFinishButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
        driver.findElement(finishButton).click();
    }

    public String getCompleteMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(completedOrderMessage));
        return driver.findElement(completedOrderMessage).getText();
    }
}

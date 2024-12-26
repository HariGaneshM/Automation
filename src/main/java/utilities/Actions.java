package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Actions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean waitForElementTextToBe(By locator, String string) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, string));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(waitForElementToBeVisible(locator)));
    }
    
    public void waitForElementToBeInVisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickOnElement(By locator) {
        waitForElementToBeClickable(locator).click();
    }
    
    public String getText(By locator) {
    	return waitForElementToBeVisible(locator).getText();
    }
    
    public void EnterText(By locator, String text) {
    	waitForElementToBeVisible(locator).sendKeys(text);
    }
}

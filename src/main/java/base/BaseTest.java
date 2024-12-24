package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	private ThreadLocal<WebDriver> threadsafeDriver = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		threadsafeDriver.set(driver);
	}
	
	public WebDriver getDriver() {
		return threadsafeDriver.get();
	}
	
	public void goTo(String url) {
		getDriver().get(url);
	}
	
	public void navigateTo(String url) {
		getDriver().navigate().to(url);
	}
	
	@AfterMethod
	public void closeDriver() {
		getDriver().quit();
		threadsafeDriver.remove();
	}
}

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utilities.ConfigReader;

public class BaseTest {
	
	private ThreadLocal<WebDriver> threadsafeDriver = new ThreadLocal<WebDriver>();
	
	@BeforeSuite
	public void readPropertiesFile() {
		ConfigReader.readConfigs();
	}
	
	@BeforeMethod
	public void setDriver() {
		WebDriver driver = null;
		if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (ConfigReader.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (ConfigReader.getProperty("browser").equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
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

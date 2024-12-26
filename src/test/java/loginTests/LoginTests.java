package loginTests;

import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Utilities;

public class LoginTests extends BaseTest {
	
	@Test(retryAnalyzer = Utilities.class)
	public void SampleTest() {
		getDriver();
	}
}

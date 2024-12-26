package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties = new Properties();
	
	public static void readConfigs() {
		try {
			FileInputStream file = new FileInputStream("src/main/resources/configs.properties");
			properties.load(file);
		} catch (IOException e) {
			if (e instanceof java.io.FileNotFoundException) {
				System.err.println("configs.properties file is not found at src/main/resources/");
			}
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}

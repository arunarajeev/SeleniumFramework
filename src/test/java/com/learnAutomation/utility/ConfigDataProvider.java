package test.java.com.learnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	public Properties pro;
	public ConfigDataProvider() {

		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();	
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load Config File"+e.getMessage());
		}
	}

	public String getDataFromConfig(String key) {
		return pro.getProperty(key);
	}
	public String getEmail() {
		
		return pro.getProperty("email");
	}
	public String getPassword() {
	
		return pro.getProperty("password");
	}
	public String getBrowser() {
		
		return pro.getProperty("Browser");
	}
	public String getURL() {

		return pro.getProperty("qaURL");
	}
}

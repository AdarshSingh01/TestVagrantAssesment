package com.assesment.testvagrant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
public static WebDriver driver;

static File file = new File(
		"./Utility/configuration.properties");
static FileInputStream fis = null;
public static Properties prop = new Properties();

static {
	try {
		fis = new FileInputStream(file);

	} catch (FileNotFoundException e) {
		e.printStackTrace();

	}
	try {
		prop.load(fis);
	} catch (IOException el) {
		el.printStackTrace();

	}
}
	
	@BeforeMethod
	public static void intializeDriver() {
		System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		int i=Integer.parseInt(prop.getProperty("IMPLICITWAIT"));
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public static void closeBrowser() {
		driver.quit();
	}
	
}

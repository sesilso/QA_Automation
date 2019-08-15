package driverSettings;

import org.testng.annotations.Test;

import addons.Mailsender;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Chrome {
	
	protected static WebDriver driver;
	
	@BeforeTest
	public void SetUp() throws IOException {
				
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@AfterTest
	public void TearDown() throws IOException {
		driver.manage().deleteAllCookies();
		driver.quit();
		Properties cfgprop= new Properties();
		FileInputStream filestream = new FileInputStream("./src/test/resources/ebay.properties");
		cfgprop.load(filestream);
		String ToEmail = cfgprop.getProperty("sendRestultsTo");
		Mailsender ms = new Mailsender();
		ms.SendMail(ToEmail);
	}
	
}

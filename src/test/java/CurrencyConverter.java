package com.SQS;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sergio Lopez
 *
 */
public class CurrencyConverter {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Sergio/workspace/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.xe.com/currencyconverter/");		
	}
	
	@Test
	public void VerifyConversion(){		
						
		WebElement title = driver.findElement(By.xpath("//*[@id='contentL']/div[1]/h1"));
		assertTrue(title.getText().equals("XE Currency Converter"));
		
		WebElement breadCrumb = driver.findElement(By.xpath("//*[@id='bCrumb']/p"));
		assertTrue(breadCrumb.getText().equals("Home > XE Currency Converter - Live Rates"));
		
		WebElement ribbonHome = driver.findElement(By.xpath("//*[@id='nav']/ul/li[1]/a"));
		assertTrue(ribbonHome.getText().equals("Home"));
		
		WebElement ribbonTools = driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/a"));
		assertTrue(ribbonTools.getText().equals("Tools"));
		
		WebElement bottomMenuTools = driver.findElement(By.xpath("//*[@id='footerContent']/ul[1]/li[1]/h3"));
		assertTrue(bottomMenuTools.getText().equals("Tools"));
		
		//Select conversionDropdownSRC = new Select (driver.findElement(By.xpath("//*[@id='from']")));
		//conversionDropdownSRC.selectByValue("EUR");
		WebElement conversionDropdownSRC = driver.findElement(By.xpath("//*[@id='from']"));
		conversionDropdownSRC.sendKeys("EUR");
		conversionDropdownSRC.sendKeys(Keys.ENTER);
		
		WebElement conversionDropdownDES = driver.findElement(By.xpath("//*[@id='to']"));
		conversionDropdownDES.sendKeys("POUND");
		conversionDropdownDES.sendKeys(Keys.ENTER);
		
		WebElement conversionButton = driver.findElement(By.xpath("//*[@id='ucc_go_btn_svg']"));
		conversionButton.click();
		
		WebElement conversionRes = driver.findElement(By.xpath("//*[@id='ucc-container']/span[2]/span[2]"));
		
		//This assert should be customized and it should get the Pound rate on that moment from an external system
		assertTrue(conversionRes.getText().equals(conversionRes.getText()));		
	}

	@AfterClass
	public static void afterClass()
	{
		driver.quit();				
	}	
	
}

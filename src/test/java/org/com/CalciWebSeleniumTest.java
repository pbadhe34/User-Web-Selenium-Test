package org.com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Node;

import junit.framework.Assert;

//This test class is designed to test he user web page UI
public class CalciWebSeleniumTest {
	
     static  WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Sama-Java-Training\\Selenium\\Browser-Drivers\\chromedriver_win32\\chromedriver.exe");  
		
		System.setProperty("webdriver.ie.driver", 
				"C:\\Sama-Java-Training\\Selenium\\Browser-Drivers"
				+ "\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");  
		
	 	
		System.setProperty("webdriver.edge.driver", 
				"C:\\Sama-Java-Training\\Selenium\\Browser-Drivers"
				+ "\\edgedriver_win64\\msedgedriver.exe");  
		
		 
	}
	
	@Before
	public void init() {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--window-size=1920,1200");
      // System.out.println("User_web_Selenium_test.init()");
		// driver = new ChromeDriver(); 

		InternetExplorerOptions options = new InternetExplorerOptions();
		options.ignoreZoomSettings();
		
		// driver = new InternetExplorerDriver(options);
		
		//EdgeOptions options = new EdgeOptions();
		//options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Beta\\Application\\msedge.exe");

		 driver = new EdgeDriver();
 
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //maximize window
		  //driver.manage().window().maximize();
		  driver.get("http://localhost:8080/CalciWeb/");
	}
	@After
	public void closeTest(){
		 driver.quit();	  
	}
	
	@AfterClass
	public static void close() {
		 
	}
	
	  
	@Test
	public void verifySumOperation() {
	WebElement inputFirstElement = 	driver.
			findElement(By.xpath("/html/body/div/div/form/input[1]"));
	
	WebElement inputSecondElement = 	driver.
			findElement(By.xpath("/html/body/div/div/form/input[2]"));
	 	int num1 = 20;
	 	int num2 = 40;
	inputFirstElement.sendKeys(""+num1);
	inputSecondElement.sendKeys(""+num2);
	
	WebElement dropDownSelect = 	driver.
			findElement(By.cssSelector("body > div > div > form > select"));
	 Select operation = new Select(dropDownSelect);
	 
	 List<WebElement> elements = operation.getOptions();	 
	 for(WebElement elm : elements)
		 System.out.println(elm.getText());	
	 
	 operation.selectByVisibleText("+");	 
	 WebElement goBtn = 	driver.
				findElement(By.id("gobutton"));
	 goBtn.click();
	 
	 WebElement resultCell= 	driver.
				findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[3]"));
	  
	 String text = resultCell.getText();
	String expected = ""+(num1+num2);	
	Assert.assertEquals(expected, text);   
	 
	}
	
	@Test
	public void verifySumForNgativeValues() {
	WebElement inputFirstElement = 	driver.
			findElement(By.xpath("/html/body/div/div/form/input[1]"));
	
	WebElement inputSecondElement = 	driver.
			findElement(By.xpath("/html/body/div/div/form/input[2]"));
	 	int num1 = -23;
	 	int num2 = 45;
	inputFirstElement.sendKeys(""+num1);
	inputSecondElement.sendKeys(""+num2);
	
	WebElement dropDownSelect = 	driver.
			findElement(By.cssSelector("body > div > div > form > select"));
	 Select operation = new Select(dropDownSelect);
	 
	 List<WebElement> elements = operation.getOptions();	 
	 for(WebElement elm : elements)
		 System.out.println(elm.getText());	
	 
	 operation.selectByVisibleText("+");	 
	 WebElement goBtn = 	driver.
				findElement(By.id("gobutton"));
	 goBtn.click();
	 
	 WebElement resultCell= 	driver.
				findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[3]"));
	  
	 String text = resultCell.getText();
	String expected = ""+22;	
	Assert.assertEquals(expected, text);   
	 
	}
	
	 
	
	
	

}

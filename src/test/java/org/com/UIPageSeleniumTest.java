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
public class UIPageSeleniumTest {
	
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

		/*
		 * InternetExplorerOptions options = new InternetExplorerOptions();
		 * options.ignoreZoomSettings();
		 */
		// driver = new InternetExplorerDriver(options);
		
		//EdgeOptions options = new EdgeOptions();
		//options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Beta\\Application\\msedge.exe");

		 driver = new EdgeDriver();
 
		
		 driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
		  
		  //maximize window
		  //driver.manage().window().maximize();
		  driver.get("http://localhost:8080/UI-Page/ui.html");
	}
	@After
	public void closeTest(){
		 driver.quit();	  
	}
	
	@AfterClass
	public static void close() {
		 
	}
	
	  
	@Test
	public void verifyRadioButtons() throws InterruptedException {
	WebElement firstRadioElement = 	driver.
			findElement(By.id("html"));	
	boolean selected = firstRadioElement.isSelected();	
 	if(selected == false)
		firstRadioElement.click();
		
	 Thread.sleep(1500);	
	
	WebElement submit = 	driver.
			findElement(By.xpath("/html/body/form[1]/input[4]"));
	
	submit.click();
	
	String url = driver.getCurrentUrl();
	int lg = url.indexOf('=');
	String data = url.substring(lg+1);
	System.out.println("The url value is "+url);
	System.out.println("The lang  value is "+data);
	  	  
	String expected = "HTML-Page" ;
	Assert.assertEquals(expected, data);   
	 
	}
	
	@Test
	public void verifyRadioButtonCSS() throws InterruptedException {
	WebElement firstRadioElement = 	driver.
			findElement(By.id("css"));	
	boolean selected = firstRadioElement.isSelected();	
 	if(selected == false)
		firstRadioElement.click();
		
	 Thread.sleep(1500);
	
	
	
	
	WebElement submit = 	driver.
			findElement(By.xpath("/html/body/form[1]/input[4]"));
	
	submit.click();
	
	String url = driver.getCurrentUrl();
	int lg = url.indexOf('=');
	String data = url.substring(lg+1);
	System.out.println("The url value is "+url);
	System.out.println("The lang  value is "+data);
	  
	String expected = "CSS" ;
	Assert.assertEquals(expected, data);   
	 
	}
	
	
	@Test
	public void verifyRadioButtonJS() throws InterruptedException {
	WebElement firstRadioElement = 	driver.
			findElement(By.id("javascript"));	
	boolean selected = firstRadioElement.isSelected();	
 	if(selected == false)
		firstRadioElement.click();
		
	 Thread.sleep(1000);
	
	
	
	WebElement submit = 	driver.
			findElement(By.xpath("/html/body/form[1]/input[4]"));
	
	submit.click();
	
	/*
	 * WebElement radioTextElement = driver. findElement(By.name("lang"));
	 * 
	 * String value = radioTextElement.getAttribute("value");
	 */
	  
	String url = driver.getCurrentUrl();
	int lg = url.indexOf('=');
	String data = url.substring(lg+1);
	System.out.println("The url value is "+url);
	System.out.println("The lang  value is "+data);
	String expected = "JavaScript" ;
	Assert.assertEquals(expected, data);   
	 
	}
	 
	
	
	

}

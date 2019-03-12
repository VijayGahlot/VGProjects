package com.mmt.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mmt.qa.util.TestUtil;

     public class BaseMMT {
    	 
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;
   
    

     public BaseMMT () {
    	 
     try {
     prop=new Properties();
     
     FileInputStream	ip = new FileInputStream(System.getProperty("user.dir")+ "/config.properties");
     
	 prop.load(ip);
	 
    } catch (FileNotFoundException e) {
	e.printStackTrace();
    } catch (IOException e) {
	e.printStackTrace();
    }
}

public static void initialization() throws IOException
{
	
	String browserName= prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.gahlot\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//Create a instance of ChromeOptions class to handle push notification of the site
		
		options.addArguments("--disable-notifications");
		//Adding Chrome switch to disable notification 
		
		//Passing ChromeOptions instance to ChromeDriver Constructor
	        driver = new ChromeDriver(options);
	        wait = new WebDriverWait(driver, 40);
	       
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
	
	//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//driver.get("https://www.makemytrip.com/");
	driver.get(prop.getProperty("url"));
	takeScreenshot("Make_My_trip_");
	
	
	
	
	
	}
public static void takeScreenshot(String fileName) throws IOException
{
	//take screenshot and store it as a file format
	//conveting the driver as TakeScreenshot interface(typecasting)
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//copy the screenshot as a file on a desired location using method copyfile
	FileUtils.copyFile(file, new File("C:\\Users\\vijay.gahlot\\eclipse-workspace\\threePillar\\src\\main\\java\\Screenshots"+fileName+".png"));
}
	
	
}

package com.hrm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hrm.qa.util.TestUtil;
import com.hrm.qa.util.WebEventListener;

public class TestBase {
    
   public static WebDriver driver;
  public  static Properties prop;
  
  
  
  public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
   public TestBase() throws Exception{
       try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\nagneon\\HRMPOMHYBRID\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
		prop.load(ip);
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
       
   }
   
   public static void intialisation() throws Exception{
       
       String browsername = prop.getProperty("browser");
       if(browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "D://QAplanet//downloads//chromedriver.exe");
                driver=new ChromeDriver();
       }
       else if(browsername.equals("ff")){
		System.setProperty("webdriver.chrome.driver", "D://QAplanet//downloads//chromedriver.exe");
                driver=new FirefoxDriver();
       }
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
                driver.get(prop.getProperty("url"));
                
                e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
       
       
   }

}

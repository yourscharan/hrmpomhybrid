package com.hrm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.Base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LeavePage;
import com.hrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
    
    LoginPage loginpage;
    HomePage homepage;
    LeavePage leavepage;

    public HomePageTest() throws Exception {
	super();
    }
    
    @BeforeMethod
    public void setup() throws Exception{
	
	intialisation();
	loginpage=new LoginPage();
	leavepage=new LeavePage();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	//this login method is returning homepage class object so we are 
	//assing homepage object refernece
    }
    
    
    @Test(priority=1)
    public void verifyHomePageTitleTest(){
	String title=homepage.verifyHomePageTitle();
	Assert.assertEquals(title, "OrangeHRM");
    }
    
    @Test(priority=2)
    public void verifyUsernameTest(){
	//homepage.verifyUsername();
	Assert.assertTrue(homepage.verifyUsername());
    }
    
    @Test(priority=3)
    public void verifyLeavelinkTest() throws Exception{
	leavepage=homepage.clickonLeavelink();
    }
    
    @AfterMethod
    public void teardown(){
	driver.quit();
    }

}

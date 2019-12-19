package com.hrm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.Base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase  {
    
    LoginPage loginpage;
    HomePage homepage;

    public LoginPageTest() throws Exception {
	super();
    }
    
    @BeforeMethod
    public void setup() throws Exception{
	
	intialisation();
	loginpage=new LoginPage();
	
    }

    @Test(priority=1)
    public void loginpageTitleTest(){
	String title=loginpage.validateLoginTitle();
	Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
    }
    
    @Test(priority=2)
    public void hrmlogoTest(){
	boolean flag=loginpage.validateHRMlogo();
	Assert.assertTrue(flag);
    }
    
    @Test(priority=3)
    public void loginTest() throws Exception{
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	//here login method is returning homepage class object(we already write this
	//in loginpage.java so we r assining HomePaage object 'homepage' here
    }
    
    @AfterMethod
    public void teardown(){
	driver.quit();
    }
    
}

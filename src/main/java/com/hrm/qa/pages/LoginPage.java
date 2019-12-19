package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.Base.TestBase;

public class LoginPage extends TestBase{

    public LoginPage() throws Exception {
	super();
	PageFactory.initElements(driver, this);
	//all the current class webelement var's we are intialising with
	// the help of driver and this keyword
    }
    
    //pagefactory or object reposit
    
    @FindBy(name="txtUserName")
    WebElement username;
    
    @FindBy(name="txtPassword")
    WebElement password;
    
    @FindBy(name="Submit")
    WebElement loginbtn;
    
    @FindBy(xpath="/html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/img")
    WebElement hrmlogo;
    
    //actions
    public String validateLoginTitle(){
	return driver.getTitle();
    }
    
   public boolean validateHRMlogo(){
      return hrmlogo.isDisplayed();
   }

   public HomePage login(String un,String pwd) throws Exception{
       username.sendKeys(un);
       password.sendKeys(pwd);
       loginbtn.click();
       //after clicking loginbtn we r landing on homepage so
       //return type of login page is homepage class object ideally
       //so we r givng return type as HomePage
       return new HomePage();
   }
   
}

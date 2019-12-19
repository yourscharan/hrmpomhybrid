package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.Base.TestBase;

public class HomePage extends TestBase {

    public HomePage() throws Exception {
	super();
	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//ul[@id='option-menu']/li")
    WebElement usernameLabel;
    
    @FindBy(linkText="PIM")
    WebElement PIMlink;
    
    @FindBy(linkText="Add Employee")
    WebElement addemp;
    
    @FindBy(linkText="Admin")
    WebElement Adminlink;
    
    @FindBy(linkText="Leave")
    WebElement Leavelink;
    
    public String verifyHomePageTitle(){
	return driver.getTitle();
    }
    
    public boolean verifyUsername(){
	return usernameLabel.isDisplayed();
    }
    
    public LeavePage clickonLeavelink() throws Exception{
	Leavelink.click();
	return new LeavePage();
    }
    
    public PimPage clickonPIMlink() throws Exception{
	PIMlink.click();
	return new PimPage();
    }
    
    public AdminPage clickonAdminlink() throws Exception{
	Adminlink.click();
	return new AdminPage();
    }
    
    
    public void clickonAddemp(){
	Actions act = new Actions(driver);
	act.moveToElement(PIMlink).build().perform();
	addemp.click();
	
    }
    
}

package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.Base.TestBase;

public class PimPage extends TestBase {

    public PimPage() throws Exception {
	super();
	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@class='mainHeading']/h2")
    WebElement pimpagelabel;
    
    /*@FindBy(name="txtEmpLastName")
    WebElement lname;
    
    @FindBy(name="txtEmpFirstName")
    WebElement fname;
    
    @FindBy(name="txtEmpMiddleName")
    WebElement mname;
    
    @FindBy(name="txtEmpNickName")
    WebElement nname;  
   @FindBy(xpath="/html/body/form/div/div[1]/div[2]/div[2]/input[1]")
    WebElement objsave;*/
    
    @FindBy(name="txtEmpLastName")
    WebElement lname1;
    
    @FindBy(name="txtEmpFirstName")
    WebElement fname1;
    
    @FindBy(name="txtEmpMiddleName")
    WebElement mname1;
    
    @FindBy(name="txtEmpNickName")
    WebElement nname1;  
   @FindBy(xpath="/html/body/form/div/div[1]/div[2]/div[2]/input[1]")
    WebElement objsave1;
    
    ////td[text()='6613']/ancestor::tr[@class='odd']//following-sibling::td/input
    
    
   public boolean verifyPIMpageLabel(){
      return pimpagelabel.isDisplayed();
   }
   
   public void selectEmployeebyID(String id){
       
       
       driver.findElement(By.xpath("//td[contains(text(),'"+id+"')]/parent::tr//following-sibling::td/input")).click();
       
       
   }
    
   
   public void createNewEmp(String ltname,String ftname,String mdname,String nkname){
       lname1.sendKeys(ltname);
       fname1.sendKeys(ftname);
       mname1.sendKeys(mdname);
       nname1.sendKeys(nkname);
       objsave1.click();
       
   }
   
}

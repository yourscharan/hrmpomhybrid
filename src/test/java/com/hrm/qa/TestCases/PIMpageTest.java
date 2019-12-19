package com.hrm.qa.TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.Base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.PimPage;
import com.hrm.qa.util.TestUtil;

public class PIMpageTest extends TestBase {

      LoginPage loginpage;
      HomePage homepage;
      PimPage pimpage;
      TestUtil testutil;//for siwtch frame method
      String sheetname="addemp"; //hasto mathc with excel sheetname
    
    public PIMpageTest() throws Exception {
	super();
	// TODO Auto-generated constructor stub
    }

    @BeforeMethod
    public void setup() throws Exception{
	
	intialisation();
	loginpage=new LoginPage();
	testutil=new TestUtil();
	pimpage=new PimPage();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	// pimpage=homepage.clickonPIMlink();
	//testutil.switchToFrame();

	//this login method is returning homepage class object so we are 
	//assing homepage object refernece
    }
    
    @Test(priority=1)
    public void verifyPIMpageLabelTest(){
	//pimpage.verifyPIMpageLabel(); (or)
	//Assert.assertTrue(pimpage.verifyPIMpageLabel()); or
	testutil.switchToFrame();
	Assert.assertTrue(pimpage.verifyPIMpageLabel(),"PIM page label is wrong");
	
	
    }
    
    @Test(priority=2)
    public void selectemployeebyIDTest() throws Exception{
	testutil.switchToFrame();
	pimpage.selectEmployeebyID("6647");
	Thread.sleep(2000);
	}
    
    @Test(priority=3)
    public void selectMultiEmpIDSTest() throws Exception{
	testutil.switchToFrame();
	pimpage.selectEmployeebyID("6651");
	pimpage.selectEmployeebyID("6653");
	pimpage.selectEmployeebyID("6655");
	pimpage.selectEmployeebyID("6656");
	Thread.sleep(2000);
    }
    
    
    
    @DataProvider
    public Object[][] getHrmTestdata() throws EncryptedDocumentException, IOException, InvalidFormatException{
	//TestUtil.getTestData(sheetname);
	
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
    }
    
    @Test(priority=4,dataProvider="getHrmTestdata")
    public void createnewempTest(String Lastname,String Firstname,String Middlename,String Nickname) throws Exception{
	homepage.clickonAddemp();
	testutil.switchToFrame();
	Thread.sleep(2000);
	pimpage.createNewEmp(Lastname, Firstname, Middlename, Nickname);
    }
    
    
    
   /* @Test
    public void createnewempTest() throws Exception{
	homepage.clickonAddemp();
	testutil.switchToFrame();
	Thread.sleep(2000);
	pimpage.createNewEmp("nag", "royal", "charan", "krish");
    }*/
    
    @AfterMethod
    public void teardown(){
	driver.quit();
    }

    
}

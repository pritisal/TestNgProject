package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.SignInPageObject;
import Resources.baseClass;

public class VerifySignIn extends baseClass {
	
	
	@Test(dataProvider="demo")
	public void enterCredential(String username,String password) throws InterruptedException {
		SignInPageObject spo = new SignInPageObject(driver);
		spo.enterusername().sendKeys(username);
		spo.enterpassword().sendKeys(password);
		spo.clickonLogin().click();
		Thread.sleep(2000);
		
		
		String actual=driver.findElement(By.xpath("//div[@id='error']")).getText();
		String Expected="please check your username and password.If you still can't log in contact your saleforce admin ";  //pass
		//String Expected="plea check your username and password.If you still can't log in contact your saleforce admin ";//if we change in expected mesg then --fail
		
		//Assert.assertEquals(actual,Expected);//hard assert--not printing statment after testcase fail-hello
		
		SoftAssert sp=new SoftAssert();//soft assert---print statement after test case fail-hello
		sp.assertEquals(actual, Expected);
		
		System.out.println("hello");//if script fail due to expected result not match then not printing the statement
		sp.assertAll();//we need to add always at the end
		
	}

	
	@DataProvider
	public Object[][]demo(){
		Object[][] data=new Object[2][2];
		
		data[0][0]="test1@gmail.com";
		data[0][1]="Secure123";
		
		
		data[1][0]="test2@gmail.com";
		data[1][1]="Secure456";
		
		return data;
		
		
	}
}

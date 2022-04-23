package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjectModel.SignInPageObject;
import PageObjectModel.SignUpPageObject;
import Resources.baseClass;

public class VerifySignUp extends baseClass {

	@Test
	public void enterdata() throws InterruptedException {
		
		SignInPageObject spo = new SignInPageObject(driver);
		spo.opensignuppage().click();
		Thread.sleep(5000);
		
		SignUpPageObject up=new SignUpPageObject(driver);
		up.enterfirstname().sendKeys("priti");
		up.enterlastname().sendKeys("salunkhe");
		
		Select s=new Select(up.selectEmployees());
		Thread.sleep(5000);
		s.selectByIndex(1);
		Thread.sleep(5000);
		
	}
}

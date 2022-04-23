package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObject {

	public WebDriver driver;

	
	private By firstname = By.xpath("//input[@name='UserFirstName']");
	private By lastname = By.xpath("//input[@name='UserLastName']");
	private By employees=By.xpath("//select[@name='CompanyEmployees']");
	
	public SignUpPageObject(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public WebElement enterfirstname() {
		return driver.findElement(firstname);
	}
	
	public WebElement enterlastname() {
		return driver.findElement(lastname);
	}
	
	public WebElement selectEmployees() {
		return driver.findElement(employees);
	}

}

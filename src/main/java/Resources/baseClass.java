package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public WebDriver driver;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {
		// to read the properties files
		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");

		// to access the properties
		  prop = new Properties();
		prop.load(Fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().browserVersion("79.0.9").setup();--specific version
			driver = new ChromeDriver();
			
		} 
		else if (browserName.equals("firefox")) {
			// firefox code
		} 
		else if (browserName.equals("IE")) {
			// IE code
		}

		else {
			System.out.println("you should choose any one of above browser");

		}
		return driver;
	}

	@BeforeMethod
	public void launchBrowser() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
		}
}

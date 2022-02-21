package listnersashot;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static RemoteWebDriver driver;//instance variable create multiple copy and static create single copy of object 

	@BeforeMethod
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://www.testingshastra.com");
	}
}
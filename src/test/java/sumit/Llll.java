package sumit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Llll {
	FirefoxDriver driver;
	@BeforeMethod
	public void launchBrowser() {
WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		driver.get("https://testingshastra.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyListOfCoursesWhenHoveredOnCoursesTab() {

		Actions action = new Actions(driver);
		WebElement courses = driver.findElement(By.xpath("//a[contains(text(), 'Courses')]"));
		action.moveToElement(courses).perform();
		List<WebElement> crs = driver.findElements(
				By.xpath("//a[contains(text(),'Courses')]/following-sibling::ul/li[contains(@id,'menu-item')]"));
		for (WebElement webElement : crs) {
			System.out.println(webElement.getText());

		}

	}

	@Test
	public void verifyUserRedirectsOnRecentPlacementPageWhileClicked() {

		driver.findElement(By.xpath("//a[contains(text(), 'Recent Placements')]"));
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

}

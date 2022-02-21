package sumit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoMaven {
	@Test
	public void verifyListOfCoursesWhenHoveredOnCoursesTab() {
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://testingshastra.com");
		Actions action = new Actions(driver);
		WebElement courses = driver.findElement(By.xpath("//a[contains(text(), 'Courses')]"));
		action.moveToElement(courses).perform();
		List<WebElement> crs = driver.findElements(
				By.xpath("//a[contains(text(),'Courses')]/following-sibling::ul/li[contains(@id,'menu-item')]"));
		for (WebElement webElement : crs) {
			System.out.println(webElement.getText());

		}

	}

}


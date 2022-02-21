package sumit;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static RemoteWebDriver driver;

	@Test(enabled = true)
	public void verifyAsendingOrderByPrice() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		/*
		 * @param driver.navigaye().to(Url String) It is only responsible for
		 * redirecting the page and then returning immediately. It tracks the browser
		 * history and can perform back and forth in the browser.
		 * driver.navigate().to("https://www.flipkart.com");
		 * 
		 * @param driver.get(URL); It is responsible for loading the page and waits
		 * until the page has finished loading. it cannot track the history of the
		 * browser.
		 */
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.withTimeout(Duration.ofSeconds(30));
		wait.withMessage("Element didn't appear within 30 seconds");
		wait.ignoring(NoSuchElementException.class);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']/input[@type='text']"));
		wait.until(ExpectedConditions.visibilityOf(element1));
		element1.sendKeys("9029253484");
		WebElement element2 = driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']/input[@type='password']"));
		element2.sendKeys("Sumit@2959");
		WebElement element3 = driver.findElement(By.xpath("//div[@class='_1D1L_j']/button[@type='submit']"));
		element3.click();

		driver.quit();
	}

	@Test(invocationCount = 0)
	public void moreText() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.withTimeout(Duration.ofSeconds(100));
		wait.withMessage("Element didn't appear within 30 seconds");
		wait.ignoring(NoSuchElementException.class);
		// button[@class="_2KpZ6l _2doB4z"]
		WebElement element4 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		wait.until(ExpectedConditions.visibilityOf(element4));
		element4.click();
		Actions action = new Actions(driver);
		WebElement element5 = driver.findElement(By.xpath("//div[text() = 'More']"));
		// action.moveToElement(element5);
		action.moveToElement(element5);

		action.perform();
		List<WebElement> list = driver.findElements(By.cssSelector("div.xtXmba"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Mobiles")) {
				list.get(i).click();
				break;
			}
		}
		By locator1 = By.cssSelector("div._2hKRMr._2CfYpZ > div > div:nth-child(5) > div > a");

		WebElement list1 = wait.until(ExpectedConditions.elementToBeClickable(locator1));

		list1.click();
		System.out.println("hiii1");
		By locator2 = By.className("_30jeq3");
		List<WebElement> beforeFilterPrice = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator2));
		/*
		 * System.out.println("hiii2"); System.out.println(beforeFilterPrice.size());
		 * 
		 * for (WebElement webElement : beforeFilterPrice) { String name =
		 * webElement.getText(); System.out.println(name);
		 * 
		 * }
		 * 
		 * for (int i = 0; i < beforeFilterPrice.size(); i++) { String elementText =
		 * beforeFilterPrice.get(i).getText(); System.out.println(elementText);
		 * 
		 * } /* By locator = By.cssSelector("article"); // By locator =
		 * By.xpath("//*[@id='custom-block-grid']/div/ul/div[1]/li"); List<WebElement>
		 * courses = new WebDriverWait(driver,
		 * 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		 * System.out.println(courses.size());
		 * 
		 * 
		 */
		List<Float> beforeFilterPriceList = new ArrayList();
		for (WebElement double1 : beforeFilterPrice) {
	//	beforeFilterPriceList.add(Float.valueOf(double1.getText().replace("₹", "")));
		}
		By locator3 =By.className("_10UF8M");
		List<WebElement> element04 =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator3));
	System.out.println(element04.size());
	for (int i = 0; i < element04.size(); i++) {
		if (element04.get(i).getText().contentEquals("Price -- Low to High")) {
			element04.get(i).click();
		}
		
	}
	/*for (WebElement webElement : element04) {
		if ("Price -- Low to High".equals(webElement)) {
			webElement.click();
			break;
		}*/
	driver.quit();	
	}
	}


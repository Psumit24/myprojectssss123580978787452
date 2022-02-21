package listnersashot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerInterface implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		String dir = System.getProperty("user.dir");
		File src = BaseClass.driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(dir+"/screenshots/image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart context");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish(ITestContext");
	}

}

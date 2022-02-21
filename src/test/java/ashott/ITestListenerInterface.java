package ashott;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

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
		String dir = System.getProperty("user.dir");
		AShot ashot = new AShot();
		ShootingStrategy strat = null;
		strat = ShootingStrategies.viewportPasting(2000);
		ashot.shootingStrategy(strat);
		Screenshot sc = ashot.takeScreenshot(BaseClass.driver);
		BufferedImage image = sc.getImage();
		try {
			ImageIO.write(image, "png", new File(dir + "/screenshots/"+"/screenshots_" + timestamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
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

package AdaniGroup.appium;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasicTest {
	AppiumDriverLocalService service;

	
	public void appiumTest() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0")
				.usingPort(4723)
				.build();

		service.start();
	}
@Test
	public void startTest() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ADCEmulator");
		capabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\User\\eclipse-workspace\\appium\\src\\test\\resources\\ApiDemos-debug.apk");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		// Perform your test actions here

		driver.quit();
//        service.stop();
	}
}
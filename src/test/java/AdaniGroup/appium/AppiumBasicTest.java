package AdaniGroup.appium;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasicTest {
	AppiumDriverLocalService service;


@Test
	public void startTest() throws MalformedURLException {
	service = new AppiumServiceBuilder()
			.withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("0.0.0.0")
			.usingPort(4723)
		
			.build();

	service.start();

	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("ADC");
	options.setApp("C:\\ApiDemos-debug.apk");
	AndroidDriver driver = new AndroidDriver(new URL ("http://0.00.0:4723"), options);
	driver.quit();
		//xpath.id,accessibilityid,classname,androidUI automator

		
   service.stop();
	}
}
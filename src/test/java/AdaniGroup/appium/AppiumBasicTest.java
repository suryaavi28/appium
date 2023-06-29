package AdaniGroup.appium;

import java.io.File;	
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasicTest {
	AppiumDriverLocalService service;
	UiAutomator2Options options;
	AndroidDriver driver;
@Test(enabled = false)
	public void startAndroidStudioAndEmulator() throws IOException, InterruptedException {
		// Replace with the path to your Android Studio executable
		String androidStudioPath = "C:\\Program Files\\Android\\Android Studio\\bin\\studio64.exe";

		// Replace with the name of your virtual device
		String emulatorName = "ADC";

		// Command to start Android Studio
		String command = "\"" + androidStudioPath +"\"";

		// Execute the command to open Android Studio
		Runtime.getRuntime().exec(command);

		// Wait for Android Studio to open
		Thread.sleep(15000); // Adjust the delay as needed

		// Command to start the emulator
		command = "emulator -avd " + emulatorName;

		// Execute the command to start the emulator
		Runtime.getRuntime().exec(command);

		// Wait for the emulator to start
		Thread.sleep(10000); // Adjust the delay as needed

		// Now you can interact with the emulator or perform your test steps
		// For example, you can use Appium or other automation tools to interact with
		// the emulator

		// Close Android Studio
//	        command = "taskkill /f /im studio64.exe"; // Adjust the command for your operating system if needed
//	        Runtime.getRuntime().exec(command);
	}

	@BeforeTest
	public void startTest() throws MalformedURLException, InterruptedException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723)

				.build();
		
Thread.sleep(5000);
	service.start();
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//	    desiredCapabilities.setCapability("appium:app", "C:\\ACL.apk");
//	    desiredCapabilities.setCapability("appium:deviceName", "ADC");
//	    desiredCapabilities.setCapability("platformName", "android");
//	    desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
//	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		options = new UiAutomator2Options();
		options.setCapability("serverStartTimeout", 30000); 
		//options.setDeviceName("ADA");
		// options.setApp("C:\\Ambu.apk");
		 options.setApp("C:\\ACL.apk");
		//options.setApp("C:\\DEM.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	Thread.sleep(5000);

//	driver.navigate().back();
	}

	
	

//@Test
//    public void emu() {
//        try {
//            // Replace 'emulator_name' with the name of your virtual device
//            String emulatorName = "ADC";
	// String command = "emulator -avd " + emulatorName;
//            Runtime.getRuntime().exec(command);
//            System.out.println("Emulator opened successfully.");
//        } catch (IOException e) {
//            System.out.println("Failed to open emulator: " + e.getMessage());
//        }
//    }

	@Test              
	
	
	
public void loginWithValidCredentials() throws InterruptedException {

		 driver.findElement(By.xpath("//android.widget.EditText[@hint= 'contact Login ID']")).sendKeys("Ashish_tpv");
		 driver.findElement(By.xpath("//android.widget.EditText[@hint= 'unlock Password']")).sendKeys("Test123#");
	WebElement button = 	driver.findElement(By.className("android.widget.Button"));
button.click();

		
		
		
	
		//driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
	Thread.sleep(4000);
	//driver.navigate().back();

//	Thread.sleep(2000);
	//boolean isAccessibilityDisplayed = driver.findElement(AppiumBy.accessibilityId("Accessibility")).isDisplayed();
	//	Assert.assertTrue(isAccessibilityDisplayed, "Accessibility element is not displayed on the screen.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		// xpath.id,accessibilityid,classname,androidUI automator

		service.stop();
}}
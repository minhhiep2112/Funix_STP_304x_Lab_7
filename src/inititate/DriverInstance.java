package inititate;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import library.CaptureScreenshot;
import library.PropertyReader;

public class DriverInstance {

	public WebDriver driver;
	
	
	@BeforeClass
	public void openBrowser() throws IOException {
		
		if(PropertyReader.fetchProperty("name_browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver(option);
			
		}
		else if (PropertyReader.fetchProperty("name_browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (PropertyReader.fetchProperty("name_browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =  new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get(PropertyReader.fetchProperty("base_url"));
	    
		
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterMethod
	public void takeScreenShotIfFail(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			CaptureScreenshot.takeScreenShot(driver, result.getName());
			System.out.println("Da chup man hinh. "+result.getName());
			
		}
		
	}
	
}

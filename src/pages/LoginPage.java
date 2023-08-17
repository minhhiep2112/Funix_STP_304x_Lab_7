package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import library.CaptureScreenshot;
import library.PropertyReader;

public class LoginPage {

	public static void enterEmail(WebDriver driver, String email)  {
		try {
			driver.findElement(By.xpath(PropertyReader.fetchProperty("login_email_path"))).sendKeys(email);
		}
		catch (Exception e) {
					
			e.printStackTrace();
			CaptureScreenshot.takeScreenShot(driver, "Enter email fail!");
			Assert.fail();
			
			}
	}
	
	public static void enterPassword(WebDriver driver,String pass) {
		try {
			driver.findElement(By.xpath(PropertyReader.fetchProperty("login_password_path"))).sendKeys(pass);
		}	
		catch (Exception e) {
			
			e.printStackTrace();
			CaptureScreenshot.takeScreenShot(driver, "Enter password fail!");
			Assert.fail();
			
			}	
	}
	
	public static void clickSignin(WebDriver driver)  {
		try {
			driver.findElement(By.xpath(PropertyReader.fetchProperty("sigin_button_path"))).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			CaptureScreenshot.takeScreenShot(driver, "Click sign in button fail!");
			Assert.fail();
			
			}	
	}
	
	public static void clickLoginSignupButton(WebDriver driver)  {
		try {
			driver.findElement(By.xpath(PropertyReader.fetchProperty("login_signup_button_path"))).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			CaptureScreenshot.takeScreenShot(driver, "Click login/signup button fail!");
			Assert.fail();
			
			}	
	}
	
	public static void clickSignout(WebDriver driver) throws IOException {
		try {
			driver.findElement(By.xpath(PropertyReader.fetchProperty("sign_out_button_path"))).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			CaptureScreenshot.takeScreenShot(driver, "Click sign out fail!");
			Assert.fail();
			
			}	
	}
	
}

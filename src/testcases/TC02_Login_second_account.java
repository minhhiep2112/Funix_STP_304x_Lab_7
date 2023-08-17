package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import inititate.DriverInstance;
import library.PropertyReader;
import pages.LoginPage;

public class TC02_Login_second_account extends DriverInstance{
	
	@Test
	public void TC02() throws IOException  {
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/login']")).isDisplayed(),"Account is log in"); 
		
		LoginPage.clickLoginSignupButton(driver);
		LoginPage.enterEmail(driver, PropertyReader.fetchProperty("login_email_2_content"));
		LoginPage.enterPassword(driver, PropertyReader.fetchProperty("login_password_2_content"));
		LoginPage.clickSignin(driver);
		LoginPage.clickSignout(driver);
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/login']")).isDisplayed(),"Account is log in"); 
		
	}
	
}

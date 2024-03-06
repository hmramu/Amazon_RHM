package Project2.Amazon;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Source2 extends logincredentials {
	WebDriver driver;
	//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
	
	@FindBy(xpath="(//span[@class='nav-line-1 nav-progressive-content'])[2]")
	WebElement hellouser;
				
// 2. Creating the method for each component to perform its action
	public void assert_login()
	{
		String actual= hellouser.getText();
		String expected="Hello, Automation";
		Assert.assertEquals(actual, expected);
	}

	public void assert_login1()
	{
		boolean condition = hellouser.isDisplayed();
		Assert.assertEquals(condition, true);
	}
	public void assert_login2(WebDriver driver)
	{
		driver.findElement(By.xpath("(//span[@class='nav-line-1 nav-progressive-content'])[2][contains(text(),'Automation')]"));
	}
	
//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}
	

}
 
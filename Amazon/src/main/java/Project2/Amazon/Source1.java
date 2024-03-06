package Project2.Amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Source1 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
				
		@FindBy(xpath="//a[@class='nav-a']")
		WebElement starthere;
		
		@FindBy(xpath="//input[@placeholder='First and last name']")
		WebElement yourname;
		
		@FindBy(xpath="//input[@placeholder='Mobile number']")
		WebElement mobilenum;
		
		@FindBy(xpath="//input[@placeholder='At least 6 characters']")
		WebElement password;
		
		@FindBy(xpath="//span[@id='auth-continue']")
		WebElement verifymobile;
						
		@FindBy(xpath="(//h4[@class='a-alert-heading'])[2]")
		WebElement statusmessage;
// 2. Creating the method for each component to perform its action
		public void start_here()
		{
			starthere.click();
		}
		public void your_name()
		{
			yourname.sendKeys("Automation tester 1");
		}
		public void mobile_num()
		{
			mobilenum.sendKeys("8951051048");
		}
		public void pass_word()
		{
			password.sendKeys("Myamazon@2024");
		}
		public void verify_mobile()
		{
			verifymobile.click();
		}
		public void verification_status()
		{
			String actual= statusmessage.getText();
			String expected ="Mobile number already in use";
			Assert.assertEquals(actual, expected);
			System.out.println("Mobile number already in use so try exploring the other available options");
			
		}
//3. Intializing each component using page factory class
		
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source1(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


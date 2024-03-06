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

public class Source13 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
				
		@FindBy(xpath="//input[@type='text']")
		WebElement promocode;
		
		//@FindBy(xpath="//div/p[@id='addPromo_BadCode']")
		//@FindBy(xpath="(//div[@class='a-alert-content'])[2]")
		@FindBy(xpath="//div[@class='a-box-inner a-alert-container']/div/p[@id='addPromo_BadCode']")
		WebElement promoresponse;
		
						
// 2. Creating the method for each component to perform its action
		public void promo_code(WebDriver driver)
		{
			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//input[@name='placeYourOrder1'])[1]"))));
			promocode.sendKeys("ABCD1234");
			promocode.sendKeys(Keys.ENTER);
		
												
			String actual= promoresponse.getText();
			String expected ="The promotional code you entered is not valid.";
			Assert.assertNotEquals(actual, expected);
			//Assert.assertnotEquals(actual, expected);
			System.out.println("Promo code validated");
		}
		
		
//3. Intializing each component using page factory class
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source13(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


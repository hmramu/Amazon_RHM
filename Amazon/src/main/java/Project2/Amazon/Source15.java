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

public class Source15 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
				
		@FindBy(xpath="//h1[@class='a-spacing-small']")
		WebElement signinpage;
		
						
// 2. Creating the method for each component to perform its action
		public void page_verification()
		{
			String actual= signinpage.getText();
			String expected ="Sign in";
			Assert.assertEquals(actual, expected);
			System.out.println("You must sign in to buy product");
			
		}
		
		
//3. Intializing each component using page factory class
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source15(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


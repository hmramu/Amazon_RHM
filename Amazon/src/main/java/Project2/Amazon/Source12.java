package Project2.Amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Source12 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
				
		@FindBy(xpath="//span[@class='a-dropdown-prompt']")
		WebElement cartqty;
		
		@FindBy(xpath="//span[@class='a-dropdown-prompt']")
		WebElement paymentpageqty;
		
						
// 2. Creating the method for each component to perform its action
		public String cart_qty()
		{
			String cart= cartqty.getText();
			System.out.println(cart);
			return cart;
		}
		public String payment_qty()
		{
			String payment =paymentpageqty.getText();
			System.out.println(payment);
			return payment;
		}
		public void match_qty()
		{
			String actual= cart_qty();
			String expected =payment_qty();
			Assert.assertEquals(actual, expected);
			System.out.println("Total no. of qty available in cart are matched with qty available in payment page");
		}
		
//3. Intializing each component using page factory class
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source12(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


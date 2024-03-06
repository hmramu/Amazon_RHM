package Project2.Amazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Source14 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
				
		@FindBy(xpath="//input[@type='text']")
		WebElement promocode;
		
		//@FindBy(xpath="//div/p[@id='addPromo_BadCode']")
		//@FindBy(xpath="(//div[@class='a-alert-content'])[2]")
		@FindBy(xpath="//div[@class='a-box-inner a-alert-container']/div/p[@id='addPromo_BadCode']")
		WebElement promoresponse;
		
		@ FindBy(id="ap_email")
		WebElement usernamefield;

		@ FindBy(name="password")
		WebElement passwordfield;
		
		@FindBy(linkText="Your Orders")
		WebElement orders;
		
		@FindBy(xpath="(//a[@id='Write-a-product-review_2'])[6]")
		WebElement writepr;
		
		@FindBy(xpath="(//div[@class='a-section a-spacing-top-micro']/button)[2]")
		WebElement rating;
		
		@FindBy(xpath="//button[@class='a-button-text']")
		WebElement submit;
		
		@FindBy(xpath="//span[@class='a-color-success ryp__submission-notification__success']")
		WebElement ratingack;
						
// 2. Creating the method for each component to perform its action
		public void promo_code(WebDriver driver)
		{
			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//input[@name='placeYourOrder1'])[1]"))));
			promocode.sendKeys("ABCD1234");
			promocode.sendKeys(Keys.ENTER);
		
												
			String actual= promoresponse.getText();
			String expected ="The promotional code you entered is not valid.";
			Assert.assertEquals(actual, expected);
			System.out.println("Promo code validated");
		}
		public void un() throws EncryptedDocumentException, IOException
		{
			Source14 refvar =new Source14(driver); //
			refvar.fetchunpw2("a","b"); 
			usernamefield.sendKeys(refvar.username2);	
		}
		
		public void pwd() throws EncryptedDocumentException, IOException
		{
			Source14 refvar =new Source14(driver); 
			refvar.fetchunpw2("a", "b");
			passwordfield.sendKeys(refvar.password2);
		}
		
		public void your_orders()
		{
			orders.click();
		}
		public void write_productreview()
		{
			writepr.click();
		}
		public void product_rating()
		{
			rating.click();
		}
		public void sub_mit()
		{
			submit.click();
		}
		public void rating_ack()
		{
			String actual= ratingack.getText();
			String expected ="Submitted";
			Assert.assertEquals(actual, expected);
			System.out.println("Successfully rated the product");
			
		}
//3. Intializing each component using page factory class
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source14(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


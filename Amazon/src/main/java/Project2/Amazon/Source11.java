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

public class Source11 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
// 1. Locating each components using @ Findby annotation
				
		@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
		WebElement proceedtobuy;
		
		@FindBy(xpath="//span[@class='a-button a-button-span12 a-button-primary celwidget  buy-button-height buy-button-sky-fix']")
		WebElement usethisaddress;
		
		@FindBy(xpath="//span[.='Credit or debit card']")
		WebElement creditcard;
		
		@FindBy(xpath="(//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link'])[1]")
		WebElement entercarddetails;
		
		@FindBy(xpath="//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
		WebElement usethispaymentmethod;
		
		@FindBy(xpath="(//span[@class='break-word'])[2]")
		WebElement delivery;
		
		@FindBy(xpath="(//span[@class='place-order-button-text buy-button-line-height'])[1]")
		WebElement placeorder;
		
				
// 2. Creating the method for each component to perform its action
		public void proceed_tobuy()
		{
			proceedtobuy.click();
		}
		public void use_thisaddress()
		{
			usethisaddress.click(); 
		}
		public void exp_wait_cc(WebDriver driver)
		{
			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[.='Credit or debit card']"))));
			creditcard.click();
		}
		public void enter_carddetails()
		{
			entercarddetails.click();
		}
		public void use_thispaymentmethod(WebDriver driver)
		{
			//WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			//expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[@id='pp-Nnnr8G-143']"))));
			usethispaymentmethod.click();
		}
		public void Assert_orderreview()
		{
			Assert.assertTrue(placeorder.isDisplayed());
			System.out.println("Address, payment method selected ready to place order");
			
		}
		
		
//3. Intializing each component using page factory class
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source11(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


package Project2.Amazon;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Source9 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
	// 1. Locating each components using @ Findby annotation
		@ FindBy(id="ap_email")
		WebElement usernamefield;

		@ FindBy(id="continue")
		WebElement username1_submit;

		@ FindBy(name="password")
		WebElement passwordfield;

		@ FindBy(xpath="//input[@id='signInSubmit']")
		WebElement signin_button;
		
		@ FindBy(id="twotabsearchtextbox")
		WebElement searchbar;
		
		@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
		WebElement firstproduct;
		
		@FindBy(xpath="//input[@name='submit.add-to-cart']")
		WebElement addtocart;
		
		//@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
		@FindBy(xpath="//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
		WebElement addedtocart;
		
		@FindBy(xpath="//span[@class='a-button a-spacing-small a-button-primary a-button-icon natc-enabled']")
		WebElement addtocart123;
		
		@FindBy(xpath="(//span[@class='nav-line-1 nav-progressive-content'])[2]")
		WebElement profile;
		
		//@FindBy(xpath="(//span[@class='nav-text'])[21]")
		@FindBy(linkText="Sign Out")
		WebElement logout;
				
	// 2. Creating the method for each component to perform its action
		public void un() throws EncryptedDocumentException, IOException
		{
			Source9 refvar =new Source9(driver); //
			refvar.fetchunpw("a","b"); 
			usernamefield.sendKeys(refvar.username);	
		}
		public void un_submit()
		{
			username1_submit.click();
		}
		public void pwd() throws EncryptedDocumentException, IOException
		{
			Source9 refvar =new Source9(driver); 
			refvar.fetchunpw("a", "b");
			passwordfield.sendKeys(refvar.password);
		}
		
		public void signin()
		{
			signin_button.click();
		}
		public void searchproduct(String data)
		{
			//searchbar.sendKeys("Men's jeans");
			searchbar.sendKeys(data);
			searchbar.sendKeys(Keys.ENTER);
		}
		public void select_firstproduct()
		{
			firstproduct.click();
				
		}
		public void switch_window(WebDriver driver)
		{
			// To Switch the control to the child tab
			String parentid = driver.getWindowHandle();// gets Parent tab id
			Set<String> ParChid = driver.getWindowHandles();// gets Parent + Child tab id
			System.out.println(parentid);
			System.out.println(ParChid);
			
			Iterator<String> id1 = ParChid.iterator();// Assigning parent+child tab id to iterator to split id's 
			String parentid1 = id1.next();//Only parent id assigned to id1
			String Child1=id1.next();// Only child id assigned to id1
			
			System.out.println(parentid1);// Printing only parent id
			System.out.println(Child1);// Printing only child id
			driver.switchTo().window(Child1);// Switching control to child id						
		}
		public void switch_backwindow(WebDriver driver)
		{
			// To Switch the control to the child tab
			String parentid = driver.getWindowHandle();// gets Parent tab id
			Set<String> ParChid = driver.getWindowHandles();// gets Parent + Child tab id
			System.out.println(parentid);
			System.out.println(ParChid);
			
			Iterator<String> id1 = ParChid.iterator();// Assigning parent+child tab id to iterator to split id's 
			String parentid1 = id1.next();//Only parent id assigned to id1
			String Child1=id1.next();// Only child id assigned to id1
			
			System.out.println(parentid1);// Printing only parent id
			System.out.println(Child1);// Printing only child id
			driver.switchTo().window(parentid1);// Switching control to child id						
		}
		
		
		public void add_tocart()
		{
			addtocart.click();
		}
		public void added_tocart()
		{
			 addedtocart.getText();
			
		}
		public void add_tocart123()
		{
			addtocart123.click();
		}
		
		public void assert_status()
		{
			String actual= addedtocart.getText();
			String expected="Added to Cart";
			Assert.assertEquals(actual, expected);
			System.out.println("Passed for successfully adding product to cart");
		}
						
		public void profileaccess(WebDriver driver)
		{	
			//driver= new ChromeDriver();
			Actions a1=new Actions(driver);
			a1.moveToElement(profile).perform();
		}
		public void logout()
		{
			logout.click();
		}
		

	//3. Intializing each component using page factory class
	// NullPointerException will arrive without intializing element try to perform action 
			
		public Source9(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


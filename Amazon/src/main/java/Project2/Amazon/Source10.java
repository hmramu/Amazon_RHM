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

public class Source10 extends logincredentials {
		WebDriver driver;
		//WebDriver driver= new ChromeDriver();
	// 1. Locating each components using @ Findby annotation
		@ FindBy(id="ap_email")
		WebElement username1;

		@ FindBy(id="continue")
		WebElement username1_submit;

		@ FindBy(name="password")
		WebElement password1;

		@ FindBy(xpath="//input[@id='signInSubmit']")
		WebElement signin_button;
		
		@ FindBy(id="twotabsearchtextbox")
		WebElement searchbar;
		
		@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
		WebElement firstproduct;
		
		@FindBy(xpath="//input[@name='submit.add-to-cart']")
		WebElement addtocart;
		
		@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
		WebElement addedtocart;
		
		//@FindBy(xpath="(//a[@class='a-button-text'])[3]")
		@FindBy(xpath="//span[@class='a-button a-spacing-top-base a-button-span12 a-button-base celwidget']")
		WebElement gotocart;
		
		@FindBy(xpath="//div//ul[@class='a-nostyle a-list-link']/li")
		WebElement dropdownlist;
		
		/*
		List<WebElement> autosuggestion = driver.findElements(By.xpath("(//div//ul[@class='_1sFryS _2x2Mmc _3ofZy1'])/li"));

		//(//div//ul[@class='_1sFryS _2x2Mmc _3ofZy1'])/li[1]
		
		Thread.sleep(2000);
		int count= autosuggestion.size(); // Count of total no. of auto suggestion loaded
		System.out.println(count);
		
		autosuggestion.get(count-6).click();// total count is 8-6=2
*/
		@FindBy(xpath="(//span[@class='a-size-medium sc-number-of-items'])[1]")
		WebElement subtotal;
		
		//@FindBy(xpath="//a[@class='a-dropdown-link a-active']")
		@FindBy(xpath="//span[@class='a-button a-button-dropdown quantity']")
		WebElement qtyidentification;
		
		@FindBy(xpath="//h1[@class='a-spacing-mini a-spacing-top-base']")
		WebElement emptycart;
		
		@FindBy(xpath="//span[@class='a-dropdown-label']")
		WebElement qtyselection;
		
		@FindBy(xpath="(//span[@class='nav-line-1 nav-progressive-content'])[2]")
		WebElement profile;
		
		//@FindBy(xpath="(//span[@class='nav-text'])[21]")
		@FindBy(linkText="Sign Out")
		WebElement logout;
				
	// 2. Creating the method for each component to perform its action
		public void un() throws EncryptedDocumentException, IOException
		{
			//username1.sendKeys("testautomation472@gmail.com");
			
			Source10 refvar =new Source10(driver); //
			 refvar.fetchunpw("a","b"); 
			 //System.out.println(refvar.username); //
			 //System.out.println(refvar.password);
			 username1.sendKeys(refvar.username);	
			//username1.sendKeys(username());
		}
		public void un_submit()
		{
			username1_submit.click();
		}
		public void pwd() throws EncryptedDocumentException, IOException
		{
			//password1.sendKeys("Automation@123");
			
			Source10 refvar =new Source10(driver); 
			 refvar.fetchunpw("a", "b");
			 //System.out.println(refvar.username); 
			// System.out.println(refvar.password);
			 password1.sendKeys(refvar.password);
			 //password1.sendKeys(password());
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
		public void add_tocart()
		{
			addtocart.click();
		}
		public void added_tocart()
		{
			 addedtocart.getText();
			
		}
		public void assert_status()
		{
			String actual= addedtocart.getText();
			String expected="Added to Cart";
			Assert.assertEquals(actual, expected);
		}
		public void go_tocart()
		{
			gotocart.click();
		}
		
		public void qty_selection() throws InterruptedException
		{
			qtyselection.click();
			Thread.sleep(1000);
			qtyselection.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			qtyselection.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			qtyselection.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			qtyselection.sendKeys(Keys.ENTER);
		}
		public void qty_list(WebDriver driver) 	
		{
			//List<WebElement> qtylist= driver.findElements(By.xpath("//div//ul[@class='a-nostyle a-list-link']/li"));
			//List<WebElement> qtylist= driver.findElements(By.xpath("//div//ul//li[@class='a-dropdown-item quantity-option']"));
			//List<WebElement> qtylist= driver.findElements(By.xpath("//div[@class='a-popover-inner a-lgtbox-vertical-scroll']/ul/li"));
			//List<WebElement> qtylist= driver.findElements(By.xpath("//div[@class='a-popover-wrapper']/div/ul/li"));
			//List<WebElement> qtylist= driver.findElements(By.xpath("//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li"));
			//int count= qtylist.size(); // Count of total no. of auto suggestion loaded
			//System.out.println("Total no. of elements found in the list is "+count);
			//qtylist.get(count-4).click();// total count is 8-6=2
			
			
			//WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			//expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//input[@value='Delete'])[1]"))));
			//(//input[@name='ppw-instrumentRowSelection'])[5]
			//expwait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@id='pp-ATkSfV-141']")));
			//expwait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//input[@id='pp-OUukYh-141']"), true));
			//creditcard.click();
//			WebElement qty0=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty1=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty2=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty3=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty4=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[5]"));
//			WebElement qty5=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[6]"));
//			WebElement qty6=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty7=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty8=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty9=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			WebElement qty10=driver.findElement(By.xpath("(//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/div/div/ul/li)[1]"));
//			
//			Thread.sleep(5000);
//			qty4.click();
			
			//driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
//			for(int i=0; i<11; i++)
//			{
//				
//			}
			
			WebElement quantity=driver.findElement(By.xpath("//select[@id='quantity']"));
			Select se= new Select(quantity);
			se.selectByIndex(2);
		}
		public void sub_total() 
		{
			subtotal.getText();
		}
		public void exp_wait()
		{
			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[@class='a-button a-button-dropdown quantity']"))));
		}
		public void assert_qty5(WebDriver driver) throws InterruptedException
		{
			WebElement quantity=driver.findElement(By.xpath("//select[@id='quantity']"));
			Select se= new Select(quantity);
			
//			se.selectByIndex(1);
//			se.selectByIndex(2);
//			se.selectByIndex(3);
//			se.selectByIndex(4);
			se.selectByIndex(5);
//			se.selectByIndex(6);
//			se.selectByIndex(7);
//			se.selectByIndex(8);
//			se.selectByIndex(9);
//			se.selectByIndex(10);
			
			
			//driver.navigate().refresh();
			//String actual=qtyidentification.getText();
			//String expected ="1";
//			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
//			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//span[@class='a-size-medium sc-number-of-items'])[1]"))));
//			Thread.sleep(3000);
			
			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[@class='a-button a-button-dropdown quantity']"))));
		
			Thread.sleep(3000);
			String actual= subtotal.getText();
			String expected ="Subtotal (5 items):";
			Assert.assertEquals(actual, expected);
			System.out.println("Passed for qty selected as 5");
			
			
		}
		
		public void assert_qtydelete(WebDriver driver) throws InterruptedException
		{
			WebElement quantity=driver.findElement(By.xpath("//select[@id='quantity']"));
			Select se= new Select(quantity);
			
		se.selectByIndex(0);
//			se.selectByIndex(2);
//			se.selectByIndex(3);
//			se.selectByIndex(4);
//			se.selectByIndex(5);
//			se.selectByIndex(6);
//			se.selectByIndex(7);
//			se.selectByIndex(8);
//			se.selectByIndex(9);
//			se.selectByIndex(10);
			
			
			//driver.navigate().refresh();
			//String actual=qtyidentification.getText();
			//String expected ="1";
//			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
//			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//span[@class='a-size-medium sc-number-of-items'])[1]"))));
//			Thread.sleep(3000);
			
			WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
			expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//h1[@class='a-spacing-mini a-spacing-top-base']"))));
		
			String actual= emptycart.getText();
			String expected ="Your Amazon Cart is empty.";
			Assert.assertEquals(actual, expected);
			System.out.println("Passed for deleting all qty in cart");
			
			
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
			
		public Source10(WebDriver driver)
		{
			PageFactory.initElements(driver, this);// init meaning initializing elements
		}
		

	}
	


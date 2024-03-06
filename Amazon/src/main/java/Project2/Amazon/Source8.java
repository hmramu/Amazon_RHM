package Project2.Amazon;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Source8 extends logincredentials {
	WebDriver driver;
// 1. Locating each components using @ Findby annotation
	
	@FindBy(xpath="//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	WebElement price;
	
	@FindBy(xpath="//h2[@class='softlines']")
	WebElement productdescription;
	
	@FindBy(xpath="//span[@data-hook='top-customer-reviews-title']")
	WebElement customerreview;
	
	@FindBy(xpath="//span[@data-hook='top-customer-reviews-title']")
	WebElement customerreviewnotavailable;
	
	@FindBy(xpath="//h3[@class='a-size-base-plus a-color-base a-text-bold']")
	WebElement customerreviewavailable;
	
	
	
// 2. Creating the method for each component to perform its action
	
	
	
	
	public void Assert_loop_price_desc_review(WebDriver driver)
	{
			boolean actual=(price.isDisplayed()||productdescription.isDisplayed()||customerreview.isDisplayed());
			boolean expected =true;
			Assert.assertEquals(actual, expected);
			System.out.println("Product price, description and review found");
	
	}
	SoftAssert softassert= new SoftAssert();
	
	public void Assert_loop_pdr(WebDriver driver)
	{
			//WebElement listoftheproducts=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + k + "]"));
			List<WebElement> listoftheproducts=driver.findElements(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])"));
			int count= listoftheproducts.size(); // Count of total no. of auto suggestion loaded
			System.out.println("Total no. of elements found in the list is "+count);
			
			for (int i=0;i<count; i++)
		{
			listoftheproducts.get(i).click();
			
			// to switch control from parent tab to child tab
			Set<String> handles = driver.getWindowHandles();// gets Parent + Child tab id
			Iterator<String> iterator = handles.iterator();// Assigning parent+child tab id to iterator to split id's 
			String parentid1 = iterator.next();//Only parent id assigned to id1
			String Child1=iterator.next();// Only child id assigned to id1
			driver.switchTo().window(Child1);// Switching control to child id
			
//			Assert.assertTrue(price.isDisplayed(), "Price is not available for this product ");
//			Assert.assertTrue(productdescription.isDisplayed(), "Description is not available for this product ");
//			Assert.assertTrue(customerreviewavailable.isDisplayed(), "Customer review is not available for this product ");
			
			
			// conditions for visibility of each type of element
			boolean actual=price.isDisplayed();
			boolean expected =true;
			Assert.assertEquals(actual, expected);
			System.out.println("Price is available for the product at the serach result :"+i);
			
			boolean actual1=productdescription.isDisplayed();
			boolean expected1 =true;
			Assert.assertEquals(actual1, expected1);
			System.out.println("Description is available for the product at the serach result :"+i);
			
			boolean actual3=customerreviewavailable.isDisplayed();
			boolean expected3 =true;
			boolean actual2=customerreviewnotavailable.isDisplayed();
			boolean expected2 =true;
			if (actual3==expected3)
			{
				System.out.print("User review is available for the product at the serach result "+i);
			}
			
			else if (actual2==expected2)
			{
				System.out.print("User review is not available for the product at the serach result "+i);
			}
				
			
			/*
			try {
				boolean actual3=customerreviewavailable.isDisplayed();
				boolean expected3 =true;
				Assert.assertEquals(actual3, expected3);
				System.out.print("User review is available for the product at the serach result "+i);
				
				
			}catch(NoSuchElementException exceptionnoreview) {
				try {
					boolean actual2=customerreviewnotavailable.isDisplayed();
					boolean expected2 =true;
					Assert.assertEquals(actual2, expected2);
					System.out.print("User review is not available for the product at the serach result "+i);
				}catch(NoSuchElementException exceptionnoreview1) {
					
					System.out.println("Arrived assertion error1");
				}
				
				System.out.println("Arrived assertion error");
			}
			*/
			
			//softassert.assertAll();		
			driver.close();
			driver.switchTo().window(parentid1);// Switching control to child id
		}
			
	}
	
	public void Assert_sorting_pric_low_high(WebDriver driver) throws InterruptedException
	{
		WebElement sort=driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
		sort.click();
		
		List<WebElement>list=driver.findElements(By.xpath("(//div[@class='a-popover-inner']/ul/li)"));
		int count= list.size(); // Count of total no. of auto suggestion loaded
		System.out.println("Total no. of elements found in the list is "+count);
			
		for (int i=1;i<2; i++)
		{
			list.get(i).click();
			WebElement sortedinfo=driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
			String actual=sortedinfo.getText();
			String expected1 ="Price: Low to High";
			String expected2="Price: High to Low";
			String expected3="Avg. Customer Review";
			String expected4="Newest Arrivals";
			
			Assert.assertEquals(actual, expected1);
			System.out.println("Sorted successfully for price Low to High");
			
		}
	}
	public void Assert_sorting_pric_high_low(WebDriver driver) throws InterruptedException
	{
		WebElement sort=driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
		sort.click();
		
		List<WebElement>list=driver.findElements(By.xpath("(//div[@class='a-popover-inner']/ul/li)"));
		int count= list.size(); // Count of total no. of auto suggestion loaded
		System.out.println("Total no. of elements found in the list is "+count);
			
		for (int i=2;i<3; i++)
		{
			list.get(i).click();
			WebElement sortedinfo=driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
			String actual=sortedinfo.getText();
			String expected1 ="Price: Low to High";
			String expected2="Price: High to Low";
			String expected3="Avg. Customer Review";
			String expected4="Newest Arrivals";
			
			Assert.assertEquals(actual, expected2);
			System.out.println("Sorted successfully for price High to Low");
			
		}
	}	
	
	public void Assert_sorting_pric_customer_review(WebDriver driver) throws InterruptedException
	{
		WebElement sort=driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
		sort.click();
		
		List<WebElement>list=driver.findElements(By.xpath("(//div[@class='a-popover-inner']/ul/li)"));
		int count= list.size(); // Count of total no. of auto suggestion loaded
		System.out.println("Total no. of elements found in the list is "+count);
			
		for (int i=3;i<4; i++)
		{
			list.get(i).click();
			WebElement sortedinfo=driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
			String actual=sortedinfo.getText();
			String expected1 ="Price: Low to High";
			String expected2="Price: High to Low";
			String expected3="Avg. Customer Review";
			String expected4="Newest Arrivals";
			
			Assert.assertEquals(actual, expected3);
			System.out.println("Sorted successfully for Avg. Customer Review");
			
		}
	}		
			//int c=s1.nextInt();
/*			switch(i)
			{
			case 1:System.out.println("Case 1 selected and it will check for price Low to High");
			Assert.assertEquals(actual, expected);
			System.out.println("Sorted successfully for price Low to High");
			driver.navigate().refresh();
			Thread.sleep(3000);
			break;
					//break;//Without break statement leakage will happen
			
			case 2:System.out.println("Case 2 selected and it will check for price High to Low");
			Assert.assertEquals(actual, expected2);
			System.out.println("Sorted successfully for price High to Low");
			driver.navigate().refresh();
			Thread.sleep(3000);
			break;
			
			case 3:System.out.println("Case 3 selected and it will do Multiplication");
			Assert.assertEquals(actual, expected3);
			System.out.println("Sorted successfully for Avg. Customer Review");
			break;
			
			case 4:System.out.println("Sorted successfully for Newest Arrivals");
			Assert.assertEquals(actual, expected4);
			break;
					
			default:System.out.println("No case is selected that is why I am the output");
			
			}
*/
			
		
		

	
	public void Assert_sorting1(WebDriver driver) throws InterruptedException
	{
		WebElement sort=driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
		
//(//div[@class='a-popover-wrapper'])[11]/div/ul/li
		
		List<WebElement>list=driver.findElements(By.xpath("(//div[@class='a-popover-wrapper'])[11]/div/ul/li"));
		int count= list.size(); // Count of total no. of auto suggestion loaded
		System.out.println("Total no. of elements found in the list is "+count);
		
		for (int i=1;i<count; i++)
		{
			sort.click();
			list.get(i).click();
			WebElement sortedinfo=driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
			String actual=sortedinfo.getText();
			String expected1 ="Price: Low to High";
			String expected2="Price: High to Low";
			String expected3="Avg. Customer Review";
			String expected4="Newest Arrivals";
			
			Assert.assertEquals(actual, expected2);
			System.out.println("Sorted successfully for price High to Low");
	
			
			//int c=s1.nextInt();
/*			switch(i)
			{
			case 1:System.out.println("Case 1 selected and it will check for price Low to High");
			Assert.assertEquals(actual, expected);
			System.out.println("Sorted successfully for price Low to High");
			driver.navigate().refresh();
			Thread.sleep(3000);
			break;
					//break;//Without break statement leakage will happen
			
			case 2:System.out.println("Case 2 selected and it will check for price High to Low");
			Assert.assertEquals(actual, expected2);
			System.out.println("Sorted successfully for price High to Low");
			driver.navigate().refresh();
			Thread.sleep(3000);
			break;
			
			case 3:System.out.println("Case 3 selected and it will do Multiplication");
			Assert.assertEquals(actual, expected3);
			System.out.println("Sorted successfully for Avg. Customer Review");
			break;
			
			case 4:System.out.println("Sorted successfully for Newest Arrivals");
			Assert.assertEquals(actual, expected4);
			break;
					
			default:System.out.println("No case is selected that is why I am the output");
			
			}
*/
			
		}
		
	}
	public void Assert_searchresult2(WebDriver driver)
	{
 	driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1][contains(text(),'Shirt')]"));
		
	}
	
	

//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source8(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}

}

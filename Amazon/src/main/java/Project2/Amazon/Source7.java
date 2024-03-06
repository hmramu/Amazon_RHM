package Project2.Amazon;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Source7 extends logincredentials {
	WebDriver driver;
// 1. Locating each components using @ Findby annotation
	
	//@FindBy(xpath="//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	@FindBy(xpath="(//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']/span/span)[2]")
	WebElement price;
	
	@FindBy(xpath="//h2[@class='softlines']")
	WebElement productdescription;
	
	@FindBy(xpath="//div[@id='aplus']")
	WebElement productdescription1;
	
//	@FindBy(xpath="//span[@data-hook='top-customer-reviews-title']")
//	WebElement customerreview;
	
	@FindBy(xpath="//div[@class='a-fixed-left-grid AverageCustomerReviews a-spacing-small']/div")
	WebElement rating;
	
	@FindBy(xpath="//span[@data-hook='top-customer-reviews-title']")
	WebElement customerreviewnotavailable;
	
	@FindBy(xpath="//h3[@class='a-size-base-plus a-color-base a-text-bold']")
	WebElement customerreviewavailable;
	
	@FindBy(xpath="(//span[@class='a-dropdown-prompt'])[3]")
	WebElement customerreview1;
	
	//@FindBy(xpath="//div[@class='a-expander-content a-expander-partial-collapse-content']")
	@FindBy(xpath="//div[@id='detailBulletsWrapper_feature_div']/h2")
	WebElement productdetails;
	
	//@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])")
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> listoftheproducts;
	
	// From Sujit
	
	@FindBy (xpath = "(//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']/span/span)[2]")
	WebElement product_price_tag;
	
	@FindBy (xpath = "//div[@id='detailBulletsWrapper_feature_div']/h2")
	WebElement product_details_section;
	
	@FindBy (xpath = "//h2[@class='softlines']")
	WebElement product_description_section_1;
	
	@FindBy (xpath = "//h2[.='Product Description']")
	WebElement product_description_section_2;
	
	@FindBy (xpath = "//div[@class='a-fixed-left-grid AverageCustomerReviews a-spacing-small']/div")
	WebElement check_for_customer_reviews;
	
	
// 2. Creating the method for each component to perform its action
	
	
	
	
//	public void Assert_loop_price_desc_review(WebDriver driver)
//	{
//			boolean actual=(price.isDisplayed()||productdescription.isDisplayed()||customerreview.isDisplayed());
//			boolean expected =true;
//			Assert.assertEquals(actual, expected);
//			System.out.println("Product price, description and review found");
//	
//	}
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
	
	public void verify_searched_result_for_DetailsDescriptionReviewsPrice_Sections(WebDriver driver)
	{
		//List<WebElement> listoftheproducts=driver.findElements(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])"));
		int count= listoftheproducts.size(); // Count of total no. of auto suggestion loaded
		System.out.println("Total no. of elements found in the list is "+count);
		
		for(int i=0; i<count; i++)
		{
			
			WebElement product = listoftheproducts.get(i);
			String product_name = product.getText();
			product.click();
	
			Set<String> handles =driver.getWindowHandles();
			Iterator<String> iterate= handles.iterator();
			String parent_tab = iterate.next();
			String child_tab = iterate.next();
				
			driver.switchTo().window(child_tab);
			
			try
			{
				softassert.assertTrue(price.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				softassert.fail("product_price_tag is not displayed for - "+ product_name);
			}
			
			try
			{
				softassert.assertTrue(productdescription.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				try
				{
					softassert.assertTrue(productdescription1.isDisplayed());
				}
				catch(NoSuchElementException e12)
				{
					softassert.fail("product_description_section is not displayed for - "+ product_name);
				}
			}
			
			try
			{
				softassert.assertTrue(productdetails.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				softassert.fail("product_details_section is not displayed for - "+ product_name);
			}
			
			try
			{
				softassert.assertTrue(rating.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				
				softassert.fail("customer_reviews are not displayed for - "+ product_name);
			}

			driver.close();
			driver.switchTo().window(parent_tab);
			
		}
		
	softassert.assertAll();
		
	}
	
	
	public void Assert_searchresult2(WebDriver driver)
	{
 	driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1][contains(text(),'Shirt')]"));
		
	}
	
	

//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source7(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}

}

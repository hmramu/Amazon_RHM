package Project2.Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Source6 extends logincredentials {
	WebDriver driver;
// 1. Locating each components using @ Findby annotation
	
	@FindBy(linkText="Under ₹300")
	WebElement under300;
			
	@FindBy(linkText="Men's T-Shirts & Polos")
	WebElement menstshirtpolos;
	
	@FindBy(linkText="Men's T-Shirts")
	WebElement menstshirt;
	
	@FindBy(linkText="Men's Jeans")
	WebElement mensjeans;
	
// 2. Creating the method for each component to perform its action
	public void under_300()
	{
		under300.click();
	}
	
	public void Assert_loop_price(WebDriver driver)
	{
			//WebElement listoftheproducts=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[\" + k + \"]"));
			List<WebElement> listoftheproducts=driver.findElements(By.xpath("//span[@class='a-price-whole']	"));
			int count= listoftheproducts.size(); // Count of total no. of auto suggestion loaded
			System.out.println("Total no. of elements found in the list is "+count);
			
			for (int i=0;i<count; i++)
			{
			String namedescription= listoftheproducts.get(count-(count-i)).getText();//66-(66-66)| 60-(60-60)
			System.out.println("Price of item available at index/serach result "+i+" is "+namedescription);
			try {
				  int number = Integer.parseInt(namedescription);
				  boolean actual=(number<=299);
				  boolean expected =true;
				  Assert.assertEquals(actual, expected);
				  System.out.println("Product search price under 299 validated for the item "+i);
				} catch (NumberFormatException e) {
				  System.out.println("Product price is not available");
				}
			}
	}
	public void menstshirt_polos()
	{
		menstshirtpolos.click();
	}
	public void mens_jeans()
	{
		mensjeans.click();
	}
	public void mens_tshirts()
	{
		menstshirt.click();
	}
	
	
	public void Assert_loop_tshirt(WebDriver driver)
	{
			//WebElement listoftheproducts=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + k + "]"));
			List<WebElement> listoftheproducts=driver.findElements(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])"));
			int count= listoftheproducts.size(); // Count of total no. of auto suggestion loaded
			System.out.println("Total no. of elements found in the list is "+count);
			
			for (int i=0;i<count; i++)
			{
			String namedescription= listoftheproducts.get(count-(count-i)).getText();//66-(66-66)| 60-(60-60)|71 -(71-71)
			System.out.println((namedescription)+" :Its name for item "+i+"");
			boolean actual=(namedescription.contains("Shirt")||namedescription.contains("Tshirt")||namedescription.contains("Men")||namedescription.contains("Shirt"));
			boolean expected =true;
			Assert.assertEquals(actual, expected);
			System.out.println("Product search list validated for the item "+i);
			}

	}
	
	
	public void Assert_searchresult2(WebDriver driver)
	{
 	driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1][contains(text(),'Shirt')]"));
		
	}
	
	

//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source6(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}

}

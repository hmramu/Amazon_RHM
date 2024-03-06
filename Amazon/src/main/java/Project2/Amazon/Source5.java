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

public class Source5 extends logincredentials {
	WebDriver driver;
// 1. Locating each components using @ Findby annotation
	
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	WebElement nameoftheproduct;
	
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[\" + k + \"]")
	WebElement listoftheproducts;
			
	
// 2. Creating the method for each component to perform its action
	
	public void name_oftheproduct()
	{
		System.out.println(nameoftheproduct.getText());
	}
	public void Assert_searchresult()
	{
		String namedescription= nameoftheproduct.getText();
		boolean actual=namedescription.contains("Shirt");
		boolean expected =true;
		Assert.assertEquals(actual, expected);
		System.out.println("Product search validated");
	}
	
	public void Assert_loop(WebDriver driver)
	{
			//WebElement listoftheproducts=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + k + "]"));
			List<WebElement> listoftheproducts=driver.findElements(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])"));
			int count= listoftheproducts.size(); // Count of total no. of auto suggestion loaded
			System.out.println("Total no. of elements found in the list is "+count);
			
			for (int i=0;i<count; i++)
			{
			String namedescription= listoftheproducts.get(i).getText();//66-(66-66)| 60-(60-60)|71 -(71-71)
			System.out.println((namedescription)+" :Its name for item "+i+"");
			boolean actual=(namedescription.contains("Shirt")||namedescription.contains("Tshirt")||namedescription.contains("shirt"));
			boolean expected =true;
			Assert.assertEquals(actual, expected);
			System.out.println("Product search list validated for the item "+i);
			}

	}
	/*
	public void Assert_loop1(WebDriver driver)
	{
		for(int i=0;i<=66;i++)
		{
		WebElement listoftheproducts=driver.findElement(By.linkText("//span[@class='a-size-base-plus a-color-base a-text-normal'])["+i+"]"));
		String namedescription= listoftheproducts.get(i).getText();//66-(66-66)| 60-(60-60)|71 -(71-71)
		System.out.println((namedescription)+" :Its name for item "+i+"");
		boolean actual=(namedescription.contains("Shirt")||namedescription.contains("Tshirt")||namedescription.contains("shirt"));
		boolean expected =true;
		Assert.assertEquals(actual, expected);
		System.out.println("Product search list validated for the item "+i);
		}
	}
	*/
	public void Assert_searchresult1(WebDriver driver)
	{
		WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
		expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[@class='a-button a-button-dropdown quantity']"))));
		expwait.until(ExpectedConditions.textToBePresentInElement(nameoftheproduct, "T-Shirt Unisex Regular Fit Casual Half Sleeve Round Neck"));
		
		
		/*
		WebDriverWait wait = new WebDriverWait(newDriver,30);

		wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));

		*element - WebElement

		*textToAppear - Text
		*/
	}
	public void Assert_searchresult2(WebDriver driver)
	{
 	driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1][contains(text(),'Shirt')]"));
		
	}
	
	

//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source5(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}

}

package Project2.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Source4 extends logincredentials {
	WebDriver driver;
// 1. Locating each components using @ Findby annotation
	
	@ FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(xpath="(//span[@class='nav-line-1 nav-progressive-content'])[2]")
	WebElement profile1;
	
	@FindBy(linkText="Your Account")
	WebElement youraccount1;
	
	@FindBy(xpath="(//div[@class='a-column a-span9 a-span-last'])[2]")
	WebElement profiledetails;
	
	@FindBy(linkText="Edit")
	WebElement editname;
	
	//@FindBy(xpath="//input[@id='cnep_1C_submit_button']")
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement savechanges;
	
	@FindBy(xpath="(//div[@class='a-alert-content'])[1]")
	WebElement confirmationmessage;
	
// 2. Creating the method for each component to perform its action
	
	public void profile_access1(WebDriver driver)
	{	
		Actions a1=new Actions(driver);
		a1.moveToElement(profile1).perform();
	}
	public void your_account1()
	{
		youraccount1.click();
	}
	public void profile_details()
	{
		profiledetails.click();
	}
	public void edit_name()
	{
		editname.click();
	}
	public void save_changes()
	{
		savechanges.click();
	}
	public void Assert_confirmation()
	{
		String actual= confirmationmessage.getText();
		String expected="Name updated.";
		Assert.assertEquals(actual, expected);
		System.out.println("Profile details update validated");
	}

//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source4(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}

}

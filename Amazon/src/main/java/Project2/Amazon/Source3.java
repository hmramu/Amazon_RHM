package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Source3 extends logincredentials {
	WebDriver driver;
// 1. Locating each components using @ Findby annotation
	
	@ FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	WebElement incorrectpasswordmessage;
	
	@FindBy(xpath="(//span[@class='nav-line-1 nav-progressive-content'])[2]")
	WebElement hellouser;
				
// 2. Creating the method for each component to perform its action
	public void pwd1() throws EncryptedDocumentException, IOException
	{
		Source3 refvar =new Source3(driver); 
		refvar.fetchunpw1(username1,password1);
		passwordfield.sendKeys(refvar.password1);
	}
	public void assert_incorrectpw()
	{
		String actual= incorrectpasswordmessage.getText();
		String expected="Your password is incorrect";
		Assert.assertEquals(actual, expected);
		System.out.println("Incorrect password entry validated");
	}

//3. Intializing each component using page factory class
// NullPointerException will arrive without intializing element try to perform action 
		
	public Source3(WebDriver driver)
	{
		PageFactory.initElements(driver, this);// init meaning initializing elements
	}

}

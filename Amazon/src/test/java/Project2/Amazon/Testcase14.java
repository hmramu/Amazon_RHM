package Project2.Amazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Go to the orders page and click on your last ordered product and give 5 star ratings
 */
@Listeners(Testlistners_implemented.class)
public class Testcase14 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Items_qty_delete(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		Source14 s14=new Source14(driver);// remember scanner and actions class
		s14.un();
		s9.un_submit();
		s14.pwd();
		s9.signin();
		s9.profileaccess(driver);
		s14.your_orders();
		s14.write_productreview();
		s14.product_rating();
		s14.rating_ack();
		
}
	
}

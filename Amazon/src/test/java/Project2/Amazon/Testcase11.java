package Project2.Amazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Validate the entire checkout process, including address selection, payment method selection, and order review.
 */
@Listeners(Testlistners_implemented.class)
public class Testcase11 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Items_qty_delete(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		s9.searchproduct(data);
		s9.select_firstproduct();
		s9.switch_window(driver);
		s9.add_tocart();
		
		Source10 s10=new Source10(driver);// remember scanner and actions class
		s10.go_tocart();

		Source11 s11=new Source11(driver);// remember scanner and actions class
		s11.proceed_tobuy();
		s11.use_thisaddress();
		s11.use_thispaymentmethod(driver);
		s11.Assert_orderreview();
		
		
}
	
}

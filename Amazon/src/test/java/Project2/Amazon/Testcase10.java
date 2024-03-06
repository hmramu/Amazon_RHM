package Project2.Amazon;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Test updating item quantities and removing items from the cart
 */
@Listeners(Testlistners_implemented.class)
public class Testcase10 extends Launch_Quit{

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
//		WebDriverWait expwait= new WebDriverWait(driver,Duration.ofSeconds(20));// explicit wait until appearance of search bar
//		expwait.until(ExpectedConditions.titleIs("Amazon.in Shopping Cart"));
//		s10.qty_selection();
		s10.qty_list(driver);
		s10.assert_qty5(driver);
		s10.assert_qtydelete(driver);
}
	
}

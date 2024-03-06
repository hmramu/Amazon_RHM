package Project2.Amazon;
/*Verify that items can be added to the shopping cart from product pages.
 * 
 */

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
@Listeners(Testlistners_implemented.class)


public class Testcase9 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Items_add_cart(String data) throws EncryptedDocumentException, IOException
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
		s9.added_tocart();
		s9.assert_status();
		
		//String expected="Added to Cart";
		//Assert.assertEquals(expected,actual );
		
		//s9.profileaccess(driver);
		//s9.logout();
	}

}

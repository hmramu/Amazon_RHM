package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Verify that searching with filters (e.g., category, price range) yields accurate results.
 */
@Listeners(Testlistners_implemented.class)

public class Testcase6 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Edit_user_progil(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		s9.searchproduct(data);
		Source6 s6=new Source6(driver);// remember scanner and actions class
		s6.under_300();
		s6.Assert_loop_price(driver);
		s6.menstshirt_polos();
		s6.mens_tshirts();
		s6.Assert_loop_tshirt(driver);
		
	}
}


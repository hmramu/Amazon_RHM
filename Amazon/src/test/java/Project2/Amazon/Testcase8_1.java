package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Check if products can be sorted by relevance, price, rating etc
 */
@Listeners(Testlistners_implemented.class)

public class Testcase8_1 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Edit_user_progil(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		s9.searchproduct(data);
		Source8 s8=new Source8(driver);// remember scanner and actions class
		s8.Assert_sorting_pric_high_low(driver);
		
	}
}


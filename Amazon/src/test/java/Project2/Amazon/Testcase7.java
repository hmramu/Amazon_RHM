package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Ensure that the product detail page displays all necessary information(price, reviews, description).
 */
@Listeners(Testlistners_implemented.class)

public class Testcase7 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Edit_user_progil(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		s9.searchproduct(data);
		//s9.select_firstproduct();
		//s9.switch_window(driver);
		Source7 s7=new Source7(driver);// remember scanner and actions class
		//s7.Assert_loop_price_desc_review(driver);
		//s7.Assert_loop_pdr(driver);
		s7.verify_searched_result_for_DetailsDescriptionReviewsPrice_Sections(driver);
		
	}
}


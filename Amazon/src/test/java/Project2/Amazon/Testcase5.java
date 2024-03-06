package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Test searching for products using its name like shoe
 */
@Listeners(Testlistners_implemented.class)

public class Testcase5 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Edit_user_progil(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		s9.searchproduct(data);
		Source5 s5=new Source5(driver);// remember scanner and actions class
		s5.name_oftheproduct();
		//s5.Assert_searchresult();
		s5.Assert_loop(driver);
		//s5.Assert_searchresult1(driver);
		//s5.Assert_searchresult2(driver);
	}
}


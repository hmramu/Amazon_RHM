package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Check if a user can successfully edit their profile information
 * 
 */
@Listeners(Testlistners_implemented.class)

public class Testcase4 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Edit_user_progil(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		Source4 s4=new Source4(driver);// remember scanner and actions class
		s4.profile_access1(driver);
		s4.your_account1();
		s4.profile_details();
		s4.edit_name();
		s4.save_changes();
		s4.Assert_confirmation();
	}
}


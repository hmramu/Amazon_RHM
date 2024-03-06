package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Verify login is successful with correct email and password.
 */
@Listeners(Testlistners_implemented.class)

public class Testcase2 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void login_with_valid_credentials(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		s9.pwd();
		s9.signin();
		
		Source2 s2=new Source2(driver);// remember scanner and actions class
		//s2.assert_login();
		//s2.assert_login1();
		s2.assert_login2(driver);
	}
}

package Project2.Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*Ensure login fails with incorrect email or password.
 */
@Listeners(Testlistners_implemented.class)

public class Testcase3 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void login_with_valid_credentials(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.un();
		s9.un_submit();
		Source3 s3=new Source3(driver);// remember scanner and actions class
		s3.pwd1();
		s9.signin();
		s3.assert_incorrectpw();
		
	}
}

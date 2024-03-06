package Project2.Amazon;
/*Test if a new user can successfully register.
 * 
 */

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Testlistners_implemented.class)
public class Testcase1 extends Launch_Quit{

	@Test(dataProvider="Product", dataProviderClass = Dataprovider.class)
	public void Items_qty_delete(String data) throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Source1 s1=new Source1(driver);// remember scanner and actions class
		Source9 s9=new Source9(driver);// remember scanner and actions class
		s9.profileaccess(driver);
		s1.start_here();
		s1.your_name();
		s1.mobile_num();
		s1.pass_word();
		s1.verify_mobile();
		s1.verification_status();
}
	


}

package Project2.Amazon;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class logincredentials 
{
	public String username;
	public String password;
	public String username1;
	public String password1;
	public String username2;
	public String password2;
//	public WebDriver driver;

	public void fetchunpw(String username, String password) throws EncryptedDocumentException, IOException
	{

		FileInputStream filepath = new FileInputStream("C:\\Users\\SESA585399\\eclipse-workspace\\Amazon\\testdata\\Inputdata.xlsx");
		Workbook file = WorkbookFactory.create(filepath);
		this.username =file.getSheet("usernamepw").getRow(1).getCell(0).getStringCellValue();
		//this.username =NumberToTextConverter.toText(w1.getSheet("usernamepw").getRow(1).getCell(0).getNumericCellValue());
		this.password =file.getSheet("usernamepw").getRow(1).getCell(1).getStringCellValue();
		//return username;
	}
	
	public void fetchunpw1(String username1, String password1) throws EncryptedDocumentException, IOException
	{
		FileInputStream filepath = new FileInputStream("C:\\Users\\SESA585399\\eclipse-workspace\\Amazon\\testdata\\Inputdata.xlsx");
		Workbook file = WorkbookFactory.create(filepath);
		this.username1 =file.getSheet("usernamepw").getRow(1).getCell(0).getStringCellValue();
		//this.username =NumberToTextConverter.toText(w1.getSheet("usernamepw").getRow(1).getCell(0).getNumericCellValue());
		//return username;
		this.password1 =file.getSheet("usernamepw").getRow(2).getCell(1).getStringCellValue();
	}
	
	public void fetchunpw2(String username2, String password2) throws EncryptedDocumentException, IOException
	{
		FileInputStream filepath = new FileInputStream("C:\\Users\\SESA585399\\eclipse-workspace\\Amazon\\testdata\\Inputdata.xlsx");
		Workbook file = WorkbookFactory.create(filepath);
		this.username2 =file.getSheet("usernamepw").getRow(4).getCell(0).getStringCellValue();
		//this.username =NumberToTextConverter.toText(w1.getSheet("usernamepw").getRow(1).getCell(0).getNumericCellValue());
		//return username;
		this.password2 =file.getSheet("usernamepw").getRow(4).getCell(1).getStringCellValue();
	}
	
}

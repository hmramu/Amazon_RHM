package Project2.Amazon;

import org.testng.annotations.DataProvider;

public class Dataprovider 
{
	
	@DataProvider(name="Product")
	public Object[][] methodtolistproduct()
	{
		return new Object[][] {{"Shirt"}};//,{"Men's Kurta"},{"T Shirt"}};
		
	}
	
	
//	public String productname1;
//	public String password;
//	public WebDriver driver;
	/*
	@DataProvider(name="Product")
	public Object methodtolistproduct(String productname1) throws EncryptedDocumentException, IOException
	{

		FileInputStream filepath = new FileInputStream("C:\\Users\\SESA585399\\eclipse-workspace\\MavenProject\\Testdata\\Dataprovider.xlsx");
		Workbook file = WorkbookFactory.create(filepath);
		//String productname1;
		return   productname1 =file.getSheet("Productlist").getRow(1).getCell(1).getStringCellValue();
		
	}
	*/
}

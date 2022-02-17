package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\Course\\Testing\\LoginTest.xlsx");
	
	//Login Test
	
	public  String WrongEmail= d.getCellData("Sheet1", 0, 1);
	public  String Wrongpassword = d.getCellData("Sheet1", 0, 2);
	public String EmailWithSpecialChar=d.getCellData("Sheet1", 0, 3);
	public String globalerr = d.getCellData("Sheet1", 1, 4);
	public String specialCharErr = d.getCellData("Sheet1", 1, 5);
	public String emptyEmailErr = d.getCellData("Sheet1", 1, 6);
	public String EmptypassErr =d.getCellData("Sheet1", 1, 7);

	
}

package data;

import utilities.Xls_Reader;

public class Guru99DataFile {
	
	
	Xls_Reader d = new Xls_Reader("C:\\Course\\Testing\\Guru99.xlsx");
	
	
	 public String username = d.getCellData("Sheet1", 1, 1);
	 public String password = d.getCellData("Sheet1", 1, 2);
	 public String InvalidUsername =d.getCellData("Sheet1", 0, 7);
	 public String InvalidPassword = d.getCellData("Sheet1", 0, 8);
	 public	String Titlepage = d.getCellData("Sheet1", 1, 4);
	 public String errmsg = d.getCellData("Sheet1", 1, 5);
}

//  -------------------------------     TO SEE IF ITS PRITING THE CORRECT VALUE - ADD IT IN TESTFILE AND CHECK ----------------------------

//System.out.println(DF.username);
//System.out.println(DF.password);
//System.out.println(DF.InvalidUsername);
//System.out.println(DF.InvalidPassword);
//System.out.println(DF.Titlepage);
//System.out.println(DF.errmsg);


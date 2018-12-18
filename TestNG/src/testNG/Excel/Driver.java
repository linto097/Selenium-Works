package testNG.Excel;

public class Driver {

	public static void main(String[] args) throws Exception {
		// This is to open the Excel file. Excel path, file name and the sheet name are
		// parameters to this method

		ExcelUtilities.setExcelFile(Constants.Path_TestData + Constants.File_TestData, "Sheet1");
		
		//execute the test
		SignInTest.Execute();

		System.out.println("Login Successful");

		// This is to send the PASS value to the Excel sheet in the result column.

		ExcelUtilities.setCellData("Test Passed", 1, 3);	}

}

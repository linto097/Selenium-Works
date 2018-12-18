package testNG.Excel;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {



	private static XSSFSheet ExcelWSheet;


	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;


	private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			// Get sheet with the given name
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			// Get row and cell with the given number
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			// get value in the cell
			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {

			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				// create a cell in the file
				Cell = Row.createCell(ColNum);

				// set the value in the created cell
				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

 			// file output stream is an output stream for writing data to a File or to a
			// FileDescriptor
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

			// Write out this document to an Outputstream
			ExcelWBook.write(fileOut);

			// The general idea behind flush is that calling it is an indication that,
			// if any bytes previously written have been buffered by the implementation of
			// the output stream, such bytes should immediately be written to their intended
			// destination.
			fileOut.flush();

			// Closes this file output stream and releases any system resources associated
			// with this stream
			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}
	}
}

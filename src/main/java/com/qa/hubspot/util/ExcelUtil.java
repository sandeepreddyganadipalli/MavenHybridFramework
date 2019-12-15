package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TESTDATA_SHEET_PATH = "C://Users//sganadipalli//Desktop//Documents//NaveenPOMSeries//src//main//java//com//qa//hubspot//testdata//HubSpotTestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	/**
	 * this methos is used get the data from test data sheet on the basis of sheet
	 * name...
	 * 
	 * @param sheetName
	 */
	public static Object[][] getTestData(String sheetName) {

		// fileinoutstreamclass is used to make the connection with that particular file

		try {
			FileInputStream fp = new FileInputStream(TESTDATA_SHEET_PATH);

			// workbookfactory it is class available in apache poi and workbook factory will
			// give you one method that is create methos --it will create local copy of your
			// excel file in java memory.and this create method will give you workbook class
			// object
			book = WorkbookFactory.create(fp);
			sheet = book.getSheet(sheetName);//

			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}

			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}

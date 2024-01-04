package excel

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.util.ObservableList.ChangeType
import internal.GlobalVariable
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import org.apache.poi.xssf.usermodel.*



public class ReadFileExcel {

	@Keyword
	def getDataExcel() {
		File file = new File("C:\\Users\\lnnam\\Desktop\\Data Orange.xlsx")
		FileInputStream fis = new FileInputStream(file)
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		XSSFSheet sheet = workbook.getSheetAt(0) // Use the correct sheet index (0-based)

		int rows = sheet.getLastRowNum()
		int cells = sheet.getRow(1).getLastCellNum()
		String cellvalue = sheet.getRow(0).getCell(0).getStringCellValue()

		//		for (int i = 0; i <= rows; i++) {
		//			XSSFRow row = sheet.getRow(i)
		//			for (int j = 0; j < cells; j++) {
		//				XSSFCell cell = row.getCell(j)
		//				switch(cell.getCellType())
		//				{
		//					case STRING: System.out.println(cell.getStringCellValue());break;
		//					case NUMERIC: System.out.println(cell.getNumericCellValue());break;
		//					case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
		//				}
		//
		//
		//			}
		//			System.out.println()
		//		}

		workbook.close()
		fis.close()
	}
}


package table

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

import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys

import org.apache.poi.ss.formula.functions.Choose
import org.openqa.selenium.By as By

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUICommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

public class TableResources {
	@Keyword
	def Verify_All_Data_Web_Tables(String Choose_Data) {
	    WebDriver driver = DriverFactory.getWebDriver()
	
	    for (def rownumb = 1; rownumb <= findTestData(Choose_Data).getRowNumbers(); rownumb++) {
	        int page = WebUI.getText('Object Repository/Page_Web_Table/span_1') as int
	        int row = (page == 1) ? 0 : ((page == 2) ? 10 : 0)
	
	        for (def colnumb = 1; colnumb <= findTestData(Choose_Data).getColumnNumbers(); colnumb++) {
	            WebElement Table = driver.findElement(By.xpath('//div[@class="rt-tr-group"][' + rownumb + ']//div[@class="rt-td"][' + colnumb + ']'))
	            String celltext = Table.getText()
	            String expectedText = findTestData(Choose_Data).getValue(colnumb, rownumb + row)
	            KeywordUtil.logInfo('Actual result: ' + celltext + '; Expected result: ' + expectedText)
	            WebUI.verifyMatch(celltext, expectedText, false)
	        }
	        Thread.sleep(3000)
	    }
	}


	@Keyword
	def Fill_Data_In_Fields(){
		WebUI.setText(findTestObject('Page_Web_Table/input_First Name_firstName'), findTestData('Data Files/ListUser').getValue(1, 4))

		WebUI.setText(findTestObject('Page_Web_Table/input_Last Name_lastName'), findTestData('Data Files/ListUser').getValue(2, 4))

		WebUI.setText(findTestObject('Page_Web_Table/input_Email_userEmail'), findTestData('Data Files/ListUser').getValue(4, 4))

		WebUI.setText(findTestObject('Page_Web_Table/input_Age_age'), findTestData('Data Files/ListUser').getValue(3, 4))

		WebUI.setText(findTestObject('Page_Web_Table/input_Salary_salary'), findTestData('Data Files/ListUser').getValue(5, 4))

		WebUI.setText(findTestObject('Page_Web_Table/input_Department_department'), findTestData('Data Files/ListUser').getValue(6, 4))
	}
	@Keyword
	def Verify_Add_New_Data(){

		WebDriver driver = DriverFactory.getWebDriver()

		for(def colnumb=1; colnumb<=findTestData('Data Files/ListUser').getColumnNumbers(); colnumb++) {
			WebElement Table = driver.findElement(By.xpath('//div[@class="rt-tr-group"][4]//div[@class="rt-td"]['+ colnumb +']'))
			String celltext = Table.getText()
			String expectedText = findTestData('Data Files/ListUser').getValue(colnumb, 4)
			KeywordUtil.logInfo('Actual result: ' + celltext + '; Expected result: ' + expectedText)
			WebUI.verifyMatch(celltext, expectedText,false)
			Thread.sleep(3000)
		}
	}
	@Keyword
	def Verify_Header(){
		WebDriver driver = DriverFactory.getWebDriver()

		for(def colnumb=1; colnumb<=findTestData('Data Files/Header').getColumnNumbers(); colnumb++) {
			WebElement Table = driver.findElement(By.xpath('//div[@role="columnheader"][' + colnumb + ']//div[@class="rt-resizable-header-content"]'))
			String celltext = Table.getText()
			String expectedText = findTestData('Data Files/Header').getValue(colnumb, 1)
			KeywordUtil.logInfo('Actual result: ' + celltext + '; Expected result: ' + expectedText)
			WebUI.verifyMatch(celltext, expectedText,false)
			Thread.sleep(3000)
		}
	}
	@Keyword
	def Import_Employees(){
		WebDriver driver = DriverFactory.getWebDriver()
		for(def rownumb=1; rownumb<=findTestData('Data Files/ListUserImport (1)').getRowNumbers(); rownumb++) {
			WebUI.click(findTestObject('Object Repository/Page_Web_Table/button_Add'))
			for(def colnumb=1; colnumb<=findTestData('Data Files/ListUser').getColumnNumbers(); colnumb++) {
				WebElement Table = driver.findElement(By.xpath('(//form[@id="userForm"]//child::input)[' + colnumb + ']'))
				Table.sendKeys(findTestData('Data Files/ListUserImport (1)').getValue(colnumb, rownumb))
				Thread.sleep(500)
			}
			WebUI.click(findTestObject('Object Repository/Page_Web_Table/button_Submit'))
		}
	}
}


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

import groovy.transform.ThreadInterrupt
import internal.GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.TakesScreenshot
import org.apache.poi.ss.formula.functions.Choose
import org.checkerframework.checker.units.qual.Length
import org.openqa.selenium.By as By

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUICommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.openqa.selenium.support.ui.ExpectedConditions as EC
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import java.time.Duration as Duration
import java.util.concurrent.TimeUnit

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
public class TableResources {

	@Keyword
	def Verify_All_Data_Web_Tables(String Choose_Data) {
		WebDriver driver = DriverFactory.getWebDriver()

		//Total page contains data
		WebElement pageElement = driver.findElement(By.xpath('//span[@class="-pageInfo"]//child::span'))
		String pageText = pageElement.getText()
		int pageNumber = Integer.parseInt(pageText)

		int number = 0

		//Max row in 1 page
		WebElement rowElement = driver.findElement(By.xpath('//select[@aria-label="rows per page"]//child::option[text()="10 rows"]'))
		String optionText = rowElement.getText()
		def numericPart = optionText.replaceAll("\\D", "")
		int row_per_page = Integer.parseInt(numericPart)

		for (int i=0; i<pageNumber; i++) {
			//The number of row in per page have data
			List<WebElement> row_web = driver.findElements(By.xpath('//div[@class="rt-tbody"]//div[@role="row"]/child::div[text()]'))
			for (def rownumb = 1; rownumb <= row_web.size()/6; rownumb++) {
				for (def colnumb = 1; colnumb <= findTestData(Choose_Data).getColumnNumbers(); colnumb++) {
					WebElement Table = driver.findElement(By.xpath('//div[@class="rt-tr-group"][' + rownumb + ']//div[@class="rt-td"][' + colnumb + ']'))
					String celltext = Table.getText()
					String expectedText = findTestData(Choose_Data).getValue(colnumb, rownumb + number)
					KeywordUtil.logInfo('Actual result: ' + celltext + '; Expected result: ' + expectedText)
					WebUI.verifyMatch(celltext, expectedText, false)
				}
				Thread.sleep(1000)


			}

			WebUI.click(findTestObject('Object Repository/Page_Web_Table/button_Next'),FailureHandling.OPTIONAL)
			number = number + row_per_page
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
	@Keyword
	public boolean isFileDownloaded(String downloadPath, String fileName) {

		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		String lastAttempt = '';
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().equals(fileName)) {
					// File has been found, it can now be deleted:
					//					dirContents[i].delete();
					KeywordUtil.logInfo(fileName + ' has been downloaded')
					KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath)
					return true;
				}
				lastAttempt = dirContents[i].getName().equals(fileName);
			}
			if (lastAttempt != fileName) {
				KeywordUtil.markFailed(fileName + ' does not exist in ' + downloadPath)
				return false;
			}
		}
		return false;
	}
	@Keyword
	public boolean DeletedDownloaded(String downloadPath, String fileName) {

		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().equals(fileName)) {
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					KeywordUtil.markPassed(fileName + ' was deleted')
					return true;

				}
			}
			return false;
		}
	}
	@Keyword
	def uploadFile (TestObject to, String filePath) {
		WebUI.waitForElementClickable(to, 10)
		WebUI.click(to)
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000); //Millisecond 1 second delay only if needed
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000); //Millisecond 1 second delay only if needed
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	@Keyword
	def Verify_Header_Admin(String Input_file_path){
		WebDriver driver = DriverFactory.getWebDriver()

		for(def colnumb=1; colnumb<=findTestData(Input_file_path).getColumnNumbers(); colnumb++) {
			WebElement Header = driver.findElement(By.xpath('//div[@role="columnheader" and @style]['+colnumb+']'))
			String celltext = Header.getText()
			String expectedText = findTestData(Input_file_path).getValue(colnumb, 1)
			KeywordUtil.logInfo('Actual result: ' + celltext + '; Expected result: ' + expectedText)
			WebUI.verifyMatch(celltext, expectedText,false)
			Thread.sleep(500)
		}
	}
	@Keyword
	def highlightObject(TestObject to){
		WebElement element = WebUiCommonHelper.findWebElement(to, 30)
		WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background: #00e5ff; border: 1px solid black;');", Arrays.asList(
				element))
		WebUI.delay(1);
		//		WebUI.executeJavaScript("arguments[0].setAttribute('style','border: solid 1px lightblue');", Arrays.asList(
		//			   element));
	}
	@Keyword
	def Login_Page_OrangeHRM (String Username, String Password) {
		WebDriver driver = DriverFactory.getWebDriver()

		def wait = new WebDriverWait(driver, 10)

		driver.findElement(By.name('username')).sendKeys(Username)

		driver.findElement(By.name('password')).sendKeys(Password)

		WebElement btn_Login = wait.until(EC.elementToBeClickable(By.xpath('//button[@type="submit"]')))

		btn_Login.click()
	}
	@Keyword
	def field_Data_Page_Add (String Username, String Employee_Name_Hint) {
		WebDriver driver = DriverFactory.getWebDriver()

		def wait = new WebDriverWait(driver, 10)
		WebElement Choose_User_Role = wait.until(EC.visibilityOfElementLocated(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"][1]//child::div[text()="-- Select --"]')))

		Choose_User_Role.click()
		Choose_User_Role.sendKeys(Keys.ARROW_DOWN)
		Choose_User_Role.sendKeys(Keys.ENTER)

		WebElement Input_Employee_Name = driver.findElement(By.xpath('//input[@placeholder="Type for hints..."]'))

		Input_Employee_Name.sendKeys(Employee_Name_Hint)
		driver.sleep(3000)
		Input_Employee_Name.sendKeys(Keys.ARROW_DOWN)
		Input_Employee_Name.sendKeys(Keys.ENTER)

		WebElement Choose_Status = driver.findElement(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"]//child::div[text()="-- Select --"]'))

		Choose_Status.sendKeys(Keys.ARROW_DOWN)
		Choose_Status.sendKeys(Keys.ENTER)

		driver.findElement(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"][4]//child::input[@autocomplete="off"]')).sendKeys(Username)

		driver.findElement(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters user-password-cell"]//child::input[@type="password"]')).sendKeys('namnam159')

		driver.findElement(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"]//child::input[@type="password"]')).sendKeys('namnam159')

		WebUI.takeScreenshot()

		driver.findElement(By.xpath('//button[@type="submit"]')).click()

		wait.until(EC.visibilityOfElementLocated(By.xpath('//button[@class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"]')))

		driver.sleep(5000)
	}
	@Keyword
	def Open_Browser(String URL) {
		WebUI.openBrowser(URL)
		WebUI.maximizeWindow()
	}
	@Keyword
	def Search_By_Username(List dataTest, int LabelSearch) {
		WebDriver driver = DriverFactory.getWebDriver()
		for (String testData : dataTest) {
			driver.findElement(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"]['+ LabelSearch +']//child::input')).sendKeys(testData)

			WebUI.click(findTestObject('Object Repository/Page_Admin/button_Search'))

			String record = WebUI.getText(findTestObject('Object Repository/Page_Admin/span_(1) Record Found'))

			KeywordUtil.logInfo('Value test is: ' + testData)

			WebUI.takeScreenshot()

			boolean result = WebUI.verifyEqual(record, '(1) Record Found', FailureHandling.OPTIONAL)
			if (!result) {
				WebUI.verifyEqual(record, 'No Records Found')
			}

			WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_Username_Search'), Keys.chord(Keys.CONTROL, 'a'))

			WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_Username_Search'), Keys.chord(Keys.BACK_SPACE))
		}
	}
	@Keyword
	def Search_By_User_Role	() {
		WebDriver driver = DriverFactory.getWebDriver()
		'Clicking on label User Role'
		WebUI.click(findTestObject('Object Repository/Page_Admin/Label_User Role_Search'))

		'Choose role Admin'
		WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_User Role_Search'), Keys.chord(Keys.ARROW_DOWN))

		WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_User Role_Search'), Keys.chord(Keys.ENTER))

		'Clicking on button Search'
		WebUI.click(findTestObject('Object Repository/Page_Admin/button_Search'))

		KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Page_Admin/span_(1) Record Found')))

		List<WebElement> total_row = driver.findElements(By.xpath('//div[@class="oxd-table-body"]//child::div[@role="row"]//child::div[3]'))
		'Verify result of search by User Role "Admin"'

		for (WebElement role : total_row) {
			WebUI.verifyEqual(role.getText(), 'Admin')
		}

		'Highlight number of record found'
		highlightObject(findTestObject('Object Repository/Page_Admin/span_(1) Record Found'))

		'Capture screen when search by User Role Admin'
		WebUI.takeScreenshot()
	}
	@Keyword
	def Search_By_Employee_Name(String Employee_Name_Hint, String EmployeeName, String EmployeeName_NotExist) {
		WebDriver driver = DriverFactory.getWebDriver()
		'Input Employee Name existed'
		WebUI.setText(findTestObject('Object Repository/Page_Admin/Label_Employee_Name_Search'), Employee_Name_Hint)

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_Employee_Name_Search'), Keys.chord(Keys.ARROW_DOWN))

		WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_Employee_Name_Search'), Keys.chord(Keys.ENTER))

		'Clicking on button Search'
		WebUI.click(findTestObject('Object Repository/Page_Admin/button_Search'))

		KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Page_Admin/span_(1) Record Found')))

		List Employee_name_list = driver.findElements(By.xpath('//div[@class="oxd-table-body"]//child::div[@role="row"]//child::div[4]'))

		'Verify result of searching by Employee Name existed'
		for (WebElement Employee_Name : Employee_name_list) {
			WebUI.verifyEqual(Employee_Name.getText(), EmployeeName)
		}

		'Highlight number of record found'
		highlightObject(findTestObject('Object Repository/Page_Admin/span_(1) Record Found'))

		'Capture screen when searching by Employee Name existed'
		WebUI.takeScreenshot()

		'Clicking on button Reset'
		WebUI.click(findTestObject('Object Repository/Page_Admin/Button_Reset'))

		'Input Employee Name not existed'
		WebUI.setText(findTestObject('Object Repository/Page_Admin/Label_Employee_Name_Search'), EmployeeName_NotExist)

		'Clicking on button Search'
		WebUI.click(findTestObject('Object Repository/Page_Admin/button_Search'))

		'Verify result of searching by Employee Name not existed'
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Page_Admin/Alert_Msg')), 'Invalid')

		'Highlight alert msg'
		highlightObject(findTestObject('Object Repository/Page_Admin/Alert_Msg'))

		'Capture screen when searching by Employee Name not existed'
		WebUI.takeScreenshot()
	}
	@Keyword
	def Search_By_Status () {
		WebDriver driver = DriverFactory.getWebDriver()

		'Clicking on label Status'
		WebUI.click(findTestObject('Object Repository/Page_Admin/Label_Status_Search'))

		'Choose status Enable'
		WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_Status_Search'), Keys.chord(Keys.ARROW_DOWN))

		WebUI.sendKeys(findTestObject('Object Repository/Page_Admin/Label_Status_Search'), Keys.chord(Keys.ENTER))

		'Clicking on button Search'
		WebUI.click(findTestObject('Object Repository/Page_Admin/button_Search'))

		KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Page_Admin/span_(1) Record Found')))

		'Verify result of searching by Status Enabled'
		List Status_List = driver.findElements(By.xpath('//div[@class="oxd-table-body"]//child::div[@role="row"]//child::div[5]'))

		for (WebElement Status : Status_List) {
			WebUI.verifyMatch(Status.getText(), 'Enabled', false)
		}
		'Highlight record found'
		highlightObject(findTestObject('Object Repository/Page_Admin/span_(1) Record Found'))

		'Capture screen when searching by Status Enabled'
		WebUI.takeScreenshot()
	}
	@Keyword
	def Searching_Username (String Username) {
		WebDriver driver = DriverFactory.getWebDriver()
		def wait = new WebDriverWait(driver, 10)
		wait.until(EC.elementToBeClickable(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"][1]//child::input')))
		driver.findElement(By.xpath('//div[@class="oxd-grid-item oxd-grid-item--gutters"][1]//child::input')).sendKeys(Username)
		driver.sleep(1000)
		driver.findElement(By.xpath('//div[@class="oxd-form-actions"]//button[@type="submit"]')).click()
	}
	@Keyword
	def Verify_Info_Add_User(String Username, String EmployeeName) {
		WebDriver driver = DriverFactory.getWebDriver()
		def wait = new WebDriverWait(driver, 10)
		'Waiting for information display'
		WebElement Username_Check = wait.until(EC.visibilityOfElementLocated(By.xpath('//div[@class="oxd-table-body"]//div[@role="cell"][2]//child::div')))

		'Verify Username of User'
		WebUI.verifyMatch(Username_Check.getText(), Username, false)

		'Verify User Role of User'
		WebUI.verifyMatch(driver.findElement(By.xpath('//div[@class="oxd-table-body"]//div[@role="cell"][3]//child::div')).getText(),
				'Admin', false)

		'Verify Employee Name of User'
		WebUI.verifyMatch(driver.findElement(By.xpath('//div[@class="oxd-table-body"]//div[@role="cell"][4]//child::div')).getText(),
				EmployeeName, false)

		'Verify Status of User'
		WebUI.verifyMatch(driver.findElement(By.xpath('//div[@class="oxd-table-body"]//div[@role="cell"][5]//child::div')).getText(),
				'Enabled', false)
	}
	@Keyword
	def Verify_Sort () {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> Elements = driver.findElements(By.xpath('//table[@id="myTable"]/tbody/tr/td[1]'))

		List<String> Name_of_List = []

		for (WebElement name: Elements) {
			//			WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(name))
			String NameElements = name.getText()
			Name_of_List.add(NameElements)
		}
		//		reverse()
		//		toSorted()
		//		println(listCountry)
		//		listCountry = listCountry.toSorted()
		//		println(listCountryverify)
		//		for (int i = 0; i <= listCountry.size(); i++) {
		//			WebUI.verifyEqual(listCountry[i], listCountryverify[i])
		//		}
		return Name_of_List
	}
}



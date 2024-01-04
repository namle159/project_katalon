import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

'Open page Date-Picker'
WebUI.openBrowser('https://demoqa.com/date-picker')
'MaximizeWindow'
WebUI.maximizeWindow()
'Capture screen when open page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Date_Picker_ss001')
'Clicking on Select Date Input '
WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
'Choose Date and Verify Date-Picker'
CustomKeywords.'ui.UIResources.Select_Date_Picker'('07', '30', '1968')
'Capture screen when choose Date'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Date_Picker_ss002')
//WebUI.closeBrowser()
//WebDriver driver = DriverFactory.getWebDriver()

//String selectDate = '10/29/1999'
//int cMonth = Integer.parseInt(selectDate.split('/')[0]) - 1
//String cYear = selectDate.split('/')[2]
//String cDay = selectDate.split('/')[1]
//
//try {
//	WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
//	
//	
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Year'), cYear, false)
//	
//	WebElement day = driver.findElement(By.xpath('//div[@class="react-datepicker__month"]//child::div[text()="'+ cDay +'"]'))
//	day.click()
//	cdate = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
//	WebUI.verifyMatch(selectDate, cdate, false)
//}catch(Exception ex){
//	WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
//	
//	
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Year'), cYear, false)
//	
//	WebElement day = driver.findElement(By.xpath('(//div[@class="react-datepicker__month"]//child::div[text()="'+ cDay +'"])[2]'))
//	day.click()
//	cdate = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
//	WebUI.verifyMatch(selectDate, cdate, false)
//}




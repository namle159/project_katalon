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
import com.thoughtworks.selenium.webdriven.commands.GetText as GetText
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUICommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

'Open Page Web Tables'
WebUI.navigateToUrl('https://demoqa.com/webtables')

WebUI.maximizeWindow()

'Import employees'
CustomKeywords.'table.TableResources.Import_Employees'()

WebUI.scrollToElement(findTestObject('Page_Web_Table/button_Next'), 0)

'Verify Header in table'
CustomKeywords.'table.TableResources.Verify_Header'()

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Data_Tables_ss003.png')

'Verify data in web tables with data in file excel'
CustomKeywords.'table.TableResources.Verify_All_Data_Web_Tables'('Data Files/ListUser')

not_run: WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)


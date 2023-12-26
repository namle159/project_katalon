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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('')

'Open Page Web Table'
WebUI.navigateToUrl('https://demoqa.com/webtables')

WebUI.maximizeWindow()

'Verify Data default in table'
CustomKeywords.'table.TableResources.Verify_All_Data_Web_Tables'('Data Files/ListUserDefault')

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Button_Add_ss001.png')

WebUI.click(findTestObject('Object Repository/Page_Web_Table/button_Add'))

'Verify Pop Up display when click button Add '
WebUI.verifyElementText(findTestObject('Object Repository/Page_Web_Table/div_Registration Form'), 'Registration Form')

KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Page_Web_Table/div_Registration Form')))

'Input validate data in all fields'
CustomKeywords.'table.TableResources.Fill_Data_In_Fields'()

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Button_Add_ss002.png')

WebUI.click(findTestObject('Page_Web_Table/button_Submit'))

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Registration_Form_ss003.png')

'Verify data in table when add new employee'
CustomKeywords.'table.TableResources.Verify_Add_New_Data'()

WebUI.closeBrowser()


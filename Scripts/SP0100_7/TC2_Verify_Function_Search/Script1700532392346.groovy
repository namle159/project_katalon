import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.RenderingHints.Key as Key
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
import groovy.json.internal.Exceptions as Exceptions
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

'Open page Login'
CustomKeywords.'table.TableResources.Open_Browser'('https://opensource-demo.orangehrmlive.com')

'Capture screen when open page Login'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Function_Search_ss001')

'Login to page'
CustomKeywords.'table.TableResources.Login_Page_OrangeHRM'('Admin', 'admin123')

'Clicking on button Admin to open page Admin'
WebUI.click(findTestObject('Object Repository/Page_Admin/a_Admin'))

WebUI.delay(3)
WebDriver driver = DriverFactory.getWebDriver()
'Capture screen when open page Admin'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Function_Search_ss002')

'Verify function Search with label Username'
CustomKeywords.'table.TableResources.Search_By_Username'(['admin', 'admi', 'ADMIN'], 1)

'Verify result of search by User Role "Admin"'
CustomKeywords.'table.TableResources.Search_By_User_Role'()

'Clicking on button Reset'
WebUI.click(findTestObject('Object Repository/Page_Admin/Button_Reset'))

'Verify result of searching by Employee Name existed and not existed'
CustomKeywords.'table.TableResources.Search_By_Employee_Name'('Paul', 'Paul CollingsBrenna', 'Nam')


'Clicking on button Reset'
WebUI.click(findTestObject('Object Repository/Page_Admin/Button_Reset'))

'Verify result of searching by Status Enabled'
CustomKeywords.'table.TableResources.Search_By_Status'()

WebUI.closeBrowser()


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

'Open page Login'
CustomKeywords.'table.TableResources.Open_Browser'('https://opensource-demo.orangehrmlive.com')

'Capture screen open page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Page_Admin_ss001')

'Login to page'
CustomKeywords.'table.TableResources.Login_Page_OrangeHRM'('Admin', 'admin123')

'Clicking on button Admin'
WebUI.click(findTestObject('Object Repository/Page_Admin/a_Admin'))

'Verify title page Admin'
WebUI.verifyEqual((WebUI.getText(findTestObject('Object Repository/Page_Admin/h6_Admin')) + '/') + WebUI.getText(findTestObject(
            'Object Repository/Page_Admin/h6_User Management')), 'Admin/User Management')

'Highlight title page Admin'
CustomKeywords.'table.TableResources.highlightObject'(findTestObject('Object Repository/Page_Admin/h6_Admin'))

'Highlight title page Admin'
CustomKeywords.'table.TableResources.highlightObject'(findTestObject('Object Repository/Page_Admin/h6_User Management'))

'Capture screen when open page Admin and highlight title'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Page_Admin_ss002')

WebUI.closeBrowser(FailureHandling.OPTIONAL)


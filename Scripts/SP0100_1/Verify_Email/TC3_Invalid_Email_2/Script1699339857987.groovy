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

WebUI.openBrowser('')

'Open page Text Box'
WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

'Input invalid email missing domain \'gmail\''
WebUI.setText(findTestObject('Text_Box_Page/Page_DEMOQA/input_Email_userEmail'), Email)

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC3_Invalid_Email_2_ss005.png')

WebUI.click(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/button_Submit'))

WebUI.verifyElementNotPresent(findTestObject('Text_Box_Page/Page_DEMOQA/p_Emailnamgmail.com'), 2)

'Verify Email not present at the end of the page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC3_Invalid_Email_2_ss006.png')

WebUI.closeBrowser()


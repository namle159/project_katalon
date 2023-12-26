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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

'Open page Alert'
WebUI.navigateToUrl('https://demoqa.com/alerts')

WebUI.maximizeWindow()

//'Capture screen when open page'
//CustomKeywords.'ui.UIResources.PopUp_Screenshot'('TC4_Verify_Promt_Alert_ss001')
'Clicking on button \'Click me\''
WebUI.click(findTestObject('Object Repository/Page_Alert/button_PromtButton'))
WebUI.delay(1)
WebUI.waitForAlert(5)
//WebUI.waitForAlert(3)

'Input Name in Alert'
WebUI.setAlertText(Name)

'Capture screen when input name in Alert'
CustomKeywords.'ui.UIResources.PopUp_Screenshot'('TC4_Verify_Promt_Alert_ss001')

WebUI.delay(2)

'Clicking on button \'Click me\''
WebUI.click(findTestObject('Page_Alert/button_PromtButton'))

'Input Name in Alert'
WebUI.setAlertText(Name)

WebUI.delay(1)

WebUI.acceptAlert()

'Verify msg when click OK in Alert'
WebUI.verifyElementText(findTestObject('Page_Alert/span_you entered'), 'You entered ' + Name)

'Capture screen when clicking to OK in Alert'
CustomKeywords.'ui.UIResources.PopUp_Screenshot'('TC4_Verify_Promt_Alert_ss002')

KeywordUtil.logInfo('The message is: ' + WebUI.getText(findTestObject('Page_Alert/span_you entered')))

WebUI.closeBrowser()


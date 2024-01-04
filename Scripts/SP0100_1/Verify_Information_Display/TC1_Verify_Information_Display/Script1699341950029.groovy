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

'Open page Text Box'
WebUI.navigateToUrl('https://demoqa.com/text-box')

WebUI.maximizeWindow()

'Input valid Full Name'
WebUI.setText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/input_Full Name_userName'), 'Nam Le')

'Input valid Email'
WebUI.setText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/input_Email_userEmail'), 'abc@gmail.com')

'Input valid Current Address'
WebUI.setText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/textarea_Current Address_currentAddress'), '123 street abc')

'Input valid Permanent Address'
WebUI.setText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/textarea_Permanent Address_permanentAddress'), 
    '123 street abc')

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Information_Display_ss018.png')

WebUI.click(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/button_Submit'))

WebUI.delay(3)

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Information_Display_ss019.png')

'Verify Full Name present at the end of the page'
WebUI.verifyElementText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_NameNam Le'), 'Name:Nam Le')

KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_NameNam Le')))

KeywordUtil.logInfo('Name:Nam Le')

'Verify Email present at the end of the page'
WebUI.verifyElementText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Emailabcgmail.com'), 'Email:abc@gmail.com')

KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Emailabcgmail.com')))

KeywordUtil.logInfo('Email:abc@gmail.com')

'Verify Current Address present at the end of the page'
WebUI.verifyElementText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Current Address abcgmail.com'), 'Current Address :123 street abc')

KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Current Address abcgmail.com')))

KeywordUtil.logInfo('Current Address :123 street abc')

'Verify Permananet Address present at the end of the page'
WebUI.verifyElementText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Permananet Address abcgmail.com'), 
    'Permananet Address :123 street abc')

KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Permananet Address abcgmail.com')))

KeywordUtil.logInfo('Permananet Address :123 street abc')

WebUI.closeBrowser()


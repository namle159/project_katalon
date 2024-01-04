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

WebUI.openBrowser(GlobalVariable.URL)

'Open page Text Box'
//WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

//CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Valid_Email_ss009.png')
//
//'Input valid email'
//WebUI.setText(findTestObject('Text_Box_Page/Page_DEMOQA/input_Email_userEmail'), Email)
//
//CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Valid_Email_ss001.png')
//
//WebUI.click(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/button_Submit'))
//
//CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Valid_Email_ss002.png')
//
//WebUI.delay(2)
//
//'Verify data email present at the end of the page'
//WebUI.verifyElementText(findTestObject('Text_Box_Page/Page_DEMOQA/p_Emailnamgmail.com'), 'Email:' + Email)
//
//
//KeywordUtil.logInfo(WebUI.getText(findTestObject('Object Repository/Text_Box_Page/Page_DEMOQA/p_Emailabcgmail.com')))
//
//KeywordUtil.logInfo('Email:' + Email)


//println(WebUI.getUrl())

//WebUI.closeBrowser()


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

'Open page Upload-Download'
WebUI.openBrowser('https://demoqa.com/upload-download')

WebUI.maximizeWindow()

'Capture screen when open page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Upload_ss001.png')

'Passing the path of the file'
WebUI.uploadFile(findTestObject('Page_Dowload/Input_Upload'), 'C:\\Users\\lnnam\\Desktop\\3.jpeg')

'Wait for file uploaded'
WebUI.delay(3)

'Capturing the file name after upload and stroring it in variable \'value\''
value = WebUI.getText(findTestObject('Page_Dowload/p_UploadFilePath'))

'Verify the Actual path and Expect path of file'
WebUI.verifyMatch(value, 'C:\\fakepath\\3.jpeg', false)

'Capture screen when file was uploaded'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Upload_ss002.png')

WebUI.closeBrowser()


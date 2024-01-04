import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.TearDown as TearDown
import com.kms.katalon.core.annotation.TearDownTestCase as TearDownTestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.context.TestCaseContext as TestCaseContext
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
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Download_ss001.png')

'Clicking on the button \'Download\' to dowload the file'
WebUI.click(findTestObject('Object Repository/Page_Dowload/a_Download'))

'Wait for file is downloaded'
WebUI.delay(5)

'Verifying the file is download in the User defined Path '
CustomKeywords.'table.TableResources.isFileDownloaded'('C:\\Users\\lnnam\\Downloads', 'sampleFile.jpeg')

WebUI.closeBrowser()

@TearDown(skipped = true)
def TearDown() {
    CustomKeywords.'table.TableResources.DeletedDownloaded'('C:\\Users\\lnnam\\Downloads', 'sampleFile.jpeg')
}


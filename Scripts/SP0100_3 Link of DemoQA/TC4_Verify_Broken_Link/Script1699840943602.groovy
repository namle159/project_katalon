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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

WebUI.maximizeWindow()

'Open page Broken'
WebUI.navigateToUrl('https://demoqa.com/broken')

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC4_Verify_Broken_Link_ss001.png')

WebDriver driver = DriverFactory.getWebDriver()

WebElement link = driver.findElement(By.xpath('//a[@href="http://the-internet.herokuapp.com/status_codes/500"]'))

String targetAttributeValue = link.getAttribute('href')

'Verify link'
WebUI.verifyMatch(targetAttributeValue, 'http://the-internet.herokuapp.com/status_codes/500', false)

KeywordUtil.logInfo('The broken link is: ' + targetAttributeValue)

WebUI.click(findTestObject('Object Repository/Page_Link/a_Click Here for Broken Link'))

'Verify new page open when click to link'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Link/h1_FortiGuard Intrusion Prevention - Access Blocked'), 
    2)

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC4_Verify_Broken_Link_ss002.png')

WebUI.closeBrowser()


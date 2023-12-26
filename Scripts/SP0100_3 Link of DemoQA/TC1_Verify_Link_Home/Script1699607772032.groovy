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

'Open page links'
WebUI.navigateToUrl('https://demoqa.com/links')

WebUI.maximizeWindow()

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Link_Home_ss001.png')

WebElement link = driver.findElement(By.xpath('//a[@id="simpleLink"]'))

String targetAttributeValue = link.getAttribute('href')

'Verify link'
WebUI.verifyMatch(targetAttributeValue, 'https://demoqa.com/', false)

//WebElement link = driver.findElement(By.xpath('//a[@id="simpleLink"]'))
//String targetAttributeValue = link.getAttribute("target")
//if (targetAttributeValue != null && targetAttributeValue.equalsIgnoreCase("_blank")) {
//	// The attribute "target" is set to "blank"
//	KeywordUtil.logInfo("The element has the attribute 'target' set to 'blank'")
//} else {
//	// The attribute "target" is not set to "blank"
//	KeywordUtil.logInfo("The element does not have the attribute 'target' set to 'blank'")
//}
'Click Home button'
WebUI.click(findTestObject('Object Repository/Page_Link/a_Home'))

'Change to tab 2'
WebUI.switchToWindowIndex(1)

//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Link/text'), 2)
// Verify the presence of an element
'Verify new tab will open when click to link'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Link/text'), 2)) {
    KeywordUtil.logInfo('The element is present: ' + WebUI.getAttribute(findTestObject('Object Repository/Page_Link/text'), 
            'href'))

    // Retrieve the number of open tabs
    def windowHandles = driver.windowHandles.size()

    KeywordUtil.logInfo('Number of tabs = ' + windowHandles)
} else {
    KeywordUtil.logInfo('The element is not present.')
}

CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Link_Home_ss002.png')

WebUI.closeBrowser()


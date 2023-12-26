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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.awt.Rectangle as Rectangle
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.image.BufferedImage as BufferedImage
import javax.imageio.ImageIO as ImageIO
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'Open page Alert'
WebUI.openBrowser('https://demoqa.com/alerts')

WebUI.maximizeWindow()

//'Capture when open page'
//CustomKeywords.'ui.UIResources.PopUp_Screenshot'('TC1_Verify_Alert_Display_ss001')

WebUI.click(findTestObject('Page_Alert/button_AlertButton'))

WebUI.delay(1)
WebUI.waitForAlert(5)

'Capture the alert'
CustomKeywords.'ui.UIResources.PopUp_Screenshot'('TC1_Verify_Alert_Display_ss001')

WebUI.delay(1)

'Clicking on button "Click me"'
WebUI.click(findTestObject('Page_Alert/button_AlertButton'))

'Clicking on OK in the Alert'
WebUI.acceptAlert()

WebUI.delay(1)

'Capture when Alert closed'
CustomKeywords.'ui.UIResources.PopUp_Screenshot'('TC1_Verify_Alert_Display_ss002')

WebUI.closeBrowser()


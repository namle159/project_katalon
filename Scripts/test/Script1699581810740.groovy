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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By

import org.openqa.selenium.WebElement as WebElement
WebUI.openBrowser('')

'Open Page Web Tables'
//WebUI.navigateToUrl('https://demoqa.com/webtables')
//
//WebUI.maximizeWindow()
WebDriver driver = DriverFactory.getWebDriver()
//
//WebElement pageElement = driver.findElement(By.xpath('//select[@aria-label="rows per page"]//child::option[text()="10 rows"]'))
//String optionText = pageElement.getText()
//
//def numericPart = optionText.replaceAll("\\D", "")
//int pageNumber = Integer.parseInt(numericPart)
//
//println("Page Number: " + pageNumber)





WebUI.navigateToUrl('https://demoqa.com/links')
WebUI.click(findTestObject('Object Repository/Page_Link/a_Home'))

//WebUI.switchToWindowTitle('DEMOQA')
//String text = WebUI.getText(findTestObject('Object Repository/Page_Link/text'))
//println(text)
WebElement link = driver.findElement(By.xpath('//a[@id="simpleLink"]'))
String targetAttributeValue = link.getAttribute("href")
println(targetAttributeValue)
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

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.util.KeywordUtil

'Open page Sort WebTable'
CustomKeywords.'table.TableResources.Open_Browser'('https://www.w3schools.com/howto/howto_js_sort_table.asp')

'Capture screen when Open page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Sort_ss001')

'Capture list of name in UI'
List<String> ListUI = CustomKeywords.'table.TableResources.Verify_Sort'()

'Sort ascending'
ListUI = ListUI.toSorted()
KeywordUtil.logInfo('The list name when sorted ascending is: '+ ListUI)

'Click the sort button to sort the table alphabetically'
WebUI.click(findTestObject('Object Repository/Page_Sort/Button_Sort'))

'Capture screen when sorted'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC1_Verify_Sort_ss002')

//'Capture list after click the sort button'
//List<String> SortedList = CustomKeywords.'table.TableResources.Verify_Sort'()
//
//'Verify data when sorted'
//WebUI.verifyEqual(SortedList, ListUI)


'Verify data in list sorted ascending with data  in UI when sorted'
for (int i = 0; i < ListUI.size(); i++) {
	WebUI.verifyEqual(ListUI[i], WebUI.getText(findTestObject('Object Repository/Page_Sort/List_Name', ['index': i+2])))
}

//WebDriver driver = DriverFactory.getWebDriver()
//List<WebElement> countries = driver.findElements(By.xpath('//tbody/tr/td[2]//child::strong'))
//
//List<String> listCountry = []
//
//for (int i = 2; i <= countries.size(); i++) {
//    WebElement countryElement = driver.findElement(By.xpath('(//tbody/tr/td[2]//child::strong)[' + i + ']'))
//	WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(countryElement))
//    String countryName = countryElement.getText()
//	
//    listCountry.add(countryName)
//}
//
//listCountryverify = listCountry.toSorted()
//
//for (int i = 0; i <= listCountry.size(); i++) {
//	WebUI.verifyEqual(listCountry[i], listCountryverify[i])
//}





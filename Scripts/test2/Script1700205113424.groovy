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

//WebUI.openBrowser('https://demoqa.com/date-picker')
//WebUI.maximizeWindow()
//WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
//CustomKeywords.'ui.UIResources.Select_Date_Picker'('04/06/2000')
//WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')
//WebUI.maximizeWindow()
//WebUI.getAllLinksOnCurrentPage(true, null)

WebUI.openBrowser('https://demoqa.com/links')
WebUI.maximizeWindow()
String valuecss = WebUI.getCSSValue(findTestObject('Object Repository/Page_Link/bold_text'), 'font-weight')
WebUI.verifyEqual(valuecss , '700')	

//WebUI.verifyAlertPresent(10)
//WebUI.acceptAlert()
//
List list_cell_value = []
List<WebElement> list_elements = driver.findElements(By.xpath('//table/tbody/tr/td[text()]'))
for (WebElement cellvalue : list_elements) {
	list.add(cellvalue.getText())
}
println(list_cell_value)
			




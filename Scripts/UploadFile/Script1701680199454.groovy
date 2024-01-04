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
import org.checkerframework.checker.units.qual.Length
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.common.WebUiCommonHelper

//WebUI.openBrowser('')
//
//WebUI.navigateToUrl('https://the-internet.herokuapp.com/upload')
//
//WebUI.maximizeWindow()
//
//CustomKeywords.'table.TableResources.uploadFile'(findTestObject('Object Repository/UploadFile/button Upload'), 'C:\\Users\\lnnam\\Downloads\\Interview_1.pdf')

//WebUI.sendKeys(findTestObject('Object Repository/UploadFile/button Upload'), 'C:\\Users\\lnnam\\Downloads\\Interview_1.pdf')
//
//WebUI.click(findTestObject('Object Repository/UploadFile/input_File Uploader_file-submit'))
//
//WebUI.verifyElementText(findTestObject('Object Repository/UploadFile/div_Interview_1.pdf'), 'Interview_1.pdf')

//WebUI.closeBrowser()

//WebUI.openBrowser('https://demoqa.com/links')
//WebUI.maximizeWindow()
//WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Link/a_Home'), 'target', '_blank', 0)

//WebUI.openBrowser('https://the-internet.herokuapp.com/upload')
//color = WebUI.getCSSValue(findTestObject('Object Repository/UploadFile/input_File Uploader_file-submit'), 'background-color')
//println(color)

//WebUI.openBrowser('https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled')
//WebDriver driver = DriverFactory.getWebDriver()
//WebUI.switchToFrame(findTestObject('Object Repository/Page_Admin/iframe'), 30)
//WebElement name = driver.findElement(By.xpath('//input[@id="lname"]'))
//WebUI.executeJavaScript("arguments[0].removeAttribute('disabled')",  Arrays.asList(name))
//WebUI.removeObjectProperty(findTestObject('Object Repository/Page_Admin/radio_button_disable'), 'disabled')

//WebUI.openBrowser('https://demoqa.com/links')
////WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Link/a_Home'), 'target', '_blank', 0)
//WebUI.click(findTestObject('Object Repository/Page_Link/a_Home'))
////WebUI.switchToWindowIndex(1)
//WebDriver driver = DriverFactory.getWebDriver()
//int tabs = driver.windowHandles.size()
//println('total tab is: '+ tabs)
//if(tabs == 2) {
//	println('total tab is: '+ tabs)
//}else {
//	println('fail')
//}

//WebUI.openBrowser('https://www.w3schools.com/howto/howto_js_sort_table.asp')
//WebUI.maximizeWindow()
//List<WebElement> rowUI = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_Sort/intListCountry'), 30)
//println(rowUI.size())
//List<String> listCountryUI = []
//for (int i = 2; i<=rowUI.size()+1; i++) {
//	String name_Country = WebUI.getText(findTestObject('Object Repository/Page_Sort/ListCountry', [('index'): i]))
//	listCountryUI.add(name_Country)
//}
//println(listCountryUI)
//List<String> listCountryExcel = []
//for (int i = 1; i< findTestData('Data Files/listCountry').getRowNumbers(); i++) {
//	String name_Country = findTestData('Data Files/listCountry').getValue(1, i)
//	listCountryExcel.add(name_Country)	
//}
//println(listCountryExcel)
//
//boolean containsAllElements = listCountryUI.containsAll(listCountryExcel)
//println("Does listCountryUI contain all elements from listCountryExcel?\n" + containsAllElements)


//WebUI.openBrowser('google.com')

//List<Integer> number = [5,6,98,25,63,45,15,86,36,95]
List<Integer> number = []
for (int i = 1; i < findTestData('Data Files/listCountry').getRowNumbers(); i++) {
int numberExcel = Integer.parseInt(findTestData('Data Files/listCountry').getValue(2, i))
number.add(numberExcel)
}
//int min_numb = number[0]
//int max_numb = number[0]
//
//for (int i : number) {
//	if(min_numb > i) {
//		min_numb = i
//	}
//	if(max_numb < i) {
//		max_numb = i
//	}
//}
//
//println(min_numb)
//println(max_numb)

Collections.sort(number)
println(number)
println('min numb: '+number[0])
println('max numb: '+number[number.size()-1])
//WebUI.verifyMatch("SRN-123456", "^SRN-/d{6}", true)










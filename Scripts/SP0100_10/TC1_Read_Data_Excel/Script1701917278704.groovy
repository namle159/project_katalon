import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.RenderingHints.Key as Key
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
import org.apache.poi.xssf.usermodel.*
import org.apache.commons.io.FileUtils as FileUtils

CustomKeywords.'excel.ReadFileExcel.getDataExcel'()

File file = new File('C:\\Users\\lnnam\\Desktop\\Data.xlsx')

FileInputStream fis = new FileInputStream(file)

XSSFWorkbook workbook = new XSSFWorkbook(fis)

XSSFSheet sheet = workbook.getSheetAt(0)

int rownumb = sheet.getLastRowNum()

//int cellnumb = sheet.getRow(0).getLastCellNum()
List<String> listCountryExcel = []

for (i = 1; i < rownumb; i++) {
    //	for (j = 0;j<cellnumb;j++) {
    String valueCell = sheet.getRow(i).getCell(0).getStringCellValue()

    listCountryExcel.add(valueCell)
}

//}
println(listCountryExcel)

//List<String> ListCountryUI = []
//
//WebUI.openBrowser('https://demo.mobiscroll.com/select/country-picker')
//
//WebUI.maximizeWindow()
//
//WebDriver driver = DriverFactory.getWebDriver()
//
//driver.findElement(By.id('demo155-country-picker')).click()
//
//List<WebElement> country = driver.findElements(By.xpath('//div[@class="md-country-picker-item"]'))
//
//
//for (WebElement cellValue : country) {
////    WebUI.executeJavaScript('arguments[0].scrollIntoView(false);', Arrays.asList(cellValue))
//
//ListCountryUI.add(cellValue.getText())
//}
//
//println(ListCountryUI)
//
//println(ListCountryUI.containsAll(listCountryExcel))
//
//WebUI.getAllLinksOnCurrentPage(false, [])
File files = new File('C:\\Users\\lnnam\\Desktop\\country.txt')

//FileInputStream fis = new FileInputStream(file)
//byte[] bytes = new byte[fis.available()]
//fis.read(bytes)
//for(byte i: bytes) {
//print((char) i)
//}
String data = FileUtils.readFileToString(files)

println(data)

List<String> list = data.split('\n')

println(list)


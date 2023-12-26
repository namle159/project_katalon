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
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.text.SimpleDateFormat
import java.util.Date

'Open page Date-Picker'
WebUI.openBrowser('https://demoqa.com/date-picker')
'MaximizeWindow'
WebUI.maximizeWindow()
'Capture screen when open page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Date_Picker_And_Time_ss001')
'Clicking on Select Date and Time Input'
WebUI.click(findTestObject('Object Repository/Page_Date Picker/SelectDateandTime'))
'Choose Date&Time and Verify Date&Time-Picker'
CustomKeywords.'ui.UIResources.Select_Date_Time_Picker'('March', '27', '1923', '19:15')
'Capture screen when User choose date and time'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC2_Verify_Date_Picker_And_Time_ss002')
WebUI.closeBrowser()
//String selectTime = '14:45'
//String selectMonth = 'February'
//String selectYear = '2001'
//String selectDay = '28'
//String selectDate = selectMonth +' '+ selectDay + ', ' + selectYear + ' '+ selectTime
//def inputFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm")
//def outputFormat = new SimpleDateFormat("MMMM dd, yyyy h:mm a")
//
//Date dateTime = inputFormat.parse(selectDate)
//String formattedDateTime = outputFormat.format(dateTime)
//
//println(formattedDateTime)
//
//WebDriver driver = DriverFactory.getWebDriver()
//
//WebUI.click(findTestObject('Object Repository/Page_Date Picker/SelectDateandTime'))
//WebElement cTime = driver.findElement(By.xpath('//li[@class="react-datepicker__time-list-item " and text()="'+ selectTime +'"]'))
//cTime.click()
//WebUI.click(findTestObject('Object Repository/Page_Date Picker/SelectDateandTime'))
//driver.findElement(By.xpath('//span[@class="react-datepicker__month-read-view--down-arrow"]')).click()
//WebElement cMonth = driver.findElement(By.xpath('//div[@class="react-datepicker__month-option" and text()="'+ selectMonth +'"]'))
//cMonth.click()
//driver.findElement(By.xpath('//span[@class="react-datepicker__year-read-view--down-arrow"]')).click()
//
//boolean foundElement = false
//while (!foundElement) {
//    try {
//        WebElement cYear = driver.findElement(By.xpath('//div[@class="react-datepicker__year-option" and text()="'+ selectYear +'"]'))
//
//        foundElement = true // Nếu tìm thấy element, thoát khỏi vòng lặp
//		cYear.click()
//    } catch (Exception ex) {
//        // Nếu không tìm thấy element, thực hiện bước chuyển đến năm trước
//		for (int i = 0; i <=10; i++) {
//        driver.findElement(By.xpath('//a[contains(@class, "years-previous")]')).click()
//		}
//    }
//}
//
//
//boolean dateMatched = false
//
//for (int i = 1; i < 3 && !dateMatched; i++) {
//    try {
//		
//        WebElement cDay = driver.findElement(By.xpath('(//div[@class="react-datepicker__month"]//child::div[text()="'+ selectDay +'"])['+ i +']'))
//        cDay.click()
//
//        // Lấy giá trị mới của ô input
//        WebElement dateString = driver.findElement(By.xpath('//input[@id="dateAndTimePickerInput"]'))	
//		String formattedcDateTime = dateString.getAttribute("value")
//		println(formattedcDateTime)
//        // Kiểm tra xem formattedcDateTime có bằng formattedDateTime không
//        WebUI.verifyMatch(formattedcDateTime, formattedDateTime, false)
//    } catch (Exception ex) {
//        // Nếu không giống, chọn lại tháng
//		driver.findElement(By.xpath('//span[@class="react-datepicker__month-read-view--down-arrow"]')).click()
//		WebElement cMonth1 = driver.findElement(By.xpath('//div[@class="react-datepicker__month-option" and text()="'+ selectMonth +'"]'))
//		cMonth1.click()
//    }
//}







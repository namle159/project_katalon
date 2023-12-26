package ui

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.jna.platform.FileUtils

import aj.org.objectweb.asm.Handle
import internal.GlobalVariable
import groovy.json.StringEscapeUtils
import java.util.Random
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

import java.awt.Rectangle as Rectangle
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.image.BufferedImage as BufferedImage
import javax.imageio.ImageIO as ImageIO
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.util.FileUtil
import java.nio.file.Paths
import java.nio.file.Path
import com.kms.katalon.core.constants.StringConstants
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.text.SimpleDateFormat
import java.util.Date

class UIResources {


	@Keyword
	def TakeScreenshot(String screenshot_name) {

		KeywordUtil.logInfo(screenshot_name)

		WebUI.takeScreenshot(((RunConfiguration.getProjectDir() + '\\Screenshots\\SP0100_1\\' + screenshot_name)) +'.png')
	}


	@Keyword
	def PopUp_Screenshot(String screenshot_name) {
		String reportFolder = RunConfiguration.getReportFolder()+"\\Screenshots"
		File theDir = new File(reportFolder);
		if (!theDir.exists()){
			theDir.mkdirs();
		}
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(reportFolder+ '\\' + screenshot_name + '.png'));
		Map<String, String> att = new HashMap<>()
		att.put(StringConstants.XML_LOG_ATTACHMENT_PROPERTY, reportFolder + '\\' + screenshot_name + '.png')
		KeywordUtil.logInfo(reportFolder + '\\' + screenshot_name + '.png')
	}
	@Keyword
	def Select_Date_Picker(String MM, String DD, String YYYY) {
		WebDriver driver = DriverFactory.getWebDriver()
		String selectDate = MM + '/' + DD + '/' + YYYY
		KeywordUtil.logInfo('Select Date is: ' + selectDate)

		int cMonth = Integer.parseInt(MM) - 1
		String cYear = YYYY
		String cDay = DD.replaceAll("^0+", "")

		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Year'), cYear, false)
		driver.findElement(By.xpath('//div[@class="react-datepicker__month"]//child::div[text()="' + cDay + '"]')).click()

		String currentDate = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
		boolean result = WebUI.verifyEqual(selectDate, currentDate, FailureHandling.OPTIONAL)
		if (!result) {
			WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
			driver.findElement(By.xpath('(//div[@class="react-datepicker__month"]//child::div[text()="' + cDay + '"])[2]')).click()
			String currentDate1 = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
			WebUI.verifyEqual(selectDate, currentDate1)
		}
	}






	//	    boolean dateSelected = false
	//	    WebElement day = null
	//
	//	    // Check if the day is present in the first attempt
	//	    day = driver.findElement(By.xpath('//div[@class="react-datepicker__month"]//child::div[text()="' + cDay + '"]'))
	//	    if (day.isDisplayed()) {
	//	        day.click()
	//	        dateSelected = true
	//	    } else {
	//	        // If not found, try the second attempt
	//	        WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
	//	        WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
	//	        day = driver.findElement(By.xpath('(//div[@class="react-datepicker__month"]//child::div[text()="' + cDay + '"])[2]'))
	//	        day.click()
	//	        dateSelected = true
	//	    }
	//
	//	    if (dateSelected) {
	//	        String currentDate = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
	//	        WebUI.verifyMatch(selectDate, currentDate, false)
	//	        KeywordUtil.logInfo('Select date in UI: ' + currentDate)
	//	    } else {
	//	        KeywordUtil.logInfo('Date not selected')
	//	    }
	//	}


	@Keyword
	def Select_Date_Time_Picker( String MMMM, String dd, String yyyy, String HHmm) {
		//		String selectTime = '14:45'
		//		String selectMonth = 'February'
		//		String selectYear = '2001'
		//		String selectDay = '28'
		String selectDate = MMMM +' '+ dd + ', ' + yyyy + ' '+ HHmm
		def inputFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm")
		def outputFormat = new SimpleDateFormat("MMMM dd, yyyy h:mm a")

		Date dateTime = inputFormat.parse(selectDate)
		String formattedDateTime = outputFormat.format(dateTime)

		KeywordUtil.logInfo('Date and Time User choose: '+formattedDateTime)

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement cTime = driver.findElement(By.xpath('//li[@class="react-datepicker__time-list-item " and text()="'+ HHmm +'"]'))
		cTime.click()
		WebUI.click(findTestObject('Object Repository/Page_Date Picker/SelectDateandTime'))
		driver.findElement(By.xpath('//span[@class="react-datepicker__month-read-view--down-arrow"]')).click()
		WebElement cMonth = driver.findElement(By.xpath('//div[@class="react-datepicker__month-option" and text()="'+ MMMM +'"]'))
		cMonth.click()
		driver.findElement(By.xpath('//span[@class="react-datepicker__year-read-view--down-arrow"]')).click()

		boolean foundElement = false
		while (!foundElement) {
			try {
				WebElement cYear = driver.findElement(By.xpath('//div[@class="react-datepicker__year-option" and text()="'+ yyyy +'"]'))

				foundElement = true // Nếu tìm thấy element, thoát khỏi vòng lặp
				cYear.click()
			} catch (Exception ex) {
				// Nếu không tìm thấy element, thực hiện bước chuyển đến năm trước
				for (int i = 0; i <=10; i++) {
					driver.findElement(By.xpath('//a[contains(@class, "years-previous")]')).click()
				}
			}
		}

		boolean dateMatched = false

		for (int i = 1; i < 3 && !dateMatched; i++) {
			try {

				WebElement cDay = driver.findElement(By.xpath('(//div[@class="react-datepicker__month"]//child::div[text()="'+ dd +'"])['+ i +']'))
				cDay.click()
				// Lấy giá trị mới của ô input
				WebElement dateString = driver.findElement(By.xpath('//input[@id="dateAndTimePickerInput"]'))
				String formattedcDateTime = dateString.getAttribute("value")
				// Kiểm tra xem formattedcDateTime có bằng formattedDateTime không
				WebUI.verifyMatch(formattedcDateTime, formattedDateTime, false)
				KeywordUtil.logInfo('Date and Time in UI: '+ formattedcDateTime)
			} catch (Exception ex) {
				// Nếu không giống, chọn lại tháng
				driver.findElement(By.xpath('//span[@class="react-datepicker__month-read-view--down-arrow"]')).click()
				WebElement cMonth1 = driver.findElement(By.xpath('//div[@class="react-datepicker__month-option" and text()="'+ MMMM +'"]'))
				cMonth1.click()
			}
		}
	}
	//	@Keyword
	//	def Select_Date_Picker(String selectDate) {
	//		WebDriver driver = DriverFactory.getWebDriver()
	//
	//		int cMonth = Integer.parseInt(selectDate.split('/')[0]) - 1
	//		String cYear = selectDate.split('/')[2]
	//		String cDay = selectDate.split('/')[1].replaceAll("^0+", "")
	//
	//		if (dateSelectionSucceeded(cMonth, cYear, cDay)) {
	//			String currentDate = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
	//			WebUI.verifyMatch(selectDate, currentDate, false)
	//		} else {
	//			WebUI.click(findTestObject('Page_Date Picker/SelectDate'))
	//			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
	//			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Year'), cYear, false)
	//
	//			WebElement day = driver.findElement(By.xpath('(//div[@class="react-datepicker__month"]//child::div[text()="' + cDay + '"])[2]'))
	//			day.click()
	//
	//			String currentDate = WebUI.getAttribute(findTestObject('Object Repository/Page_Date Picker/SelectDate'), 'value')
	//			WebUI.verifyMatch(selectDate, currentDate, false)
	//		}
	//	}
	//
	//	def dateSelectionSucceeded(int cMonth, String cYear, String cDay) {
	//		try {
	//			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Month'), String.valueOf(cMonth), false)
	//			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Date Picker/Year'), cYear, false)
	//
	//			WebDriver driver = DriverFactory.getWebDriver()
	//			WebElement day = driver.findElement(By.xpath('//div[@class="react-datepicker__month"]//child::div[text()="' + cDay + '"]'))
	//			day.click()
	//
	//			return true
	//		} catch (Exception ex) {
	//			return false
	//		}
	//	}

}





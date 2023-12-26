import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.TearDown as TearDown
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
import org.apache.logging.log4j.core.util.Assert as Assert
import org.openqa.selenium.By as By
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.ExpectedConditions as EC
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import java.time.Duration as Duration

'Open page HRM'
CustomKeywords.'table.TableResources.Open_Browser'('https://opensource-demo.orangehrmlive.com')

'Capture screen when open page'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC3_Verify_Add_User_ss001')

'Login to page'
CustomKeywords.'table.TableResources.Login_Page_OrangeHRM'('Admin', 'admin123')

'Clicking on button Admin'
WebUI.click(findTestObject('Object Repository/Page_Admin/a_Admin'))

WebUI.delay(2)

'Capture screen when open page Admin'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC3_Verify_Add_User_ss002')

'Clicking on button Add'
WebUI.click(findTestObject('Object Repository/Page_Admin/Button_Add'))

'Field data in Add form'
CustomKeywords.'table.TableResources.field_Data_Page_Add'(Username, EmployeeNameHint)

'Capture screen when clicking on button Save'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC3_Verify_Add_User_ss003')

'Input Username just added in label username search'
CustomKeywords.'table.TableResources.Searching_Username'(Username)

'Verify Information new user'
CustomKeywords.'table.TableResources.Verify_Info_Add_User'(Username, EmployeeName)

'Capture screen when searching of user created'
CustomKeywords.'ui.UIResources.TakeScreenshot'('TC3_Verify_Add_User_ss004')

@TearDown(skipped = true)
def TearDown() {
    WebDriver driver = DriverFactory.getWebDriver()

    driver.findElement(By.xpath('//button[@class="oxd-icon-button oxd-table-cell-action-space"][1]')).click()

    driver.findElement(By.xpath('//div[@role="document"]//button[2]')).click()
}


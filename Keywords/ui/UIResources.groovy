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

import internal.GlobalVariable
import groovy.json.StringEscapeUtils
import java.util.Random
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
public class UIResources {


	@Keyword
	def TakeScreenshot(String screenshot_name) {

		//		def randomNumber = new Random().nextInt(1001)
		//
		//		def modifiedScreenshotName = screenshot_name + "_" + randomNumber
		//
		//		KeywordUtil.logInfo(modifiedScreenshotName)
		KeywordUtil.logInfo(screenshot_name)

		WebUI.takeScreenshot(((RunConfiguration.getProjectDir() + '\\Screenshots\\SP0100_1\\' + '\\' + screenshot_name)) +'.png')
	}
}


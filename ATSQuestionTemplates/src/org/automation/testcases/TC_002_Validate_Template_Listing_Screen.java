package org.automation.testcases;

import java.io.IOException;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_002_Validate_Template_Listing_Screen extends BaseClass
{
	
	@Test(priority=1)
	
	public void validateFieldsDisplayed() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_003_Validate_Templats_Listing_Screen", "TC_003_Validate_Templats_Listing_Screen");
		ElementIsDisplayed("xpath",Utility.fetchLocatorValue("settings_xpath"));
		elementClick("xpath",Utility.fetchLocatorValue("settings_xpath"));
		Thread.sleep(4000);
		int x=we.findElements(By.tagName("iframe")).size();
        System.out.println(x);
        we.switchTo().frame(1);
        elementClick("xpath",Utility.fetchLocatorValue("question_template_link"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("search_template_field"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("Hide_Inactive_checkbox"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("Filter_button"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("Reset_button"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("Return_To_Settings_button"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("templates_per_page"));	
	}
	
	@Test(priority=2)	
	public void verifyValidationOnNoRecords() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_003_Validate_Templats_Listing_Screen", "TC_003_Validate_Templats_Listing_Screen");
		ElementIsDisplayed("xpath",Utility.fetchLocatorValue("settings_xpath"));
		elementClick("xpath",Utility.fetchLocatorValue("settings_xpath"));
		Thread.sleep(4000);
		int x=we.findElements(By.tagName("iframe")).size();
        System.out.println(x);
        we.switchTo().frame(1);
        elementClick("xpath",Utility.fetchLocatorValue("question_template_link"));
        elementSendText("xpath",Utility.fetchLocatorValue("search_template_field"),"hgdhsghsh");
		elementClick("xpath",Utility.fetchLocatorValue("Filter_button"));
		ElementIsDisplayed("xpath",Utility.fetchLocatorValue("0_template_found"));		
	}
}

package org.automation.testcases;

import java.io.IOException;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.TakeScreenshot;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_004_Validate_Columns_in_Listing_Screen extends BaseClass
{
	@Test
	
	public void validateColumns() throws IOException, InterruptedException 
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_005_Validate_Columns_in_Listing_Screen", "TC_005_Validate_Columns_in_Listing_Screen");
		elementClick("xpath",Utility.fetchLocatorValue("settings_xpath"));
		Thread.sleep(4000);
		int x=we.findElements(By.tagName("iframe")).size();
        System.out.println(x);
        we.switchTo().frame(1);
        elementClick("xpath",Utility.fetchLocatorValue("question_template_link"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("th_Name"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("th_Created"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("th_Active"));
		TakeScreenshot.takesScreenshot(we, "Columns displayed on listing page");
		
	}

}

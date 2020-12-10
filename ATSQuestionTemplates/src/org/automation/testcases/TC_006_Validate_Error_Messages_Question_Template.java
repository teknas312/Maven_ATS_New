package org.automation.testcases;

import java.io.IOException;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_006_Validate_Error_Messages_Question_Template extends BaseClass
{
	@Test
	
	public void errorMessage() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_007_Validate_Error_Messages_Question_Template", "TC_007_Validate_Error_Messages_Question_Template");
		elementClick("xpath",Utility.fetchLocatorValue("settings_xpath"));
		Thread.sleep(4000);
		int x=we.findElements(By.tagName("iframe")).size();
        System.out.println(x);
        we.switchTo().frame(1);
        elementClick("xpath",Utility.fetchLocatorValue("question_template_link"));
		test.info("Clicking on Add new question template link");
		Thread.sleep(4000);
		elementClick("xpath",Utility.fetchLocatorValue("add_new_question_template_link"));
		Thread.sleep(4000);
		elementClick("xpath",Utility.fetchLocatorValue("save_button_template"));
		WebElement ele=locateElement("xpath",Utility.fetchLocatorValue("error_message"));
		String a=ele.getText();
		Assert.assertEquals(a, "Please enter a name for the template.");
		Thread.sleep(3000);
	}

}

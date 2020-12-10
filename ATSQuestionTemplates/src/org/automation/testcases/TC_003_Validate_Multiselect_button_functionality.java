package org.automation.testcases;

import java.io.IOException;
import java.util.Random;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.TakeScreenshot;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_Validate_Multiselect_button_functionality extends BaseClass
{
	
	@Test
	
	public void SelectAllButton() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_004_Validate_Multiselect_button_functionality", "TC_004_Validate_Multiselect_button_functionality");
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
		elementClick("xpath",Utility.fetchLocatorValue("active_template_checkbox"));
		Random r1=new Random();
		String TemplateName="QAEngineer";
		TemplateName += Integer.toString(r1.nextInt(9999));
		System.out.println("Template name generated is:"+TemplateName);
		elementSendText("xpath",Utility.fetchLocatorValue("template_name_text_field"),TemplateName);
		Thread.sleep(3000);
		elementClick("xpath",Utility.fetchLocatorValue("education_checkbox"));
		Thread.sleep(3000);
		elementClick("xpath",Utility.fetchLocatorValue("select_all_education_question_button"));
		Thread.sleep(3000);
		acceptAlert();
		//we.switchTo().defaultContent().navigate();
		Thread.sleep(4000);
		elementClick("xpath",Utility.fetchLocatorValue("experience_checkbox_template"));
		elementClick("xpath",Utility.fetchLocatorValue("select_all_experience_question_button"));
		acceptAlert();
		elementClick("xpath",Utility.fetchLocatorValue("select_all_additional_questions"));
		acceptAlert();
		elementClick("xpath",Utility.fetchLocatorValue("save_button_template"));
		TakeScreenshot.takesScreenshot(we, "After selecting all the question using Select All");
		WebElement ele=locateElement("xpath",Utility.fetchLocatorValue("template_saved_success_message"));
		String a=ele.getText();
		Assert.assertEquals(a, "The template has been successfully saved.");
		elementClick("xpath",Utility.fetchLocatorValue("deselect_all_experience_question_button"));
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(3000);
		elementClick("xpath",Utility.fetchLocatorValue("deselect_all_education_question_button"));
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(3000);
		elementClick("xpath",Utility.fetchLocatorValue("save_button_template"));
		Assert.assertEquals(a, "The template has been successfully saved.");
		Thread.sleep(3000);
	}

}

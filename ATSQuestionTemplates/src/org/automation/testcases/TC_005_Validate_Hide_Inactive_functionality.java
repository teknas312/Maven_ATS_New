package org.automation.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_Validate_Hide_Inactive_functionality extends BaseClass
{
	
	@Test
	
	public void HideInactiveCheckbox() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_006_Validate_Hide_Inactive_functionality", "TC_006_Validate_Hide_Inactive_functionality");
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
		Random r1=new Random();
		String TemplateName="QAEngineer";
		TemplateName += Integer.toString(r1.nextInt(9999));
		System.out.println("Template name generated is:"+TemplateName);
		elementSendText("xpath",Utility.fetchLocatorValue("template_name_text_field"),TemplateName);
		Thread.sleep(3000);
		elementClick("xpath",Utility.fetchLocatorValue("education_checkbox"));
		Thread.sleep(3000);
		elementClick("xpath",Utility.fetchLocatorValue("GPA_question"));
		elementClick("xpath",Utility.fetchLocatorValue("CityState_question"));
		elementClick("xpath",Utility.fetchLocatorValue("select_specific_education_question_button"));
		elementClick("xpath",Utility.fetchLocatorValue("experience_checkbox_template"));
		elementClick("xpath",Utility.fetchLocatorValue("Title/Position_question"));
		elementClick("xpath",Utility.fetchLocatorValue("From/To_question"));
		elementClick("xpath",Utility.fetchLocatorValue("Address_question"));
		elementClick("xpath",Utility.fetchLocatorValue("select_specific_experience_question_button"));
		elementClick("xpath",Utility.fetchLocatorValue("eeoc_checkbox_templates"));
		elementClick("xpath",Utility.fetchLocatorValue("disability_checkbox_template"));
		elementClick("xpath",Utility.fetchLocatorValue("select_all_additional_questions"));
		acceptAlert();
		elementClick("xpath",Utility.fetchLocatorValue("save_button_template"));
		elementClick("xpath",Utility.fetchLocatorValue("Return_to_Question_Templates_button"));
		Thread.sleep(3000);
		elementSendText("xpath",Utility.fetchLocatorValue("search_template_field"), TemplateName);
		elementClick("xpath",Utility.fetchLocatorValue("Hide_Inactive_checkbox"));
		elementClick("xpath",Utility.fetchLocatorValue("Filter_button"));
		WebElement ele=locateElement("xpath",Utility.fetchLocatorValue("searched_template"));
		String a=ele.getText();
		Assert.assertEquals(a, TemplateName);
		Thread.sleep(3000);
	
	}

}

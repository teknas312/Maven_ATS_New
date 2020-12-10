package org.automation.testcases;

import java.io.IOException;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_007_Validate_Fields_Application_Question_Tab extends BaseClass
{
	
	@Test
	public void validateFields() throws IOException, InterruptedException 
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_008_Validate_Fields_Application_Question_Tab", "TC_008_Validate_Fields_Application_Question_Tab");
		elementClick("xpath",Utility.fetchLocatorValue("applicants_tab"));
		/*Actions act=new Actions(we);
		WebElement ele=we.findElement(By.xpath("//a[contains(text(),'Positions')]"));
		act.moveToElement(ele).click().build().perform();*/
		mouseHover(Utility.fetchLocatorValue("applicant_positions_link"));
		int x=we.findElements(By.tagName("iframe")).size();
        System.out.println(x);
        we.switchTo().frame(1);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)we;
        js.executeScript("window.scrollBy(0,350)", "");
        //Thread.sleep(4000);
        elementClick("xpath",Utility.fetchLocatorValue("add_new_positions_link"));
        elementClick("xpath",Utility.fetchLocatorValue("application_questions_tab"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("select_template_droplist"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("edit_template_icon"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("education_checkbox"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("education_question_label"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("experience_checkbox"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("experience_questions_label"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("eeoc_checkbox"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("disability_checkbox"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("additional_questions_label"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("save_button"));
        ElementIsDisplayed("xpath",Utility.fetchLocatorValue("return_to_position"));
		Thread.sleep(5000);
		
		
	}

}

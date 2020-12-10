package org.automation.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.automation.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot extends BaseClass
{
	//For taking screenshots
	public static void takesScreenshot(WebDriver driver,String screenshotname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+screenshotname+".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
		
	}

}

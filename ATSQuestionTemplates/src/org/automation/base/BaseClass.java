package org.automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.Utilities.Constants;
import org.automation.pages.LoginPage;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass
{
	public static WebDriver we;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	private static Date date = new Date();
	private static String d=dateFormat.format(date);
	private static String filename="Summary"+d+".html";
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setUp()
	{
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(Constants.reportPath+filename);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","https://mumqa.altres.com:8443/hrsqa4/");
		extent.setSystemInfo("Tester Name","Sanket");
		extent.setSystemInfo("Browser","Chrome");
	}

	@BeforeMethod
	public void initiateDriverInstance() throws IOException, InterruptedException
	{
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			we=new ChromeDriver();
			we.manage().window().maximize();
			we.get(Utility.fetchPropertyValue("applicationURL"));
			Thread.sleep(3000);
			iFrameSwitch(0);
			LoginPage login=new LoginPage(we);
			login.enterUsername(Utility.fetchPropertyValue("username"));
			login.enterPassword(Utility.fetchPropertyValue("password"));
			login.clickSignin();
			Thread.sleep(4000);
			selectMethod("xpath",Utility.fetchLocatorValue("select_company_tab"), "Advantage Company One");
			elementClick("xpath",Utility.fetchLocatorValue("continue_button"));
		}

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			String screenshotPath = BaseClass.getScreenshot(we, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			String screenshotPath = BaseClass.getScreenshot(we, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		we.close();
	}


	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}

	public void elementClick(String elementType,String elementPath)
	{
		if(elementType.equalsIgnoreCase("xpath"))
		{
		we.findElement(By.xpath(elementPath)).click();
		}
		else if(elementType.equalsIgnoreCase("id"))
		{
			we.findElement(By.id(elementPath)).click();
		}
		else if(elementType.equalsIgnoreCase("classname"))
		{
			we.findElement(By.className(elementPath)).click();
		}
		else if(elementType.equalsIgnoreCase("linkText"))
		{
			we.findElement(By.linkText(elementPath)).click();
		}
	}

	public WebElement locateElement(String elementType, String elementPath)
	{
		WebElement ele1 = null;
		if(elementType.equalsIgnoreCase("xpath"))
		{
		ele1= we.findElement(By.xpath(elementPath));
		}
		else if(elementType.equalsIgnoreCase("id"))
		{
		ele1= we.findElement(By.id(elementPath));
		}
		else if(elementType.equalsIgnoreCase("classname"))
		{
		ele1= we.findElement(By.className(elementPath));
		}
		else if(elementType.equalsIgnoreCase("linkText"))
		{
		ele1= we.findElement(By.linkText(elementPath));
		}
		return ele1;
	}

	public void elementSendText(String elementType, String elementPath,String parameter)
	{
		if(elementType.equalsIgnoreCase("xpath"))
		{
		we.findElement(By.xpath(elementPath)).sendKeys(parameter);
		}
		else if(elementType.equalsIgnoreCase("id"))
		{
		we.findElement(By.id(elementPath)).sendKeys(parameter);
		}
		else if(elementType.equalsIgnoreCase("classname"))
		{
		we.findElement(By.className(elementPath)).sendKeys(parameter);
		}
		else if(elementType.equalsIgnoreCase("linkText"))
		{
		we.findElement(By.linkText(elementPath)).sendKeys(parameter);
		}
		
	}

	public void elementSendTextInteger(String elementType, String elementPath,int parameter)
	{
		if(elementType.equalsIgnoreCase("xpath"))
		{
		we.findElement(By.xpath(elementPath)).sendKeys(""+parameter);
		}
		else if(elementType.equalsIgnoreCase("id"))
		{
			we.findElement(By.id(elementPath)).sendKeys(""+parameter);
		}
		else if(elementType.equalsIgnoreCase("classname"))
		{
			we.findElement(By.className(elementPath)).sendKeys(""+parameter);
		}
		else if(elementType.equalsIgnoreCase("linkText"))
		{
			we.findElement(By.linkText(elementPath)).sendKeys(""+parameter);
		}
		
	}

	public void selectMethod(String elementType, String locator, String text) throws IOException
	{
		if(elementType.equalsIgnoreCase("xpath"))
		{
		Select s1=new Select(we.findElement(By.xpath(locator)));
		s1.selectByVisibleText(text);
		}
		else if(elementType.equalsIgnoreCase("id"))
		{
		Select s1=new Select(we.findElement(By.id(locator)));
		s1.selectByVisibleText(text);
		}
		else if(elementType.equalsIgnoreCase("classname"))
		{
		Select s1=new Select(we.findElement(By.className(locator)));
		s1.selectByVisibleText(text);
		}
		else if(elementType.equalsIgnoreCase("linkText"))
		{
		Select s1=new Select(we.findElement(By.linkText(locator)));
		s1.selectByVisibleText(text);
		}
	}

	public void ElementIsDisplayed(String elementType,String elementPath) throws IOException
	{
		if(elementType.equalsIgnoreCase("xpath"))
		{
		boolean status=we.findElement(By.xpath(elementPath)).isDisplayed();
		System.out.println("Status is:"+status);
		if(status==true)
		{
			System.out.println("Required element is displayed:"+elementPath);
			test.log(Status.PASS,"Required element is present:"+elementPath);

		}
		}
		else if(elementType.equalsIgnoreCase("id"))
		{
		boolean status=we.findElement(By.id(elementPath)).isDisplayed();
		System.out.println("Status is:"+status);
		if(status==true)
		{
			System.out.println("Required element is displayed:"+elementPath);
			test.log(Status.PASS,"Required element is present:"+elementPath);

		}
		}
		else if(elementType.equalsIgnoreCase("classname"))
		{
		boolean status=we.findElement(By.className(elementPath)).isDisplayed();
		System.out.println("Status is:"+status);
		if(status==true)
		{
			System.out.println("Required element is displayed:"+elementPath);
			test.log(Status.PASS,"Required element is present:"+elementPath);

		}
		}
		else if(elementType.equalsIgnoreCase("linkText"))
		{
		boolean status=we.findElement(By.linkText(elementPath)).isDisplayed();
		System.out.println("Status is:"+status);
		if(status==true)
		{
			System.out.println("Required element is displayed:"+elementPath);
			test.log(Status.PASS,"Required element is present:"+elementPath);

		}
		}
	}



	public void acceptAlert()
	{
		we.switchTo().alert().accept();
	}

	public void mouseHover(String xpath)
	{
		WebElement ele=we.findElement(By.xpath(xpath));
		Actions act=new Actions(we);
		act.moveToElement(ele).click().build().perform();

	}

	public void iFrameSwitch(int iframeNo)
	{
		int x=we.findElements(By.tagName("iframe")).size();
		System.out.println(x);
		we.switchTo().frame(iframeNo);
	}

	public void windowHandles(String key) throws IOException
	{
		String parent=we.getWindowHandle();
		System.out.println("Parent window's handle -> " + parent);
		elementClick("xpath",Utility.fetchLocatorValue(key));

		Set<String>s=we.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		//System.out.println("Window handle values are:"+I1.next());

		while(I1.hasNext())
		{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
				we.switchTo().window(child_window);

				System.out.println(we.switchTo().window(child_window).getTitle());
			}	
		}
	}



	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


}

package org.automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility 
{
	public static String fetchPropertyValue(String key) throws IOException
	{
		
			FileInputStream fis=new FileInputStream("./Config/config.properties");
			Properties pro=new Properties();
			pro.load(fis);
			return pro.get(key).toString();				
	} 
	
	public static String fetchLocatorValue(String key) throws IOException
	{
		
			FileInputStream fis=new FileInputStream("./Config/Element.properties");
			Properties pro=new Properties();
			pro.load(fis);
			return pro.get(key).toString();				
	} 
		
		
	}



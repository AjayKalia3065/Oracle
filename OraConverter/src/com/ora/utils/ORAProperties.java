package com.ora.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ORAProperties {


	private static final String PROP_FILE_NAME = "ConverterConfig.properties";
	static Properties properties = new Properties();
	private static int count;
	private static int fileRefreshRate = 20;
	private static String file = "";
	static {
		loadProperties();
	}
	static void loadProperties(){
			properties = new Properties();
		
		try {
			String l_user_home="";
			if ((l_user_home = System.getProperty("user.home")) == null) {
				System.out.println("User home is null");
				System.exit(1);
			}
			file = l_user_home + System.getProperty("file.separator") + PROP_FILE_NAME;
			System.out.println("File is "+ file);
			BufferedInputStream stream = new BufferedInputStream(
					new FileInputStream(file)
					);
			properties.load(stream);
			stream.close();
			System.out.println("Properties loaded");
			fileRefreshRate = Integer.parseInt(properties.getProperty("FileRefreshRate"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load property file");
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public static String getProperty(String propName){
		count++;
		if(count == fileRefreshRate )
		{
			loadProperties();
			count =0;
		}
		
		return properties.getProperty(propName);
	}
	public static String getConfigFile(){
		return file;
	}
}

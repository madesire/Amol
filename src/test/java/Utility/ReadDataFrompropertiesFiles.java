package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.devtools.v100.css.model.Value;

public class ReadDataFrompropertiesFiles {
	
	public static String readconfigdata(String datatobereaad) throws IOException {
		Properties prop = new Properties();
		FileInputStream propimput =  new FileInputStream("C:\\Users\\Rushi\\eclipse-workspace\\KiteZerodhaMaven\\config.properties");
		prop.load(propimput);
		String value = prop.getProperty(datatobereaad);
		System.out.println(value);
		return value;
	}

}

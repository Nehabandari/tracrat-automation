package tracratselenium.helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
			//FileInputStream input = new FileInputStream("config.properties");
			properties.load(input);
			input.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String getProperty(String propertyName) {
		if(System.getProperty(propertyName)!=null) {
			return System.getProperty(propertyName);
		}else {
			return properties.getProperty(propertyName);
		}
	}

}

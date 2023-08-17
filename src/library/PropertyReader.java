package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String fetchProperty(String key) throws IOException {
		
		FileInputStream f = new FileInputStream("./config//data.properties");
		Properties property = new Properties();
		property.load(f);
		return property.getProperty(key);
		
	}

	
	
}

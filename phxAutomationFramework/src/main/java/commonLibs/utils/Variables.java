package commonLibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

public class Variables {

	static String returnPropertyValue(String value) {
		Properties prop = new Properties();
		FileInputStream input = null;
		String propertyValue = null;

		File file = new File(System.getProperty("user.dir") + "/config/configFile.properties");

		try {
			input = new FileInputStream(file);
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		propertyValue = prop.getProperty(value);
		return propertyValue;

	}

	static String base64decode(String value) {
		String pass = returnPropertyValue(value);
		byte[] valueDecoded = Base64.decodeBase64(pass);
		value = new String(valueDecoded);
		return value;
	}

	public final static String url = returnPropertyValue("URL");
	public final static String WAIT_TIME = returnPropertyValue("WAIT_TIME");
	public final static String excel_fileName = returnPropertyValue("excel_fileName");
	public final static String driverExecution = returnPropertyValue("driverExecution");
	public final static String tcid = returnPropertyValue("tcid");
	public final static String tname = returnPropertyValue("tname");


}

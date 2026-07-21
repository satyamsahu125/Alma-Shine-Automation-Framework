package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * contains methods to read and write data from excel file
 */
public class PropertiesUtility{

	
	private FileInputStream file;
	private Properties properties;
	private String path;
	
	
	public PropertiesUtility(String path){
		
		this.path = path;
		try {
			file  = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		properties = new Properties();
		
		
		
		try {
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * read the data from the properties 
	 */
	public  String getData(String id) {
		return properties.getProperty(id);
	}
	
	
	
	
/**
 * write the data into file 
 */
	public void writeData(String key, String value) {
		properties.setProperty(key, value);
		
	}

	
	
	/**
	 * need to export to final save the file 
	 */
	public void saveData() {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			properties.store(fos, "Updated is successfull");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


package utilities;

import java.io.File;

public class FileUtility {

	    public static String getImagePath(String imageName) {
	        return System.getProperty("user.dir")
	                + File.separator
	                + "src"
	                + File.separator
	                + "test"
	                + File.separator
	                + "resources"
	                + File.separator
	                + "images"
	                + File.separator
	                + imageName;
	    }
	
}

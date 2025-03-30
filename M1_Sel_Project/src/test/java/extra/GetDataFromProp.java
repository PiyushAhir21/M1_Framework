package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromProp {

	public static void main(String[] args) throws IOException {
//		step : 1 => get java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\M1_Sel_Project\\src\\test\\resources\\commonData.properties");

//		Step : 2 => creating Properties class object, load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		by using getProperty() we will fetch the values
		String BROWSER = pObj.getProperty("bro");
		System.out.println(BROWSER);

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\User\\Basic_Selenium\\M1_Sel_Project\\src\\test\\resources\\commonData.properties");
		pObj.setProperty("lastname", "cena");
		pObj.store(fos, "no comment");
	}
}

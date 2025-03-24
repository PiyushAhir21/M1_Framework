package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FaceBook {
	@Test
	public void fb() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

//		Assert.assertTrue(true); // Hard assert => static method

//		soft assert
		SoftAssert sa = new SoftAssert();

		WebElement login = driver.findElement(By.linkText("Forgotten password?"));
		Boolean status = login.isDisplayed();

		sa.assertTrue(false);

		sa.assertAll();
		driver.close();
	}
}

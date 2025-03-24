package extra;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import object_repository.Sauce;

public class DataProviderExample {

	@Test(dataProvider = "getData")
	public void dataProvider(String username, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		Sauce sc = new Sauce(driver);
		sc.getLogin().click();

		
		Boolean verify = sc.getLogin().isDisplayed();
		
//		assertions => soft assert + Hard assert
		
//		Boolean verify = driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed();
//		if (verify) {
//			System.out.println("test script failed...");
//		}
		
		
		
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object arr[][] = new Object[2][2];
		arr[0][0] = "standard_user";
		arr[0][1] = "secret_sauce";

		arr[1][0] = "locked_out_user";
		arr[1][1] = "secret_sauce";
		return arr;
	}
}

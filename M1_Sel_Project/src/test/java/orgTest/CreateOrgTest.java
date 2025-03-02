package orgTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.VerifyOrgPage;

public class CreateOrgTest {

	// public static void main(String[] args) throws InterruptedException,
	// IOException {
	@Test
	public void createOrgTest() throws IOException, InterruptedException {

		FileUtility futil = new FileUtility();
		String BROWSER = futil.getDataFromPropFile("bro");
		String URL = futil.getDataFromPropFile("url");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

//		getting data from excel file
		String orgName = futil.getDataFromExcelFile("org", 2, 0) + (int) (Math.random() * 1000);

//		Launch the browser
		WebDriver driver;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, URL);

//		Creating Organization
//		driver.findElement(By.linkText("Organizations")).click();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);
//		Verification
//		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();

		VerifyOrgPage vop = new VerifyOrgPage(driver);

		String actOrgName = vop.getVON().getText();
		if (actOrgName.equals(orgName)) {
			Reporter.log("Organization created successfully !!!", true);
		} else {
			System.out.println("organization is not created");
		}

//		Log out
		hp.logOut();

		driver.close();
	}

}
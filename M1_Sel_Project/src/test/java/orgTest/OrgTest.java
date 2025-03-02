package orgTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class OrgTest {

	@Test(groups = "st")
		public void createOrgTest() throws IOException {
		FileUtility futil = new FileUtility();
		String BROWSER = futil.getDataFromPropFile("bro");
		String URL = futil.getDataFromPropFile("url");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

//	getting data from excel file
		String orgName = futil.getDataFromExcelFile("org", 2, 0) + (int) (Math.random() * 1000);

//	Launch the browser
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

//	Creating Organization
//	driver.findElement(By.linkText("Organizations")).click();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//	Verification
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
//		System.out.println("Organization created successfully !!!");
			Reporter.log("Organization created successfully !!!", true);
		} else {
			System.out.println("organization is not created");
		}

//	Log out
		hp.logOut();

		driver.close();
	}

	@Test(groups = "rt")
	public void createOrgWithIndustryTest() throws IOException {
		FileUtility futil = new FileUtility();
		String BROWSER = futil.getDataFromPropFile("bro");
		String URL = futil.getDataFromPropFile("url");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

//	getting data from excel file
		String orgName = futil.getDataFromExcelFile("org", 2, 0)+ (int) (Math.random() * 1000);
		String industry = futil.getDataFromExcelFile("org", 1, 2);

//	Launch the browser
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

//	Login
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, URL);

//	Creating Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		WebElement indSel = driver.findElement(By.name("industry"));
		Select sel = new Select(indSel);
		sel.selectByValue(industry);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//	Verification
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created successfully !!!");
		} else {
			System.out.println("organization is not created");
		}

		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.equals(industry)) {
			System.out.println("Industry given Successfully!!!");
		} else {
			System.out.println("Industry has not given !!!");
		}

//	Log out
		HomePage hp = new HomePage(driver);
		hp.logOut();

		driver.close();
	}

	@Test(groups = "rt")
	public void createOrgWithPhoneTest() throws IOException {
		FileUtility futil = new FileUtility();
		String BROWSER = futil.getDataFromPropFile("bro");
		String URL = futil.getDataFromPropFile("url");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

//		getting data from excel file
		String orgName = futil.getDataFromExcelFile("org", 2, 0)+ (int) (Math.random() * 1000);
		String phoneNum = futil.getDataFromExcelFile("org", 1, 1);

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
//		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, URL);

//		Login
//		WebElement un = driver.findElement(By.name("user_name"));
//		un.sendKeys(USERNAME);
//		lp.getUn().sendKeys(USERNAME);

//		WebElement pwd = driver.findElement(By.name("user_password"));
//		pwd.sendKeys(PASSWORD);
//		lp.getPwd().sendKeys(PASSWORD);

//		WebElement loginBtn = driver.findElement(By.id("submitButton"));
//		loginBtn.click();
//		lp.getLoginBtn().click();

//		Creating Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.id("phone")).sendKeys(phoneNum);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//		Verification
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created successfully !!!");
		} else {
			System.out.println("organization is not created");
		}

		String actPhoneNum = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhoneNum.equals(phoneNum)) {
			System.out.println("Phone number given successfully !!!");
		} else {
			System.out.println("Phone number is not given");

		}

//		Log out
		HomePage hp = new HomePage(driver);
		hp.logOut();

		driver.close();
	}
}

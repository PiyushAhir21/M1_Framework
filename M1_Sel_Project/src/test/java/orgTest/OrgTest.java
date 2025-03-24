package orgTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class OrgTest extends BaseClass {

	@Test(groups = "st")
	public void createOrgTest() throws IOException {

//	Creating Organization
//	driver.findElement(By.linkText("Organizations")).click();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		String orgName = new FileUtility().getDataFromExcelFile("org", 2, 0) + (int) (Math.random() * 1000);

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

	}

	@Test(groups = "rt")
	public void createOrgWithIndustryTest() throws IOException {

		String industry = new FileUtility().getDataFromExcelFile("org", 1, 2);
		String orgName = new FileUtility().getDataFromExcelFile("org", 1, 0) + (int) (Math.random() * 1000);

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

	}

	@Test(groups = "rt")
	public void createOrgWithPhoneTest() throws IOException {

		String phoneNum = new FileUtility().getDataFromExcelFile("org", 1, 1);
		String orgName = new FileUtility().getDataFromExcelFile("org", 1, 0) + (int) (Math.random() * 1000);

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

	}
}

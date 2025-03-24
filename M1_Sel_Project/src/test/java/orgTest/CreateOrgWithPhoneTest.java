package orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;

public class CreateOrgWithPhoneTest extends BaseClass{

//	public static void main(String[] args) throws InterruptedException, IOException {

	@Test
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
package orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import object_repository.HomePage;
import object_repository.VerifyOrgPage;

public class CreateOrgTest extends BaseClass {

	// public static void main(String[] args) throws InterruptedException,
	// IOException {
	@Test
	public void createOrgTest() throws IOException, InterruptedException {

//		Launch the browser

//		Login

//		Creating Organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		getting data from excel file
		String orgName = futil.getDataFromExcelFile("org", 2, 0) + (int) (Math.random() * 1000);
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);
//		Verification
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getVON().getText();
		if (actOrgName.equals(orgName)) {
			Reporter.log("Organization created successfully !!!", true);
		} else {
			System.out.println("organization is not created");
		}

//		Log out

//		Closing Browser
	}

}
package orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;

public class CreateOrgWithIndTest extends BaseClass {

//	public static void main(String[] args) throws InterruptedException, IOException {
		@Test
		public void createOrgWithIndustryTest() throws IOException {

			String industry = new FileUtility().getDataFromExcelFile("org", 1, 2);
			String orgName = new FileUtility().getDataFromExcelFile("org", 1, 0) + (int) (Math.random() * 1000);

			
//		Creating Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		WebElement indSel = driver.findElement(By.name("industry"));
		Select sel = new Select(indSel);
		sel.selectByValue(industry);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//		Verification
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

}
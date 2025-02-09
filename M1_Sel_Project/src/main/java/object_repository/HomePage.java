package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement conLink;

	public WebElement getConLink() {
		return conLink;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profileBtn;

	public WebElement getProfileBtn() {
		return profileBtn;
	}
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void logOut() {
		Actions act = new Actions(driver);
		act.moveToElement(getProfileBtn()).build().perform();
		
		getSignOutLink().click();
	}

}

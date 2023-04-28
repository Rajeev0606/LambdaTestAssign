package PageDrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityDrive.Utils;

public class Scenario1 extends Utils {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Simple Form Demo']")
	WebElement sfd;
	
	@FindBy(xpath = "//h1[text()='Simple Form Demo']")
	WebElement title;
	
	@FindBy(id = "user-message")
	WebElement enterMessage;
	
	@FindBy(id = "showInput")
	WebElement getCheckValue;
	
	@FindBy(id = "message")
	WebElement yourMessage;

	public Scenario1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSimpleFormDemo() {
		sfd.click();
	}
	public boolean validation() {
		return title.isDisplayed();
	}
	public void textEnterMessage(String InputMessage) {
		enterMessage.sendKeys(InputMessage);
	}
	public void clickGetCheckedValueButton() {
		getCheckValue.click();
	}
	public boolean ResultMessage() {
		return yourMessage.isDisplayed();
		
	}
	
	


}

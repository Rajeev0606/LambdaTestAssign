package PageDrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityDrive.Utils;

public class Scenario3 extends Utils {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Input Form Submit']")
	WebElement ifs;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement submitbutton;
	
	@FindBy(id = "name")
	WebElement nameBox;
	
	@FindBy(id = "inputEmail4")
	WebElement emailBox;
	
	@FindBy(id = "inputPassword4")
	WebElement passwordbox;
	
	@FindBy(id = "company")
	WebElement companybox;
	
	@FindBy(id = "websitename")
	WebElement websitebox;
	
	@FindBy(xpath = "//select[@name='country']")
	WebElement countrybox;
	
	@FindBy(id = "inputCity")
	WebElement citybox;
	
	@FindBy(id = "inputAddress1")
	WebElement addressbox1;
	
	@FindBy(id = "inputAddress2")
	WebElement addressbox2;
	
	@FindBy(id = "inputState")
	WebElement statebox;
	
	@FindBy(id = "inputZip")
	WebElement zipcodebox;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement submitbutton1;
	
	@FindBy(xpath = "//p[@class='success-msg hidden']")
	WebElement successMsg;
	
	public Scenario3(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickInputFormSubmit() {
		ifs.click();
	}
	public void clickSubmit() {
		submitbutton.click();
		//System.out.println(driver.switchTo().alert().getText());
	}

	 public void fillForm(String Name, String EmailId, String Password, String Company, String website) {
		 nameBox.sendKeys(Name);
		 emailBox.sendKeys(EmailId);
		 passwordbox.sendKeys(Password);
		 companybox.sendKeys(Company);
		 websitebox.sendKeys(website);
		 //countrybox.sendKeys(CountryName);
	 }
	 public void SelectCountry(String country) {
		 Select countrysel = new Select(countrybox);
		 countrysel.selectByValue(country);
				 
	 }
	 public void fillForms(String addr1, String addr, String cityName, String stateName, String zipCode) {
		 citybox.sendKeys(cityName);
		 addressbox1.sendKeys(addr);
		 addressbox2.sendKeys(addr1);
		 statebox.sendKeys(stateName);
		 zipcodebox.sendKeys(zipCode);
	 }
	 public void clicksubmit1() {
		 submitbutton1.click();
	 }

	public String getFormResponseMessage1() {
		return successMsg.getText();
		
		
	}

}
